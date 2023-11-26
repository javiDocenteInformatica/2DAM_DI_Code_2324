package org.atoche.ortega.javier.BolT7;

import javax.swing.SwingUtilities;


public class App {
	public static void main(String[] args) {

		// https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/SwingUtilities.html#invokeLater(java.lang.Runnable)
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				System.out.println("Hello World on " + Thread.currentThread());
			}

		});
	}
}
