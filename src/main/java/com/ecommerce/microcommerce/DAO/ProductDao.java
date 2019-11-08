package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> fintAll();
    public Product findById(int id);
    public Product save (Product product);
}
