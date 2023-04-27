package Presentacion.Material.VMostrarMaterialPorActividad;

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
import javax.swing.JTextField;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VMostrarMaterialPorActividad extends JFrame implements IGUI {

	public VMostrarMaterialPorActividad() {
		super("Mostrar Material Por Actividad");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 430;
		int alto = 330;
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
				"Introduzca el id de la actividad de la cual quiera mostrar un material ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelId = new JPanel();
		mainPanel.add(panelId);

		JLabel labelId = ComponentsBuilder.createLabel("ID Actividad: ", 10, 100, 80, 20, Color.BLACK);
		panelId.add(labelId);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelId.add(id);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {
			// En este ActionListener tiene que aparecer una ventana que muestre
			// la informacion del material seleccionado??
			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarMaterialPorActividad.this.setVisible(false);
				try {
					Controlador.obtenerInstancia().run(Integer.parseInt(id.getText()),
							Evento.EMostrarUnMaterialPorActividadOK);
				} catch (Exception ex) {
					Controlador.obtenerInstancia().run(-38, Evento.EMostrarUnMaterialPorActividadOK);
				}
			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarMaterialPorActividad.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaMaterialGeneral);

			}
		});

		JPanel panelBotones = new JPanel();
		panelBotones.add(botonAceptar);
		panelBotones.add(botonCancelar);
		mainPanel.add(panelBotones);

		this.setVisible(true);

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