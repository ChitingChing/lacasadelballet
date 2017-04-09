/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lacasadelballet;

import clases.Alumno;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Seeting
 */
@Named(value = "matriculaBean")
@ViewScoped
public class matriculaBean {

    /**
     * Creates a new instance of matriculaBean
     */
    private List<String> matriculas;
    public matriculaBean() {
    }
    public void buscarMatriculasPorPersona(){
        
        Alumno a= new Alumno();
        
    }
    
}
