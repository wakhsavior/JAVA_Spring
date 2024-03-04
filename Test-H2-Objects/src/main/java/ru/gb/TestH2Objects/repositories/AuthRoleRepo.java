package ru.gb.TestH2Objects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.TestH2Objects.model.AuthRole;

public interface AuthRoleRepo extends JpaRepository<AuthRole,Integer> {
}
