package Presentacion.Personal.VAltaPersonalCocinero;

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

import Negocio.Personal.TPersonalCocinero;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAltaPersonalCocinero extends JFrame implements IGUI{
	private JPanel j;
	private TPersonalCocinero tCocinero;

	public VAltaPersonalCocinero(TPersonalCocinero tCocinero) {
		super("Alta Cocinero");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 500;
		int alto = 300;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		j = new JPanel();
		this.tCocinero = tCocinero;
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
				"Introduzca el puesto en cocina y años de experiencia del cocinero que quiere dar de alta ", 1, 10, 80, 20,
				Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelPuesto = new JPanel();
		mainPanel.add(panelPuesto);

		JLabel labelPuesto = ComponentsBuilder.createLabel("Puesto en Cocina: ", 10, 100, 80, 20, Color.BLACK);
		panelPuesto.add(labelPuesto);

		JTextField puesto = new JTextField();
		puesto.setPreferredSize(new Dimension(250, 30));
		puesto.setEditable(true);
		panelPuesto.add(puesto);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelExperiencia = new JPanel();
		mainPanel.add(panelExperiencia);

		JLabel labelExperiencia = ComponentsBuilder.createLabel("    Años de experiencia: ", 10, 100, 80, 20, Color.BLACK);
		panelExperiencia.add(labelExperiencia);

		JTextField experiencia = new JTextField();
		experiencia.setPreferredSize(new Dimension(250, 30));
		experiencia.setEditable(true);
		panelExperiencia.add(experiencia);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonalCocinero.this.setVisible(false);
				tCocinero.setPuestoEnCocina(puesto.getText());
				tCocinero.setAniosExperiencia(Integer.parseInt(experiencia.getText()));
				Controlador.obtenerInstancia().run(tCocinero, Evento.EAltaCocineroOK);

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaPersonalCocinero.this.setVisible(false);
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
