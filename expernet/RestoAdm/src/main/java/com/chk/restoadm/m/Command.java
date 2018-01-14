/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author archey
 */
@Entity
public class Command extends Model{
    @Id
    private long id;
    private Date dateOrder;
    private Date dateDelivPlan;
    private Date dateDelivAct;
    @ManyToMany
    private Collection<Product> products;

    public Command() {
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

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivPlan() {
        return dateDelivPlan;
    }

    public void setDateDelivPlan(Date dateDelivPlan) {
        this.dateDelivPlan = dateDelivPlan;
    }

    public Date getDateDelivAct() {
        return dateDelivAct;
    }

    public void setDateDelivAct(Date dateDelivAct) {
        this.dateDelivAct = dateDelivAct;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
    
}
