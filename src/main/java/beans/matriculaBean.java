/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Alumno;
import clases.Matricula;
import datos.Conexion;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Seeting
 */
@Named(value = "matriculaBean")
@ViewScoped
public class matriculaBean implements Serializable{

    /**
     * Creates a new instance of matriculaBean
     */
    private List<Matricula> matriculas;
    private String alumno;
    private Matricula matriculaSeleccionada;
    

    public Matricula getMatriculaSeleccionada() {
        return matriculaSeleccionada;
    }

    public void setMatriculaSeleccionada(Matricula matriculaSeleccionada) {
        this.matriculaSeleccionada = matriculaSeleccionada;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    

    public matriculaBean() {
    }

    public void buscar() {
        
        matriculas = new ArrayList<>();
        
        Conexion con = new Conexion();
        ResultSet rs = con.ejecutarProcedimientoPg("getmatriculas", alumno);
        try {
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setCurso(rs.getString("curso"));
                m.setFecha(rs.getString("fechacurso"));   
                matriculas.add(m);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // m.getMatriculas(Alumno);
       
    }

}
