package net.ddns.wak.Java.Spring.repository;

import net.ddns.wak.Java.Spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
