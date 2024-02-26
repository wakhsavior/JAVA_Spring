package com.example.services;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TransferServiceIntegration {
    @MockBean
    private AccountRepository accountRepository;
    @Autowired
    private TransferService transferService;
    @Test
    @DisplayName("moneyTransferTest")
    public void moneyTransferSimpleUnitTest() {
        // Предпосылка
//        AccountRepository accoutRepository = mock(AccountRepository.class);
//        TransferService transferService = new TransferService(accoutRepository);
        Account senderAccount = new Account();
        Account receiverAccount = new Account();
        senderAccount.setId(1);
        senderAccount.setAmount(new BigDecimal(1000));
        receiverAccount.setId(2);
        receiverAccount.setAmount(new BigDecimal(2000));

        given(accountRepository.findById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
        given(accountRepository.findById(receiverAccount.getId())).willReturn(Optional.of(receiverAccount));

        // Вызов

        transferService.transferMoney(senderAccount.getId(),receiverAccount.getId(),new BigDecimal(500));

        // Проверка

        verify(accountRepository).changeAmount(senderAccount.getId(),new BigDecimal(500));
        verify(accountRepository).changeAmount(receiverAccount.getId(),new BigDecimal(2500));
    }
}
