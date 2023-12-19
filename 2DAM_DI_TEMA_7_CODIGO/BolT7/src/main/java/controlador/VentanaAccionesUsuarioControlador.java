/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DaoUsuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.VentanaAccionesUsuario;
import vista.VentanaTablaUsuarios;

/**
 *
 * @author profesor
 */
public class VentanaAccionesUsuarioControlador {

    private VentanaAccionesUsuario ventanaAccionesUsuario;
    private DaoUsuario daoUsuario;

    public VentanaAccionesUsuarioControlador(VentanaAccionesUsuario ventanaAccionesUsuario) {
        this.ventanaAccionesUsuario = ventanaAccionesUsuario;
        daoUsuario = new DaoUsuario();
    }

    public void abrirVentanaTablaUsuarios() {
        VentanaTablaUsuarios ventanaTablaUsuarios = new VentanaTablaUsuarios();
        ventanaTablaUsuarios.setVisible(true);
    }

    public boolean insertarUsuario() {

        boolean esInsertado = false;

//        Integer id;
        String apellido1, apellido2, nombre;
        LocalDate fechaNacimiento = null;

//        id = Integer.parseInt(ventanaAccionesUsuario.getjLabelID().getText());
        apellido1 = ventanaAccionesUsuario.getjTextFieldApellido1().getText();
        apellido2 = ventanaAccionesUsuario.getjTextFieldApellido2().getText();
        nombre = ventanaAccionesUsuario.getjTextFieldNombre().getText();
        try {
            fechaNacimiento = LocalDate.parse(
                    ventanaAccionesUsuario.getjTextFieldFechaNacimiento().getText(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

            Usuario usuario = new Usuario(apellido1, apellido2, nombre, fechaNacimiento);

            esInsertado = daoUsuario.insertarUsuario(usuario);

        } catch (DateTimeParseException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(
                    ventanaAccionesUsuario,
                    "La fecha no está introducida en el formato correcto"
                    + "\n"
                    + "Formato esperado: 2023-12-19"
                    + "\n"
                    + "Fecha introducida: " + fechaNacimiento.toString(),
                    "ERROR AL INSERTAR",
                    JOptionPane.ERROR_MESSAGE
            );

        } 
        return esInsertado;
    }
}
