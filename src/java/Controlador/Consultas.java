/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Javier 21/08/2016
 */
public class Consultas extends Conexion{//para que herede de conexion 
    
    public boolean autenticacion(String usuario,String pass){//Metodo para mirar que el usuario esta registrado
        PreparedStatement pst=null;
        ResultSet rs = null;//Sirve para guardar resultados
        
        
        try {
            //evitamos sql injection no colocar +usuario+ +pass+
            String consulta = "select * from usuarios where usuario = ? and pass = ?";
            pst = getConexion().prepareStatement(consulta);//contienen una sentencia SQL que ya ha sido compilada
            //le pasamos la consulta a prepareStatement
            /*La sentencia SQL contenida en un objeto PreparedStatement pueden tener uno o más parámetros 
            IN. Un parámetro IN es aquel cuyo valor no se especifica en la sentencia SQL cuando se crea. 
            En vez de ello la sentencia tiene un interrogante (‘?’) como un ‘ancla’ para cada parámetro IN. 
            Debes suministrar un valor para cada interrogante mediante 
            el método apropiado, que puede ser: setInt, setString, etc, antes de ejecutar la sentencia.*/
            pst.setString(1, usuario);//parametro 1 primer ?
            pst.setString(2, pass);////parametro 2 primer ?
            rs=pst.executeQuery();// Este método sirve para realizar una consulta a base de datos
            //ejecute la consulte y guardela en rs
            
            if (rs.absolute(1)) {//si existe registro 1 retorne true
                return true;
                
            }
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                 if (getConexion() !=null) getConexion().close();//si la conexion no esta nula no se a cerrado
                 if (pst != null) pst.close();//cerramos todo si no esta nulo
                 if (rs  != null) rs.close();
            } catch (Exception e) {
                System.err.println("Error"+e);
            }
        }
        return false;//en caso de que no tenga registro
    }
    /*public static void main(String[] args) {
      //  Consultas co = new Consultas();//creo un objeto de la clase consultas
        //System.out.println(co.autenticacion("javieraguayo", "1234"));//imprimo boolean del metodo autenticacion
        
    }*/
    
    public boolean registrar (String apellido,String usuario,String nombre, String pass){
        PreparedStatement pst = null;
        try {//no colocar sentencias ? para evitar sql injection
            String consulta = "insert into usuarios (apellido, usuario, nombre, pass) values(?,?,?,?)";
            pst= getConexion().prepareStatement(consulta);
            pst.setString(1, apellido);
            pst.setString(2, usuario);
            pst.setString(3, nombre);
            pst.setString(4, pass);
            
            if (pst.executeUpdate() == 1 ){//devuele un numero entero comparamos numero enteros , si afecto una fila 
            return true;                   //si inserto el dato
            }
        } catch (Exception ex) {
            System.err.println("Error"+ex);
        }finally{
            try {
                 if(getConexion() !=null) getConexion().close();//cierro la conexion
                 if(pst !=null) getConexion().close();//cierro pst
            } catch (Exception e) {
                System.err.println("Error"+e);
            }
        }
    return false;
    }
    /*public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.registrar("AGuayo", "JAV.AGAUYO", "JAVIER", "12345"));
    }*/
    
}
