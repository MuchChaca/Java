/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author archey
 */
public abstract class Model implements Serializable{
    /**
     * 
     * @param c Class is the table to take data from
     * @return 
     */
    public static ArrayList<Model> findAll(Class c){
        String className = c.getSimpleName();
        ArrayList<Model> toReturn = new ArrayList<Model>();
        // code
        EntityManager em = Model.openInstance();
        String query = "SELECT t FROM " + className + " as t";
        TypedQuery<Model> req = em.createQuery(query, c);
        
        List<Model> allMod = req.getResultList();
//        Model.closeInstance(em);
        return toReturn;
    }
    
    public static EntityManager openTransaction(){
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        return em;
    }
    public static EntityManager openInstance(){
        return PersistenceManager.INSTANCE.getEntityManager();
    }
    public static void closeInstance(EntityManager em){
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
