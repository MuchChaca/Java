/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Gives access to database interaction through static methods
 * @author archey
 * @param <T>
 */
public abstract class DB {
    
    // ================= - CRUD - ================= //
    
    /**
     * <h2>Retrieves all entries of the table associated to the Class provided</h2>
     * <b><i>Example:</i></b>
     * <pre><em>ArrayList<Util> obj = DB.findAll(Util.class);</em></pre>
     * @param <T> The type
     * @param c The name of the class must be the one tagged with @Entity
     * @return ArrayList<Object is T>
     */
    public static<T> ArrayList<T> findAll(Class c){
//        System.out.println(table.toString());
        ArrayList<T> listAll = new ArrayList<T>();
        String table = c.getSimpleName();
        
        EntityManager em = DB.openInstance();
        
        String query = String.format("SELECT o FROM %s as o ", table);
        
        TypedQuery<T> q = em.createQuery(query, c);
        
        listAll.addAll(q.getResultList());
        
        DB.closeInstance(em);
        return listAll;
    }
    
    /**
     * <h2>Find an entry in the database from the Class and the id</h2>
     * <b><i>Example:</i></b>
     * <pre><em>Util obj = DB.findOne(Util.class, 0L);</em></pre>
     * @param <T> The type of the Object
     * @param c Class tagged with @Entity
     * @param id The id of the row to fetch
     * @return <Object is T>
     */
    public static<T> T findOne(Class c, long id){
        
        EntityManager em = DB.openInstance();
        
        String query = String.format("SELECT o FROM %s as o WHERE o = :id", c.getSimpleName());
        TypedQuery<T> q = em.createQuery(query, c);
        q.setParameter("id", id);
        T obj = q.getSingleResult();
        
        DB.closeInstance(em);
        
        return obj;
    }
    
    public static<T> boolean delOne(T obj){
        
        EntityManager em = DB.openTransaction();
        
        try{
            em.remove(obj);
        } catch (Exception ex){
            System.out.println("Error while deleting\n" + ex.toString());
        }finally{
            DB.closeTransaction(em);
            System.out.println("Deletion succeed");
            return true;
        }
    }
    
    
    // ================= - EntityManager - ================= //
    
    /**
     * <h2>WHEN <u>WRITING</u> TO THE DATABASE</h2>
     * <ul><li>Make an instance of the EntityManager</li>
     * <li>Open a transaction </li></ul>
     * @return EntityManager
     */
   private static EntityManager openTransaction(){
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        return em;
    }
   
   /**
    * <h2>WHEN <u>READING</u> TO THE DATABASE</h2>
    * Make an instance of the EntityManager
    * @return EntityManager
    */
    private static EntityManager openInstance(){
        return PersistenceManager.INSTANCE.getEntityManager();
    }
    
    /**
     * Close the EntityManager
     * Close the PersistenceManager
     * @param em The EntityManager to close
     */
    private static void closeInstance(EntityManager em){
        em.close();
        PersistenceManager.INSTANCE.close();
    }
    
    /**
     * <ul><li><strong>Commit first</strong></li>
     * <li>Then close the EntityManager</li>
     * <li>Close the PersistenceManager</li></ul>
     * @param em The EntityManager to close
     */
    private static void closeTransaction(EntityManager em){
        em.getTransaction().commit();
        em.close();
        PersistenceManager.INSTANCE.close();
    }
    
}
