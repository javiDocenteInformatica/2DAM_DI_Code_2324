/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.DB;
import modelo.Usuario;

/**
 *
 * @author profesor
 */
public class DaoUsuario {

    private DB db;
    private Connection conexion;

    public DaoUsuario() {
        db = new DB();
    }

    public boolean insertarUsuario(Usuario usuario) {

        boolean esInsertado = false;

        if (conexion == null) {
            conexion = db.conectar();
        } else {
            conexion = db.getConexion();
        }

        PreparedStatement ps = null;

        String sql = "INSERT INTO usuario (ID, Apellido1, Apellido2, Nombre, Fecha_Nacimiento) VALUES (null,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getApellido1());
            ps.setString(2, usuario.getApellido2());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getFechaNacimiento().toString());

            esInsertado = true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            esInsertado = false;
        }

        db.desconectar();

        return esInsertado;
    }

}
