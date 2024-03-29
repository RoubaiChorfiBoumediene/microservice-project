package com.ecommerce.microcommerce.Controller;

import com.ecommerce.microcommerce.DAO.ProductDao;
import com.ecommerce.microcommerce.Exceptions.ProduitIntrouvableException;
import com.ecommerce.microcommerce.Model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @RequestMapping(value = "/Products", method = RequestMethod.GET)
    public MappingJacksonValue liseProducts() {
        List<Product> product = productDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue productsFilters = new MappingJacksonValue(product);
        productsFilters.setFilters(listDeNosFiltres);

        return productsFilters;
    }


    //produit /{id}
    @GetMapping(value = "Product/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        Product product=  productDao.findById(id);
        if(product==null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
        return product;

    }
    @GetMapping(value = "Products/{prix}")
    public List<Product> afficherProduitSupp(@PathVariable int prix ){
        return productDao.findByPrixGreaterThan(prix);
    }
    @GetMapping(value = "test/produits/{recherche}")
    public List<Product> testeDeRequetes(@PathVariable String recherche) {
        return productDao.findByproduitLike("%"+recherche+"%");
    }

    //CRUD METHODES
    @PostMapping(value = "Products")
    public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Product product) {
        Product productAdded = productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (value = "/ProduitDel/{id}")
    public void supprimerProduit(@PathVariable int id) {
        productDao.deleteById(id);
    }
}

