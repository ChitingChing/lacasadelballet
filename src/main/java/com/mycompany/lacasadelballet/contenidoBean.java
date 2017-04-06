/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lacasadelballet;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chiti
 */
@Named(value = "contenidoBean")
@SessionScoped
public class contenidoBean implements Serializable {

    /**
     * Creates a new instance of contenidoBean
     */
    private String page ="/templates/content.xhtml";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public contenidoBean() {
    }
    
}
