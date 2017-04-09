/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author Seeting
 */
public class Alumno extends Persona{
    private String nombreRepresentante;
    private String apellidoRepresentante;
    private String relacion;

    public Alumno(String nombreRepresentante, String apellidoRepresentante, String relacion, String cedula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String direccion, String telefono, String celular, Date fechaNac) {
        super(cedula, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, telefono, celular, fechaNac);
        this.nombreRepresentante = nombreRepresentante;
        this.apellidoRepresentante = apellidoRepresentante;
        this.relacion = relacion;
    }

    public Alumno() {
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getApellidoRepresentante() {
        return apellidoRepresentante;
    }

    public void setApellidoRepresentante(String apellidoRepresentante) {
        this.apellidoRepresentante = apellidoRepresentante;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    
    
    
}
