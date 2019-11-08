package com.ecommerce.microcommerce.Model;


public class Product {
    private int id ;
    private String produit ;
    private int prix ;

    public Product() {
    }

    public Product(int id, String produit, int prix) {
        this.setId(id);
        this.setProduit(produit);
        this.setPrix(prix);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
