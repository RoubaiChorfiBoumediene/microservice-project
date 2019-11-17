package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product findById(int Id);
    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByproduitLike(String recherche);


}
