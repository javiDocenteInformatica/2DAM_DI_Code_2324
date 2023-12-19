/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.DB;
import vista.VentanaTablaUsuarios;

/**
 *
 * @author profesor
 */
public class VentanaTablaUsuariosControlador extends WindowAdapter {

    private VentanaTablaUsuarios ventanaTablaUsuarios;

    public VentanaTablaUsuariosControlador(VentanaTablaUsuarios ventanaTablaUsuarios) {
        this.ventanaTablaUsuarios = ventanaTablaUsuarios;
    }

    
    @Override
    public void windowClosing(WindowEvent e) {
        cerrarVentana();
    }
    
    
    
    
    // MÉTODOS ÚTILES
    public void cerrarVentana() {
        ventanaTablaUsuarios.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Acciones que deseas realizar al cerrar la ventana
                System.out.println("Ventana 'ventanaTablaUsuarios' cerrada");

                // Cierra la ventana
                ventanaTablaUsuarios.dispose();
            }

        });
    }

}
