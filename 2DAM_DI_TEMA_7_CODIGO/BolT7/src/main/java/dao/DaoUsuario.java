/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        int numFilasInsertadas = 0;

        if (conexion == null) {
            conexion = db.conectar();
        } else {
            conexion = db.getConexion();
        }

        PreparedStatement ps = null;

        String sql = "INSERT INTO usuarios "
                + "(ID, "
                + "Apellido1, "
                + "Apellido2, "
                + "Nombre, "
                + "Fecha_Nacimiento)"
                + "VALUES (null,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getApellido1());
            ps.setString(2, usuario.getApellido2());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getFechaNacimiento().toString());
            System.out.println("dao.DaoUsuario.insertarUsuario(): "
                    + usuario.getFechaNacimiento().toString());

            numFilasInsertadas = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        db.desconectar();

        if (numFilasInsertadas > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha insertado al usuario correctamente! \n"
                    + usuario.toString(),
                    "INSERTAR",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al insertar en la BD! \n"
                    + usuario.toString(),
                    "ERROR AL INSERTAR",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return (numFilasInsertadas > 0) ? true : false;
    }

    public ArrayList<Usuario> leerUsuarios() {
        
        if (conexion == null) {
            conexion = db.conectar();
        } else {
            conexion = db.getConexion();
        }
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usuarios";

        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                String apellido1 = rs.getString("Apellido1");
                String apellido2 = rs.getString("Apellido2");
                String nombre = rs.getString("Nombre");
                LocalDate fechaNacimiento = LocalDate.parse(
                        rs.getString("Fecha_Nacimiento"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")
                );

                Usuario usuario = new Usuario(id, apellido1, apellido2, nombre, 
                        fechaNacimiento);
                
                listaUsuarios.add(usuario);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            db.desconectar();
        }

        return listaUsuarios;
    }

}
