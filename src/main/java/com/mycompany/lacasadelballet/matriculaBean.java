/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lacasadelballet;

import clases.Alumno;
import clases.Matricula;
import java.sql.ResultSet;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Seeting
 */
@Named(value = "matriculaBean")
@Dependent
public class matriculaBean {

    /**
     * Creates a new instance of matriculaBean
     */
    private List<String> matriculas;
    private String alumnoAbuscar;

    public String getAlumnoAbuscar() {
        return alumnoAbuscar;
    }

    public void setAlumnoAbuscar(String alumnoAbuscar) {
        this.alumnoAbuscar = alumnoAbuscar;
    }
    
    

    public matriculaBean() {
    }

    public List<String> buscar() {

        Alumno alumno = new Alumno();
        Conexion con = new Conexion();
        ResultSet rs = con.ejecutarProcedimientoPg("getmatriculas", alumnoAbuscar);
        try {
            while (rs.next()) {
                System.out.println(rs.getString(0));
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
        }

        // m.getMatriculas(Alumno);
        return matriculas;
    }

}
