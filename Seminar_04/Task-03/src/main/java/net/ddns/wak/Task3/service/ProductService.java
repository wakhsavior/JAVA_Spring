package net.ddns.wak.Task3.service;

import net.ddns.wak.Task3.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> findAll(){
        return products;
    }
}
