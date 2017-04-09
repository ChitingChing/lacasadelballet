/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lacasadelballet;

import clases.Alumno;
import clases.Matricula;
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
    public List<String> buscarMatriculasPorPersona(String Alumno){
        
        Matricula m = new Matricula();
       // m.getMatriculas(Alumno);
        return matriculas;
    }
    
}
