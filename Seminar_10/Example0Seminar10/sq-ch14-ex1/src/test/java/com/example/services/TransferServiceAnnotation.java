package com.example.services;

import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TransferServiceAnnotation")
public class TransferServiceAnnotation {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private TransferService transferService;
    @Test
    public void moneyTransferSimpleUnitTest() {
        // Предпосылка
        Account senderAccount = new Account();
        Account receiverAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));
        receiverAccount.setId(2);
        receiverAccount.setAmount(new BigDecimal(2000));

        given(accountRepository.findById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
        given(accountRepository.findById(receiverAccount.getId())).willReturn(Optional.of(receiverAccount));

        // Вызов

        transferService.transferMoney(senderAccount.getId(), receiverAccount.getId(), new BigDecimal(500));

        // Проверка

        verify(accountRepository).changeAmount(senderAccount.getId(), new BigDecimal(500));
        verify(accountRepository).changeAmount(receiverAccount.getId(), new BigDecimal(2500));
    }
    @Test
    @DisplayName("MoneyTransferAccountNotfound")
    public void moneyTransferAccountNotFound(){
        Account senderAccount = new Account();

        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));


        given(accountRepository.findById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        // Вызов

        assertThrows(AccountNotFoundException.class,()->transferService.transferMoney(1,2,new BigDecimal(500)));

        // Проверка

        verify(accountRepository,never()).changeAmount(anyLong(),any());

    }
}
