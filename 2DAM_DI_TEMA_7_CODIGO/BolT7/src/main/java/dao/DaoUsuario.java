/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.ConexionDB;
import modelo.Usuario;

/**
 *
 * @author profesor
 */
public class DaoUsuario {

    private ConexionDB conexionDB;

    public DaoUsuario() {
        conexionDB =
                new ConexionDB();
    }

    public boolean insertarUsuario(Usuario usuario) {

        boolean esInsertado = false;
        
        Connection conn =
                null;

        if (conexionDB
                == null) {
            conn =
                    conexionDB.conectar();
        } else {
            conn =
                    conexionDB.getConexion();
        }

        PreparedStatement ps =
                null;

        String sql =
                "INSERT INTO usuarios (ID, Apellido1, Apellido2, Nombre, Fecha_Nacimiento) VALUES (null,?,?,?,?)";
        try{
             ps = conn.prepareStatement(sql);
        }catch(SQLException ex){
            ex.printStackTrace();
                   
        }
       

        conexionDB.desconectar();
        
        
        return esInsertado;
    }

}
