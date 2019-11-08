package com.ecommerce.microcommerce.Controller;

import com.ecommerce.microcommerce.DAO.ProductDao;
import com.ecommerce.microcommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
@Autowired
    private ProductDao productDao;

    //produit
    @GetMapping(value = "Products")
    public List<Product> productList(){
        return productDao.fintAll();
    }
    //produit /{id}
    @GetMapping(value= "Products/{id}")
    public Product afficherUnProduit (@PathVariable int id ){

        return productDao.findById(id);
    }
    @PostMapping(value = "Products")
    public void ajouterProduit(@RequestBody Product product){
        productDao.save(product);
    }
}
