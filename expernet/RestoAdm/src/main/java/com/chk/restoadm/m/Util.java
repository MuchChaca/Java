/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chk.restoadm.m;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 *
 * @author archey
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="type_user")
public class Util extends Model{
    @Id
    private long id;
    private String login;
    private String passwd;
    private String email;
    private String tel;

    public Util() {
    }

    
    
    
    // GETTERS & SETTERS
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", passwd=" + passwd + ", email=" + email + ", tel=" + tel + '}';
    }
    
    
}
