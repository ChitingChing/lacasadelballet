/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import datos.Conexion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chiti
 */
@Named(value = "navigationBean")
@SessionScoped
public class navigationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String page = "/templates/content.xhtml";
    private String e;

    public String getE() {
        return e;
    }
    public String getPage() {
        return page;
    }

    public void setPage(String currentPage) {
        this.page = currentPage;
    }

    public void conect() {
        Conexion cn = new Conexion();
        cn.Conectar();
        e=cn.getEstado_BD();
    }
}
