package ru.gb.Ex2Sem6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Ex2Sem6.model.Reader;

public interface ReaderRepo extends JpaRepository<Reader,Long> {
}
