package Presentacion;

import java.awt.Color;
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

import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class ConfirmDialogMostrarFactura extends JFrame implements IGUI {
	private static final long serialVersionUID = 1L;

	private String msj;

	public ConfirmDialogMostrarFactura() {
		super("Mensaje de confirmacion de factura cerrada");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 400;
		int alto = 550;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBounds(200, 200, 200, 200);
		this.setContentPane(panel);

		JPanel aux = new JPanel();
		panel.add(aux);
		JLabel info = new JLabel("Operacion exitosa");
		aux.add(info);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel mensaje = new JPanel();
		panel.add(mensaje);

		JLabel labelID = ComponentsBuilder.createLabel(msj, 10, 100, 80, 20, Color.BLACK);
		mensaje.add(labelID);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel botonPanel = new JPanel();
		panel.add(botonPanel);
		JButton confirmar = new JButton("OK");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfirmDialogMostrarFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaFacturaGeneral);
			}

		});
		botonPanel.add(confirmar);
		pack();
	}

	@Override
	public void actualizar(Object object, Evento event) {
		if (object != null) {
			String res = (String) object;
			this.msj = res;
			initGUI();
		}

	}
}