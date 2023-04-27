/**
 * 
 */
package Presentacion.Personal.VAltaPersonal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAltaPersonal extends JFrame implements IGUI {

	public VAltaPersonal() {
		super("Dar de alta un Personal");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 1000;
		int alto = 525;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
				"Introduzca el DNI, nombre, tipo de personal y el idTurno del personal que quieres dar de alta ", 1, 10,
				80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		// DNI
		JPanel panelDNI = new JPanel();
		mainPanel.add(panelDNI);

		JLabel labelLugar = ComponentsBuilder.createLabel("    DNI: ", 10, 100, 80, 20, Color.BLACK);
		panelDNI.add(labelLugar);

		JTextField DNI = new JTextField();
		DNI.setPreferredSize(new Dimension(250, 30));
		DNI.setEditable(true);
		panelDNI.add(DNI);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// NOMBRE
		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// TIPO PERSONAL
		JPanel panelTPersonal = new JPanel();
		mainPanel.add(panelTPersonal);

		JLabel labelTPersonal = ComponentsBuilder.createLabel("                Tipo de Personal: ", 10, 100, 80, 20,
				Color.BLACK);
		panelTPersonal.add(labelTPersonal);

		JComboBox<String> tipoPersonal = new JComboBox<String>();
		tipoPersonal.addItem("Monitor");
		tipoPersonal.addItem("Cocinero");
		tipoPersonal.setPreferredSize(new Dimension(250, 25));
		panelTPersonal.add(tipoPersonal);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// ID TURNO
		JPanel panelIdTurno = new JPanel();
		mainPanel.add(panelIdTurno);

		JLabel labelIdTurno = ComponentsBuilder.createLabel("           Id Turno: ", 10, 100, 80, 20, Color.BLACK);
		panelIdTurno.add(labelIdTurno);

		JTextField idTurno = new JTextField();
		idTurno.setPreferredSize(new Dimension(250, 30));
		idTurno.setEditable(true);
		panelIdTurno.add(idTurno);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonal.this.setVisible(false);
				int tipo = -78;
				try {

					if (tipoPersonal.getSelectedItem() == "Monitor") {
						tipo = 0;
						Controlador.obtenerInstancia()
								.run(new TPersonalMonitor(0, DNI.getText() != null ? DNI.getText() : "",
										nombre.getText() != null ? nombre.getText() : "", tipo,
										!idTurno.getText().isEmpty() ? Integer.parseInt(idTurno.getText()) : 0, true,
										null, null), Evento.EAltaPersonalOK);

					} else if (tipoPersonal.getSelectedItem() == "Cocinero") {
						tipo = 1;
						Controlador.obtenerInstancia()
								.run(new TPersonalCocinero(0, DNI.getText() != null ? DNI.getText() : "",
										nombre.getText() != null ? nombre.getText() : "", tipo,
										!idTurno.getText().isEmpty() ? Integer.parseInt(idTurno.getText()) : 0, true,
										null, 0), Evento.EAltaPersonalOK);
					}
				} catch (Exception ex) {
					if (tipoPersonal.getSelectedItem() == "Monitor") {
						tipo = 0;
						Controlador.obtenerInstancia().run(
								new TPersonalMonitor(-38, null, null, tipo, null, true, null, null),
								Evento.EAltaPersonalOK);

					} else if (tipoPersonal.getSelectedItem() == "Cocinero") {
						tipo = 1;
						Controlador.obtenerInstancia().run(
								new TPersonalCocinero(-38, null, null, tipo, null, true, null, 0),
								Evento.EAltaPersonalOK);
					}
				}
			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		this.setVisible(true);
		this.setResizable(true);
	}

	public void actualizar() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub

	}
}