package Launcher;

import javax.swing.SwingUtilities;

import Presentacion.VistaGeneral;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VistaGeneral();
			}
		});

	}

}
