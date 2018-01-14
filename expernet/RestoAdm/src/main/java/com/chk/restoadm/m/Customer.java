/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.DiscriminatorFormula;

/**
 *
 * @author archey
 */
@Entity
@DiscriminatorValue("c")
public class Customer extends Util{
    
    public Customer() {
    }
    
    
}
