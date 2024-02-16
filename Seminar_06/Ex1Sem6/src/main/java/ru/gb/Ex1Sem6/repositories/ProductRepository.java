package ru.gb.Ex1Sem6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Ex1Sem6.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
