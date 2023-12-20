package org.atoche.ortega.javier.BolT7;

import modelo.DB;
import vista.PopupMenuDemo;

public class App {

    public static void main(String[] args) {

        // https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/SwingUtilities.html#invokeLater(java.lang.Runnable)
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("Hello World on " + Thread.currentThread());

                PopupMenuDemo popupMenu = new PopupMenuDemo();
//                popupMenu.createAndShowGUI();
            }

        });
    }
}
