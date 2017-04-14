/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import java.util.List;

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
    private Statement Ejecutor;
    private ResultSet Resultado;
    private String DatosTemporal;

    //Creacion de un constructor
    public Conexion() {
        Resultado = null;
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

    public void Conectar(String base_datos) {
        try {
            Class.forName(Driver);
            try {
                conexion = DriverManager.getConnection((URL + Nombre_Base_Datos), Usuario, Password);
                this.setEstado_BD("ok");
                Ejecutor = conexion.createStatement();
                Resultado = null;
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
                Resultado = Ejecutor.executeQuery(Sentencia);
            } catch (Exception ex) {
                return null;
            }
            return Resultado;
        } else {
            return null;
        }
    }
//    public ResultSet EjecutarProcedimieto(String nombre)
//    {
//           String SQL="{call ";
//           String Num_Parametro=" (";
//           String nombre_procedimiento= nombre;
//           
//           ResultSet rs=null;
//            ResultSetMetaData rsm=com       acmycompany.lacasadelbcom.mycompany.lacasadelballetatos.Conexion UnaC = new accesodatos.Conexion();
//            UnaC.Conectar();
//            
//                
//                 try{
//            Connection con = UnaC.conexion;
//            CallableStatement miProcedimiento =con.prepareCall(SQL+nombre_procedimiento+Num_Parametro+")}");
//            miProcedimiento.execute();
//             return miProcedimiento.getResultSet();
//             
//                 }catch(Exception ee)
//                 {
//                     return null;
//                 }
//    }
//    
//    public ResultSet EjecutarProcedimieto(String nombre,String Parametro1)
//    {
//           String parametro1=Parametro1;
//           String SQL="{call ";
//           String Num_Parametro=" (";
//           String nombre_procedimiento= nombre;
//           
//           ResultSet rs=nullcom   Resultmycompany.lacasadelbcom.mycompany.lacasadelballettaData rsm=null;
//            accesodatos.Conexion UnaC = new accesodatos.Conexion();
//            UnaC.Conectar();
//            
//                 if(!"".equals(parametro1) && parametro1 != null)
//                 { Num_Parametro+="?";
//                 }
//                
//                 try{
//            Connection con = UnaC.conexion;
//            CallableStatement miProcedimiento =con.prepareCall(SQL+nombre_procedimiento+Num_Parametro+")}");
//            
//            /* Otro proceso de validación para saber y determinar el número de parámetros que se le 
//             darán al procedimiento almacenado.*/
//                if(!"".equals(parametro1) && parametro1 != null)
//                 { miProcedimiento.setString(1,parametro1);
//                 }
//               
//             miProcedimiento.execute();
//             return miProcedimiento.getResultSet();
//             
//                 }catch(Exception ee)
//                 {}
//           return null;
//    }
//    public ResultSet EjecutarProcedimietoDosParametros(String nombre,String Parametro1, String parametro2)
//    {
//           String parametro1=Parametro1;
//           String SQL="{call ";
//           String Num_Parametro=" (";
//           String nombre_procedimiento= nombre;
//    com        Rmycompany.lacasadelbcom.mycompany.lacasadelballetSet rs=null;
//            ResultSetMetaData rsm=null;
//            accesodatos.Conexion UnaC = new accesodatos.Conexion();
//            UnaC.Conectar();
//            
//                 if((!"".equals(parametro1) && parametro1 != null)&&(!"".equals(parametro2) && parametro2 != null))
//                 { Num_Parametro+="?,?";
//                 }
//                
//                 try{
//            Connection con = UnaC.conexion;
//            CallableStatement miProcedimiento =con.prepareCall(SQL+nombre_procedimiento+Num_Parametro+")}");
//            
//            /* Otro proceso de validación para saber y determinar el número de parámetros que se le 
//             darán al procedimiento almacenado.*/
//                if((!"".equals(parametro1) && parametro1 != null)&&(!"".equals(parametro2) && parametro2 != null))
//                 { miProcedimiento.setString(1,parametro1);
//                 miProcedimiento.setString(2,parametro2);
//                 }
//               
//             miProcedimiento.execute();
//             return miProcedimiento.getResultSet();
//             
//                 }catch(Exception ee)
//                 {}
//           return null;
//    }
//   
//    
//    
//    public ResultSet EjecutarProcedimietoFullParametros(String nombre, String [] ArregloParametroValor)
//    {
//           String complemento=" (";
//    comng nombremycompany.lacasadelbcom.mycompany.lacasadelballetedimiento= nombre;
//           ResultSet rs=null;
//            ResultSetMetaData rsm=null;
//            accesodatos.Conexion UnaC = new accesodatos.Conexion();
//            UnaC.Conectar();
//            for (int contador = 0; contador < ArregloParametroValor.length; contador++)
//                {
//                    if (ArregloParametroValor[contador]!= null)
//                    {
//                        if(ArregloParametroValor.length>=1)
//                        {
//                            if(contador==ArregloParametroValor.length-1)
//                            complemento +="?";
//                            else
//                            complemento +="?,";
//                        }
//                        else
//                        {
//                            complemento +="?";
//                        }
//                        
//                    }
//                 }
//                 try{
//            Connection con = UnaC.conexion;
//            String sent = "{call "+nombre_procedimiento+complemento+")}";
//            CallableStatement miProcedimiento =con.prepareCall(sent);
//            for (int contador = 0; contador < ArregloParametroValor.length; contador++)
//                {
//                    if (ArregloParametroValor[contador]!= null)
//                    {
//                        miProcedimiento.setString((contador+1),ArregloParametroValor[contador]);
//                    }
//                 }
//             rs = miProcedimiento.executeQuery();
//              
//                 }catch(Exception ee)
//                 {
//                     setEstado_BD(ee.toString());
//                    //Estado="Error";
//                    //JOptionPane.showMessageDialog(null, "Error "+ee);
//                 }
//                 UnaC.Cerrar();
//           return rs;
//    }
//    
//    public ResultSet EjecutarProcedimietoFullParametrosxTipoValor(String nombre, String [] ArregloParametroValor, String [] ArregloParametroTipo)
//    {
//    comng complemycompany.lacasadelbcom.mycompany.lacasadelballet=" (";
//           String nombre_procedimiento= nombre;
//           ResultSet rs=null;
//            ResultSetMetaData rsm=null;
//            accesodatos.Conexion UnaC = new accesodatos.Conexion();
//            UnaC.Conectar();
//            for (int contador = 0; contador < ArregloParametroValor.length; contador++)
//                {
//                    if (ArregloParametroValor[contador]!= null)
//                    {
//                        if(ArregloParametroValor.length>=1)
//                        {
//                            if(contador==ArregloParametroValor.length-1)
//                            complemento +="?";
//                            else
//                            complemento +="?,";
//                        }
//                        else
//                        {
//                            complemento +="?";
//                        }
//                        
//                    }
//                 }
//                 try{
//            Connection con = UnaC.conexion;
//            String sent = "{call "+nombre_procedimiento+complemento+")}";
//            CallableStatement miProcedimiento =con.prepareCall(sent);
//            for (int contador = 0; contador < ArregloParametroValor.length; contador++)
//                {
//                    if (ArregloParametroValor[contador]!= null)
//                    {
//                        if(ArregloParametroTipo[contador].equals("int"))
//                            miProcedimiento.setInt((contador+1),Integer.parseInt(ArregloParametroValor[contador]));
//                        else if(ArregloParametroTipo[contador].equals("string"))
//                            miProcedimiento.setString((contador+1),ArregloParametroValor[contador]);
//                    }
//                 }
//             rs = miProcedimiento.executeQuery();
//              
//                 }catch(Exception ee)
//                 {
//                     setEstado_BD("error");
//                    //Estado="Error";
//                    //JOptionPane.showMessageDialog(null, "Error "+ee);
//                 }
//                 UnaC.Cerrar();
//           return rs;
//    }
//    
//    public int Actualizacion(String Sentencia)  // Para insercion y actualizacion de registros
//    {
//        int retorno;
//        if(Estado=="ok")
//        {
//        try
//        {
//            if(Resultado != null && !Resultado.isClosed())
//                Resultado.close();
//            retorno=Ejecutor.executeUpdate(Sentencia);
//            Estado="ok";
//        }
//        catch(Exception ex)
//        {
//            Estado="Error en la actalización";this.Conectar();
//            return -1;
//        }
//        return retorno;
//        }
//        else
//        {
//            Estado="";
//            thiscom;
//       mycompany.lacasadelbalcom.mycompany.lacasadelballet -1;
//        }
//    }
//    
////  Obtiene el código de algun registro 
//public String ObtenerCodigo(String tabla,String campo,String condicion)
//{
//    String cadena="";
//        accesodatos.Conexion nuevaC = new accesodatos.Conexion();
//        nuevaC.Conectar();
//        ResultSet rs=nuevaC.Consulta("SELECT "+campo+" from "+tabla+" where "+condicion+";");
//        try {
//            if(rs.next())
//            {
//                cadena=rs.getString(1);
//            }
//            else
//            {
//                return "";
//            }
//        } catch (SQLException ex) {
//            Estado="error";
//        }
//        nuevaC.Cerrar();
//    return cadena;
//    
//}
////  El parámetro debe secomncia Sql mycompany.lacasadelbalcom.mycompany.lacasadelballet SELECT para la verificación correspondiente...
// /// la sentencia SELECT debe contener los datos los cuales sen quieren ingresar a la base de datos
//public boolean Verificar_Datos(String Sentencia)
//{
//        accesodatos.Conexion nuevaC = new accesodatos.Conexion();
//        nuevaC.Conectar();
//        try{
//        ResultSet rs=nuevaC.Consulta(Sentencia);
//        try {
//            if(rs.next())
//            {
//                nuevaC.Cerrar();
//                return true;
//            }
//            else
//            {
//                nuevaC.Cerrar();
//                return false;
//            }
//        } catch (SQLException ex) {
//            Estado="error";
//          nuevaC.Cerrar();  return false;
//        }
//        }
//        catch(Exception ex){
//            //JOptionPane.showMessageDialog(null,"Error en la verificacion");
//            nuevaC.Cerrar();
//            return false;
//        }
//}
//    
//    public String concatenar(ResultSet resultado)
//    {
//        String [] Vector= new String [10];
//        String cadena="";
//        try{
//             ResultSetMetaData rsmd= resultado.getMetaData(); 
//        while(resultado.next())
//        {
//           Vector= new String[rsmd.getColumnCount()];
//           for(int x=0;x<Vector.length;x++)
//           {
//               cadena=cadena+";"+ resultado.getString(x+1);
//           }
//    com.mycompany.lacasadelballet   }
//        catch(Exception ex)
//        {//JOptionPane.showMessageDialog(null,"Error, intente nuevamente");
//        }
//       retcom.mycompany.lacasadelballet
//    }
//    public ResultSet EjecutarProcedimietoFullPSQL(String nombre, String [] ArregloParametroValor)
//    {
//        accesodatos.Conexion UnaC = null;
//        String nombre_procedimiento= nombre;
//        ResultSet rs=null;
//        
//        
//           
//           UnaC = new accesodatos.Conexion();
//           UnaC.Conectar();
//           
//           
//           String misParametros = "";
//           for (int contador = 0; contador < ArregloParametroValor.length; contador++)
//                {
//                    if (ArregloParametroValor[contador]!= null)
//                    {
//                        if(contador==ArregloParametroValor.length-1)
//                            misParametros += ArregloParametroValor[contador];
//                        else
//                            misParametros += ArregloParametroValor[contador]+",";
//                    }
//                 }
//           try{
//            Connection con = UnaC.conexion;
//            String sentencia = "{call "+nombre_procedimiento+"('1204466740','lujoca12')}";
//            CallableStatement miProcedimiento =con.prepareCall(sentencia);
//            miProcedimiento.execute();
//                 }catch(Exception ee)
//                 {
//                     Estado="Error";
//                    //JOptionPane.showMessageDialog(null, "Error "+ee);
//                 }
//                 UnaC.Cerrar();
//           return rs;
//    }

    public ResultSet ejecutarProcedimientoPg(String NombreProcedimiento, List<String> Parametros) {
        ResultSet rs = null;
        try {
            if (!Parametros.isEmpty()) {
                Conectar();
                Statement stm = conexion.createStatement();
                String sql = "select * from " + NombreProcedimiento + "( ";
                if (Parametros.size() == 1) {
                    sql = sql.concat(Parametros.get(0) + ");");                    
                } else {
                    for (String i : Parametros) {
                        sql = sql.concat("'"+ i +"'"+ ",");
                    }
                   sql=sql.concat(sql.substring(0,sql.lastIndexOf(','))+");");
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
            Conectar();
            Statement stm = conexion.createStatement();
            String sql = "select * from " + NombreProcedimiento + "();";
            rs = stm.executeQuery(sql);
            Cerrar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return rs;
    }
    public ResultSet ejecutarProcedimientoPg(String NombreProcedimiento,String Parametro) {
        ResultSet rs = null;
        try {
            Conectar();
            Statement stm = conexion.createStatement();
            String sql = "select * from " + NombreProcedimiento + "('"+Parametro+"');";
            rs = stm.executeQuery(sql);
            Cerrar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return rs;
    }
}
