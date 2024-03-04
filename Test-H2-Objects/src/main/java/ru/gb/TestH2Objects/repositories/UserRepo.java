package ru.gb.TestH2Objects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.TestH2Objects.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
}
