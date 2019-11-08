package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<Product> products =new ArrayList<>();

    static {
        products.add(new Product(1,new String("Ordinateur portable "),350));
        products.add(new Product(2,new String("portable "),450));
        products.add(new Product(3,new String("télévision "),550));
        products.add(new Product(4,new String("machine a lavez "),650));

    }
    @Override
    public List<Product> fintAll(){
     return products;
    }
    @Override
    public Product findById(int id){
        for (Product product : products) {
            if(product.getId()==id ){
                return product;
            }
        }return null ;
    }
    @Override
    public Product save (Product product){
        products.add(product);
        return product;
    }
}
