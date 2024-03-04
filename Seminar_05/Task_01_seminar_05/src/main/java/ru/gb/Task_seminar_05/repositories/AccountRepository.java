package ru.gb.Task_seminar_05.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import ru.gb.Task_seminar_05.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);


}
