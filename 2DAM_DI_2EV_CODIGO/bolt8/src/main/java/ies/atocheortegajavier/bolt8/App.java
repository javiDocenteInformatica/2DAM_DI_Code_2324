package ies.atocheortegajavier.bolt8;

import java.awt.EventQueue;

import ies.atocheortegajavier.utiles.Ficheros;
import ies.atocheortegajavier.vista.inicio.VentanaInicio;

public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				VentanaInicio frame = new VentanaInicio();
				frame.setVisible(true);
				
				Ficheros.compruebaYCreaFichero(Ficheros.NOMBRE_FICHERO_DB);
				
			}
        	
        });
    }
}
