package Presentacion.Actividad.VModificarActividad;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Actividad.TActividad;

import javax.swing.JLabel;
import javax.swing.JDialog;

public class VModificarActividad extends JFrame implements IGUI {
	public VModificarActividad(){
		super("Modificar Actividad");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 430;
		int alto = 630;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
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
				.createLabel("Introduzca el ID de la Actividad que quiere modificar ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelID = new JPanel();
		mainPanel.add(panelID);

		JLabel labelID = ComponentsBuilder.createLabel("           ID Actividad: ", 10, 100, 80, 20, Color.BLACK);
		panelID.add(labelID);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelID.add(id);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre Actividad: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelLugar = new JPanel();
		mainPanel.add(panelLugar);

		JLabel labelLugar = ComponentsBuilder.createLabel("Lugar: ", 10, 100, 80, 20, Color.BLACK);
		panelLugar.add(labelLugar);

		JTextField lugar = new JTextField();
		lugar.setPreferredSize(new Dimension(250, 30));
		lugar.setEditable(true);
		panelLugar.add(lugar);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelPlazas = new JPanel();
		mainPanel.add(panelPlazas);

		JLabel labelPlazas = ComponentsBuilder.createLabel("Num Plazas: ", 10, 100, 80, 20, Color.BLACK);
		panelPlazas.add(labelPlazas);

		JTextField plazas = new JTextField();
		plazas.setPreferredSize(new Dimension(250, 30));
		plazas.setEditable(true);
		panelPlazas.add(plazas);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelPrecio = new JPanel();
		mainPanel.add(panelPrecio);

		JLabel labelPrecio = ComponentsBuilder.createLabel("Precio: ", 10, 100, 80, 20, Color.BLACK);
		panelPrecio.add(labelPrecio);

		JTextField precio = new JTextField();
		precio.setPreferredSize(new Dimension(250, 30));
		precio.setEditable(true);
		panelPrecio.add(precio);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelIDPersonal = new JPanel();
		mainPanel.add(panelIDPersonal);

		JLabel labelIDPersonal = ComponentsBuilder.createLabel("ID Personal: ", 10, 100, 80, 20, Color.BLACK);
		panelIDPersonal.add(labelIDPersonal);

		JTextField idPersonal = new JTextField();
		idPersonal.setPreferredSize(new Dimension(250, 30));
		idPersonal.setEditable(true);
		panelIDPersonal.add(idPersonal);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarActividad.this.setVisible(false);
				try {
					Controlador.obtenerInstancia()
							.run(new TActividad(0, nombre.getText() != null ? nombre.getText() : "",
									lugar.getText() != null ? lugar.getText() : "",
									!plazas.getText().isEmpty() ? Integer.parseInt(plazas.getText()) : 0,
									!precio.getText().isEmpty() ? Float.parseFloat(precio.getText()) : 0,
									!idPersonal.getText().isEmpty() ? Integer.parseInt(idPersonal.getText()) : 0, true),
									Evento.EModificarActividadOK);
				} catch (Exception ex) {
					Controlador.obtenerInstancia().run(new TActividad(-38, null, null, null, null, null, true),
							Evento.EModificarActividadOK);
				}
			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarActividad.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaActividadGeneral);

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