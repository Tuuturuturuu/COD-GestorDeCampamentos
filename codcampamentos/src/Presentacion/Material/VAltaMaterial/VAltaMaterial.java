package Presentacion.Material.VAltaMaterial;

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

//import Negocio.Actividad.TActividad;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAltaMaterial extends JFrame implements IGUI {
	public VAltaMaterial(){
		super("Crear Material");
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
				"Introduzca el nombre, almacen, numero de existencias, y idActividad del material que quieres dar de alta ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre Material: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelAlmacen = new JPanel();
		mainPanel.add(panelAlmacen);

		JLabel labelAlmacen = ComponentsBuilder.createLabel("Almacen: ", 10, 100, 80, 20, Color.BLACK);
		panelAlmacen.add(labelAlmacen);

		JTextField almacen = new JTextField();
		almacen.setPreferredSize(new Dimension(250, 30));
		almacen.setEditable(true);
		panelAlmacen.add(almacen);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNumExistencias = new JPanel();
		mainPanel.add(panelNumExistencias);

		JLabel labelNumExistencias = ComponentsBuilder.createLabel("Numero de Existencias: ", 10, 100, 80, 20, Color.BLACK);
		panelNumExistencias.add(labelNumExistencias);

		JTextField numExistencias = new JTextField();
		numExistencias.setPreferredSize(new Dimension(250, 30));
		numExistencias.setEditable(true);
		panelNumExistencias.add(numExistencias);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel panelIdActividad = new JPanel();
		mainPanel.add(panelIdActividad);

		JLabel labelIdActividad = ComponentsBuilder.createLabel("Numero de Existencias: ", 10, 100, 80, 20, Color.BLACK);
		panelIdActividad.add(labelIdActividad);

		JTextField idActividad = new JTextField();
		idActividad.setPreferredSize(new Dimension(250, 30));
		idActividad.setEditable(true);
		panelIdActividad.add(idActividad);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaMaterial.this.setVisible(false);

//				Controlador.obtenerInstancia().run(
//						new TActividad(0, nombre.getText(), dni.getText(), tfno.getText(), true), Evento.EAltaActividadOK);

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaMaterial.this.setVisible(false);
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