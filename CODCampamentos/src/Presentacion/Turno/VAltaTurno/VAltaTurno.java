package Presentacion.Turno.VAltaTurno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Turno.TTurno;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;



public class VAltaTurno extends JFrame implements IGUI {
	public VAltaTurno(){
		super("Crear Turno");
		this.setBounds(100, 100, 430, 330);
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
				"Introduzca el nombre y el DNI del cliente que quiere dar de alta ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre Cliente: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelDNI = new JPanel();
		mainPanel.add(panelDNI);

		JLabel labelDNI = ComponentsBuilder.createLabel("DNI Cliente: ", 10, 100, 80, 20, Color.BLACK);
		panelDNI.add(labelDNI);

		JTextField dni = new JTextField();
		dni.setPreferredSize(new Dimension(250, 30));
		dni.setEditable(true);
		panelDNI.add(dni);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaTurno.this.setVisible(false);

			//Controlador.obtenerInstancia().run(
				//new TTurno(0, nombre.getText(), dni.getText(), tfno.getText(), true), Evento);

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaTurnoGeneral);

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
	
		
	}
}