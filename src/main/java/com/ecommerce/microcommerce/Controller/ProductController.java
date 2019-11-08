package com.ecommerce.microcommerce.Controller;

import com.ecommerce.microcommerce.DAO.ProductDao;
import com.ecommerce.microcommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){
        Product productAdded =  productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    }

