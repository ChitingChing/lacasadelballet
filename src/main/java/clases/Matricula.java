/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import accesodatos.Conexion;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author chiti
 */
public class Matricula {
    private int id;
    private Date fecha;
    private BigDecimal valorMatricula; 
    private BigDecimal valorMensualidad;
    private BigDecimal numMeses;
    private char estado;
    private int idCurso;
    private int idAlumno;
    private int idCategoria;        

    public Matricula(int id, Date fecha, BigDecimal valorMatricula, BigDecimal valorMensualidad, BigDecimal numMeses, char estado, int idCurso, int idAlumno, int idCategoria) {
        this.id = id;
        this.fecha = fecha;
        this.valorMatricula = valorMatricula;
        this.valorMensualidad = valorMensualidad;
        this.numMeses = numMeses;
        this.estado = estado;
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        this.idCategoria = idCategoria;
    }

    public Matricula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(BigDecimal valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public BigDecimal getValorMensualidad() {
        return valorMensualidad;
    }

    public void setValorMensualidad(BigDecimal valorMensualidad) {
        this.valorMensualidad = valorMensualidad;
    }

    public BigDecimal getNumMeses() {
        return numMeses;
    }

    public void setNumMeses(BigDecimal numMeses) {
        this.numMeses = numMeses;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public List<Matricula> getMAtriculas(String Alumno){
        Conexion con = new Conexion();
        
        return null;
    }
}
