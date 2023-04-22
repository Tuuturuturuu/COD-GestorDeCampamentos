package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentacion.Controlador.Controlador;

public class FailureDialog extends JFrame implements IGUI {

	//Errores Genericos
	private static final String error1 = "Error: ID no encontrado en la BD";
	private static final String error2 = "Error: Nombre con longitud incorrecta";
	private static final String error5 = "Error: Dicho objeto se encuentra inactivo";
	private static final String error6 = "Error: Campo unico ya en uso";
	private static final String error10 = "Error: Fallo a la hora de borrar en la BD";

	//Errores Actividad
	private static final String error4 = "Error: Actividad ya presente en la BD";
	private static final String error3 = "Error: Lugar especificado con longitud incorrecta";
	private static final String error7 = "Error: Numero de plazas con longitud incorrecta";
	private static final String error8 = "Error: El precio con longitud incorrecta";

	//Errores Personal
	private static final String error9 = "Error: El personal con dicho ID, no existe";
	
	private int id;

	public FailureDialog() {
		super("Mensaje de fracaso");
		initGUI();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 400;
		int alto = 200;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);

		JPanel aux = new JPanel();
		panel.add(aux);
		JLabel info;
		switch (id) {
		case -1:
			info = new JLabel(error1);
			break;
		case -2:
			info = new JLabel(error2);
			break;
		case -3:
			info = new JLabel(error3);
			break;
		case -4:
			info = new JLabel(error4);
			break;
		case -5:
			info = new JLabel(error5);
			break;
		case -6:
			info = new JLabel(error6);
			break;
		case -7:
			info = new JLabel(error7);
			break;
		case -8:
			info = new JLabel(error8);
			break;
		case -9:
			info = new JLabel(error9);
			break;
		case -10:
			info = new JLabel(error10);
			break;
		default:
			info = new JLabel("Error en la operacion");
		}
		aux.add(info);

		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel botonPanel = new JPanel();
		panel.add(botonPanel);
		JButton confirmar = new JButton("OK");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FailureDialog.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);
			}

		});
		botonPanel.add(confirmar);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		if (object != null) {
			Integer res = (Integer) object;
			this.id = res;
			initGUI();
		}
		
	}
	
}
