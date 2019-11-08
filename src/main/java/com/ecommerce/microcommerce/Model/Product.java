package com.ecommerce.microcommerce.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product {
    private int id ;
    private String produit ;
    private int prix ;
    @JsonIgnore
    private int prixAchat;


    public Product() {
    }

    public Product(int id, String produit, int prix,int prixAchat) {
        this.setId(id);
        this.setProduit(produit);
        this.setPrix(prix);
        this.setPrixAchat(prixAchat);
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
    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + produit + '\'' +
                ", prix=" + prix +
                '}';
    }
}
