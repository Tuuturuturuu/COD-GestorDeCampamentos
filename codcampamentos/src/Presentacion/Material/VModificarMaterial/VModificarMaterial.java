package Presentacion.Material.VModificarMaterial;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Material.TMaterial;

public class VModificarMaterial extends JFrame implements IGUI {
	public VModificarMaterial(){
		super("Modificar Material");
		this.setBounds(100, 100, 430, 330);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	public void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel msgIntroIDCabecera = ComponentsBuilder
				.createLabel("Introduzca el ID del Material que quiere modificar ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelID = new JPanel();
		mainPanel.add(panelID);

		JLabel labelID = ComponentsBuilder.createLabel("           ID Material: ", 10, 100, 80, 20, Color.BLACK);
		panelID.add(labelID);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelID.add(id);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre Material: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelExistencias = new JPanel();
		mainPanel.add(panelExistencias);

		JLabel labelExistencias = ComponentsBuilder.createLabel("Existencias: ", 10, 100, 80, 20, Color.BLACK);
		panelExistencias.add(labelExistencias);

		JTextField existencias = new JTextField();
		existencias.setPreferredSize(new Dimension(250, 30));
		existencias.setEditable(true);
		panelExistencias.add(existencias);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNAlmacen = new JPanel();
		mainPanel.add(panelNAlmacen);

		JLabel labelNAlmacen = ComponentsBuilder.createLabel("Num Existencias: ", 10, 100, 80, 20, Color.BLACK);
		panelNAlmacen.add(labelNAlmacen);

		JTextField nAlmacen = new JTextField();
		nAlmacen.setPreferredSize(new Dimension(250, 30));
		nAlmacen.setEditable(true);
		panelNAlmacen.add(nAlmacen);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelIDActividad = new JPanel();
		mainPanel.add(panelIDActividad);

		JLabel labelIDActividad = ComponentsBuilder.createLabel("ID Actividad: ", 10, 100, 80, 20, Color.BLACK);
		panelIDActividad.add(labelIDActividad);

		JTextField idActividad = new JTextField();
		idActividad.setPreferredSize(new Dimension(250, 30));
		idActividad.setEditable(true);
		panelIDActividad.add(idActividad);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarMaterial.this.setVisible(false);
				Controlador.obtenerInstancia().run(
						new TMaterial(Integer.parseInt(id.getText()), nombre.getText(), Integer.parseInt(existencias.getText()), Integer.parseInt(nAlmacen.getText()),
								Integer.parseInt(idActividad.getText()),  true), Evento.EModificarMaterialOK);
				
			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarMaterial.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EModificarMaterial);

			}
		});
		panelBotones.add(botonCancelar);

		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}