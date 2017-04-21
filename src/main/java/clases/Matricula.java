/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author chiti
 */
public class Matricula {
    private String id;
    private String fecha;
    private BigDecimal valorMatricula= BigDecimal.ZERO; 
    private BigDecimal valorMensualidad= BigDecimal.ZERO;
    private BigDecimal numMeses= BigDecimal.ZERO;
    private char estado;
    private String curso;
    private String nombre;
    private String apellido;
    private String categoria; 
    private BigDecimal totalCurso = BigDecimal.ZERO; 

    public Matricula() {
    }

    public BigDecimal getTotalCurso() {
        
        totalCurso= valorMatricula.add(valorMensualidad.multiply(numMeses)).setScale(2);
        return totalCurso;
    }

    public void setTotalCurso(BigDecimal totalCurso) {
        this.totalCurso = totalCurso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
