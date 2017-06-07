/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String Usuario = "postgres";
    private String Password = "123456";
    private String Nombre_Base_Datos = "lacasadelballet";
    //private String Driver="org.gjt.mm.mysql.Driver";   // Para conectar con MySQL
    private String Driver = "org.postgresql.Driver";
    public Connection conexion;
    public String Estado = "";
    //public String URL="jdbc:mysql://10.1.1.25:3306/";jdbc:postgresql://127.0.0.1/test
    //Caleta
    public String URL = "jdbc:postgresql://192.168.1.20:5432/";
    //public String URL="jdbc:postgresql://170.10.3.49:5432/";//Postgrado
    //public String URL="jdbc:mysql://172.16.26.200:3306/";
    private Statement Stmt;
    private ResultSet Resultado = null;
    private String DatosTemporal;

    //Creacion de un constructor
    public Conexion() throws SQLException {
        try {
            Class.forName(Driver);
            conexion = DriverManager.getConnection((URL + Nombre_Base_Datos), Usuario, Password);
            conexion.setAutoCommit(false);
            this.setEstado_BD("ok");
        } catch (Exception ex) {
            Estado = "Error";
            this.setEstado_BD(ex.getMessage());
        }

    }

    //Creacion de un constructor sobrecargado
    public Conexion(String user, String Contraseña) {
        this.Usuario = user;
        this.Password = Contraseña;
    }

    public Conexion(String user, String Contraseña, String base_datos) {
        this.Usuario = user;
        this.Password = Contraseña;
        Nombre_Base_Datos = base_datos;
    }

    public String getDatosTemporal() {
        return DatosTemporal;
    }

    public void setDatosTemporal(String DatosTemporal) {
        this.DatosTemporal = DatosTemporal;
    }

    public void Conectar() {
        try {
            Class.forName(Driver);
            try {
                conexion = DriverManager.getConnection((URL + Nombre_Base_Datos), Usuario, Password);
                this.setEstado_BD("ok");
            } catch (Exception ex) {
                Estado = "Error";
                this.setEstado_BD(ex.getMessage());
            }
        } catch (Exception ex) {
            Estado = "Error";
            //JOptionPane.showMessageDialog(null, "Error con el driver");
            this.setEstado_BD(ex.getMessage());
        }
    }

    public void Cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
        }
    }

    //Propiedad para obtener el estado de la conexion
    public String getEstado_BD() {
        return Estado;
    }

    //Propiedad para espesificar el estado de la conexion
    public void setEstado_BD(String mensaje) {
        this.Estado = mensaje;
    }

    public ResultSet Consulta(String Sentencia) {
        if (Estado == "ok") {
            try {
                if (Resultado != null && !Resultado.isClosed()) {
                    Resultado.close();
                }
                Resultado = Stmt.executeQuery(Sentencia);
            } catch (Exception ex) {
                return null;
            }
            return Resultado;
        } else {
            return null;
        }
    }

    public void Insertar(String Query) {
        try {
            Stmt = conexion.createStatement();
            Stmt.executeUpdate(Query);
            Stmt.close();
            conexion.commit();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ejecutarProcedimientoPg(String NombreProcedimiento, List<String> Parametros) {
        ResultSet rs = null;
        try {
            if (!Parametros.isEmpty()) {
                //Conectar();
                Statement stm = conexion.createStatement();
                String sql = "select * from " + NombreProcedimiento + "( ";
                if (Parametros.size() == 1) {
                    sql = sql.concat(Parametros.get(0) + ");");
                } else {
                    for (String i : Parametros) {
                        sql = sql.concat("'" + i + "'" + ",");
                    }
                    sql = sql.concat(sql.substring(0, sql.lastIndexOf(',')) + ");");
                }

                rs = stm.executeQuery(sql);
                Cerrar();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return rs;
    }

    public ResultSet ejecutarProcedimientoPg(String NombreProcedimiento) {
        ResultSet rs = null;
        try {
            //Conectar();
            Statement stm = conexion.createStatement();
            String sql = "select * from " + NombreProcedimiento + "();";
            rs = stm.executeQuery(sql);
            Cerrar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return rs;
    }

    public ResultSet ejecutarProcedimientoPg(String NombreProcedimiento, String Parametro) {
        ResultSet rs = null;
        try {
            //Conectar();
            Statement stm = conexion.createStatement();
            String sql = "select * from " + NombreProcedimiento + "('" + Parametro + "');";
            rs = stm.executeQuery(sql);
            Cerrar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return rs;
    }
}
