package com.mycompany.jpatemplate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Ticket t = new Ticket();
        t.setId(5L);
        t.setNom("1er essai");
        
        // Create
//        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//        em.getTransaction().begin();
//        
//        em.persist(t);
//        
//        em.getTransaction().commit();
//        em.close();
//        PersistenceManager.INSTANCE.close();

/////////////////////////////////////////////////////////////////

//        // Find
//        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//        
//        Ticket tFind = em.find(Ticket.class, 5L); // utilisable que avc cle primare
//        
//        System.out.println(tFind);
//           PersistenceManager.INSTANCE.close();
/////////////////////////////////////////////////////////////////
//      //  JPQL
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        // ------------
//        Query req = em.createQuery("SELECT t from Ticket as t");
//        
//        
//        List<Ticket> tickets = req.getResultList();
//        
//        for(Ticket ticket:tickets){
//            System.out.println(""+ticket.toString());
//        }
        
//      // ----------
        TypedQuery<Ticket> req = em.createQuery("SELECT t FROM Ticket as t where id=:id", Ticket.class);
        req.setParameter("id", 6L);
        
        // if want only one result, ex:
        Ticket tick = req.getSingleResult();
        // req.setFirstResult(0).setMaxResults(10); // example: get the 10 first results
        em.close();
        PersistenceManager.INSTANCE.close();
        System.out.println(tick);
        
        
    }
}
