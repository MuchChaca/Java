/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpatemplate;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author archey
 */
@Entity
public class Ticket implements Serializable{
    @Id
    private long id;
    private String nom;

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
    
    
    // GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
