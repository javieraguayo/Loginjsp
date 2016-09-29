/*
 19/08/2016
https://www.youtube.com/watch?v=vFtMqcLJGtc
 */
package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 Clase conexion para hacer la conexion con la bd en mysql
 */
public class Conexion {
    private String USERNAME = "root";//credenciales localhost
    private String PASSWORD = "";   //credenciales localhost
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "loginjsp";
    
    private String CLASSNAME = "com.mysql.jdbc.Driver";//indica donde esta el driver
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;//cadena de conexion
    private Connection con; //creamos objeto de conexion sql.connection
    
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);//damos la conexion
            
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR"+e);
        }catch (SQLException e){
            System.err.println("Error"+e);
        }
    }
    
    public Connection getConexion(){//metodo que da la conexion debido a que esta privada
        return con;//retornamos objeto de la conexion
    }
    public static void main(String[] args) {//probamos la conexion
        Conexion con = new Conexion();//creamos un objeto de la clase conexion 
    }
}


