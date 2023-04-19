
package Presentacion.Actividad.VAltaActividad;

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

import Negocio.Actividad.TActividad;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;



public class VAltaActividad extends JFrame implements IGUI {
	public VAltaActividad(){
		super("Crear Actividad");
		this.setBounds(100, 100, 650, 430);
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
				"Introduzca el nombre, lugar, numero de plazas, precio y idPersonal de la actividad que quieres dar de alta ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelLugar = new JPanel();
		mainPanel.add(panelLugar);

		JLabel labelLugar = ComponentsBuilder.createLabel("    Lugar: ", 10, 100, 80, 20, Color.BLACK);
		panelLugar.add(labelLugar);

		JTextField lugar = new JTextField();
		lugar.setPreferredSize(new Dimension(250, 30));
		lugar.setEditable(true);
		panelLugar.add(lugar);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNPlazas = new JPanel();
		mainPanel.add(panelNPlazas);

		JLabel labelNPlazas = ComponentsBuilder.createLabel("                Plazas: ", 10, 100, 80, 20,
				Color.BLACK);
		panelNPlazas.add(labelNPlazas);

		JTextField plazas = new JTextField();
		plazas.setPreferredSize(new Dimension(250, 30));
		plazas.setEditable(true);
		panelNPlazas.add(plazas);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelPrecio = new JPanel();
		mainPanel.add(panelPrecio);

		JLabel labelPrecio = ComponentsBuilder.createLabel("                     Precio: ", 10, 100, 80, 20,
				Color.BLACK);
		panelPrecio.add(labelPrecio);

		JTextField precio = new JTextField();
		precio.setPreferredSize(new Dimension(250, 30));
		precio.setEditable(true);
		panelPrecio.add(precio);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelIdPersonal = new JPanel();
		mainPanel.add(panelIdPersonal);

		JLabel labelIdPersonal = ComponentsBuilder.createLabel("           Id Personal: ", 10, 100, 80, 20, Color.BLACK);
		panelIdPersonal.add(labelIdPersonal);

		JTextField idPersonal = new JTextField();
		idPersonal.setPreferredSize(new Dimension(250, 30));
		idPersonal.setEditable(true);
		panelIdPersonal.add(idPersonal);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaActividad.this.setVisible(false);
				Controlador.obtenerInstancia().run(
						new TActividad(0, nombre.getText(), lugar.getText(), Integer.parseInt(plazas.getText()), Float.parseFloat(precio.getText()),
								Integer.parseInt(idPersonal.getText()),  true), Evento.EAltaActividadOK);
				

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaActividad.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaActividadGeneral);

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