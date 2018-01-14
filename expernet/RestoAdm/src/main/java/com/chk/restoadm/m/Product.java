/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author archey
 */
@Entity
public class Product extends Model{
    @Id
    private long id;
    private String name;
    private String description;
    private String type;
    private String taille;
    @OneToMany
    private Collection<Tarif> prices;
    @OneToMany
    private Collection<Image> images;
    @ManyToMany
    private Collection<Command> orders;

    public Product() {
    }
    
    
    // ============= - GETTERS & SETTERS - ============= //

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public Collection<Tarif> getPrices() {
        return prices;
    }

    public void setPrices(Collection<Tarif> prices) {
        this.prices = prices;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Collection<Command> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Command> orders) {
        this.orders = orders;
    }

    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", taille=" + taille + ", prices=" + prices + ", images=" + images + ", orders=" + orders + '}';
    }
}
