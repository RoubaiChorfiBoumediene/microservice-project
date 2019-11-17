package com.ecommerce.microcommerce.Model;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
//@JsonFilter("monFiltreDynamique")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Length(min=3, max=20, message = "Nom trop long ou trop court. Et oui messages sont plus stylés que ceux de Spring")
    private String produit;
    private int prix;
    private int prixAchat;


    public Product() {
    }

    public Product(int id, String produit, int prix, int prixAchat) {
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
