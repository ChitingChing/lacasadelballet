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
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class matriculaBean implements Serializable {

    /**
     * Creates a new instance of matriculaBean
     */
    private List<Matricula> matriculas;
    private String alumno;
    private Matricula matriculaSeleccionada;
    private List<Pago> pagos;
    private BigDecimal totalPagos = BigDecimal.ZERO;
             

    public void setTotalPagos(BigDecimal totalPagos) {
        this.totalPagos = totalPagos;
    }

    public BigDecimal getTotalPagos() {
        return totalPagos;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

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
        matriculaSeleccionada = null;
        matriculas = null;
        pagos = null;
        alumno = "";
    }

    public void buscarMatriculas() {

        try {
            matriculas = new ArrayList<>();
            Conexion con = new Conexion();
            ResultSet rs = con.ejecutarProcedimientoPg("getmatriculas", alumno);
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setId(rs.getString("id"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setCurso(rs.getString("curso"));
                m.setFecha(rs.getString("fechacurso"));
                m.setValorMensualidad(rs.getBigDecimal("valormen"));
                m.setNumMeses(rs.getBigDecimal("nummeses"));
                m.setValorMatricula(rs.getBigDecimal("valormat"));
                matriculas.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        // m.getMatriculas(Alumno);
    }

    public void buscarPagosMatricula() {

        try {
            if (matriculaSeleccionada != null) {
                totalPagos = new BigDecimal("0.00");
                Conexion con = new Conexion();
                pagos = new ArrayList<>();
                ResultSet rs = con.ejecutarProcedimientoPg("getpagosmatricula", matriculaSeleccionada.getId());
                while (rs.next()) {
                    Pago p = new Pago();
                    p.setId(rs.getString("id"));
                    p.setValor(rs.getBigDecimal("valor"));
                    p.setFecha(rs.getString("fecha"));
                    pagos.add(p);
                    totalPagos=totalPagos.add(p.getValor());
                    //System.out.println(p.getValor().toString());
                }

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
