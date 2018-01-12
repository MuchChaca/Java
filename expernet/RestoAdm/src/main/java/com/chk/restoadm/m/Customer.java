/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author archey
 */
@Entity
@DiscriminatorValue("c")
public class Customer extends Util{
    private String adresse;

    
    
    // GETTERS & SETTERS
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
}
