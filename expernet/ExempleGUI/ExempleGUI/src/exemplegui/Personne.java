 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplegui;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rlegros.cdi
 */
public class Personne implements Comparable<Personne> {
    
    private String nom;
    private String prenom;
    private Date datenais;

    public Personne() {
    }
    
    public Personne(String nom, String prenom, Date datenais) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenais = datenais;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("EEEE dd MMMMM yyyy");
        String dateString = sf.format(datenais);
        return nom + ", " + prenom + ", " + dateString;
    }
   
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the datenais
     */
    public Date getDatenais() {
        return datenais;
    }

    /**
     * @param datenais the datenais to set
     */
    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    @Override
    public int compareTo(Personne o) {
        if(datenais.after(o.getDatenais())){ return 1; }    
        else if(datenais.equals(o.getDatenais())) { return 0; }
        else { return -1; }
    }
 
//        if(this.getPrenom().length() == o.getPrenom().length()) return 0;
//        if(this.getPrenom().length()> o.getPrenom().length()) return 1;
//        else return -1;
//    }
        
}
