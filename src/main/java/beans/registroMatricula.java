/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Alumno;
import clases.Matricula;
import clases.Pago;
import datos.Conexion;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Seeting
 */
@Named(value = "registroMatricula")
@ViewScoped
public class registroMatricula implements Serializable {

    /**
     * Creates a new instance of registroMatricula
     */
    private Matricula matricula;
    private Alumno alumno;
    private Pago pago;

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public registroMatricula() {
    }

    public void guardarMatricula() {
        try {
            String sql;
            Conexion cn = new Conexion();
            sql = "INSERT INTO public.alumno( apellido, nombre, fechanac,  apellidorepresentante, nombrerepresentante, relacion, telefono) "
                    + "VALUES (" + alumno.getPrimerApellido() + " " + alumno.getSegundoApellido() + " , " + alumno.getPrimerNombre() + " " + alumno.getSegundoNombre() + ","
                    + " " + alumno.getFechaNac() + "," + alumno.getApellidoRepresentante() + " , " + alumno.getNombreRepresentante() + "," + alumno.getRelacion() + ", " + alumno.getTelefono() + ");";
            sql += "INSERT INTO public.matricula(fecha, valormatricula, valormensualidad, nummeses, estado, idcurso, idalumno, idcategoria) "
                    + "values("+matricula.getFecha()+","+matricula.getValorMatricula()+","+matricula.getValorMensualidad()+","+matricula.getNumMeses()+",1,"+matricula.getCurso()+","
                    + "IDALUMNO,IDCATEGORIA);";
            sql += "insert into pago () values();";
            cn.Insertar("");
        } catch (Exception e) {
        }

    }

}
