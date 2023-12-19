/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class DB {

    private Connection conexion;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String URL_CONNECTION = "jdbc:sqlite:db.sqlite";

    public DB() {
        conexion = null;
    }

    /**
     *
     * @return Connection
     */
    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL_CONNECTION);
            System.out.println("EXITO EN LA CONEXIÓN A DB!!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        return conexion;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, "Excepción al cerrar la base de datos", ex);
        }
    }

    // GETTERS Y SETTERS
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
