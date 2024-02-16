package ru.gb.Ex1Sem6.services;

import ru.gb.Ex1Sem6.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);

    void deleteProductById(Long id);
}
