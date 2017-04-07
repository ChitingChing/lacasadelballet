/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lacasadelballet;

import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

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
        System.out.println(page);
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
        
    
}
