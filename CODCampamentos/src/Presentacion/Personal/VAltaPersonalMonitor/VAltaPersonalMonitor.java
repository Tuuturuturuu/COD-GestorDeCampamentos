package Presentacion.Personal.VAltaPersonalMonitor;

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

import Negocio.Personal.TPersonalMonitor;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAltaPersonalMonitor extends JFrame implements IGUI {
	private JPanel j;
	private TPersonalMonitor tMonitor;

	public VAltaPersonalMonitor(TPersonalMonitor tMonitor) {
		super("Alta Monitor");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 500;
		int alto = 300;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		j = new JPanel();
		this.tMonitor = tMonitor;
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	public void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
				"Introduzca la especialidad y los estudios del monitor que quiere dar de alta ", 1, 10, 80, 20,
				Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelEspecialidad = new JPanel();
		mainPanel.add(panelEspecialidad);

		JLabel labelEsp = ComponentsBuilder.createLabel("Especialidad: ", 10, 100, 80, 20, Color.BLACK);
		panelEspecialidad.add(labelEsp);

		JTextField especialidad = new JTextField();
		especialidad.setPreferredSize(new Dimension(250, 30));
		especialidad.setEditable(true);
		panelEspecialidad.add(especialidad);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelEstudios = new JPanel();
		mainPanel.add(panelEstudios);

		JLabel labelEstudios = ComponentsBuilder.createLabel("    Estudios: ", 10, 100, 80, 20, Color.BLACK);
		panelEstudios.add(labelEstudios);

		JTextField estudios = new JTextField();
		estudios.setPreferredSize(new Dimension(250, 30));
		estudios.setEditable(true);
		panelEstudios.add(estudios);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonalMonitor.this.setVisible(false);
				tMonitor.setEspecialidad(especialidad.getText() != null ? especialidad.getText() : "");
				tMonitor.setEstudios(estudios.getText() != null ? estudios.getText() : "");
				Controlador.obtenerInstancia().run(tMonitor, Evento.EAltaMonitorOK);

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonalMonitor.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

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
