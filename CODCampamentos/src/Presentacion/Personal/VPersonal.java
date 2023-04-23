package Presentacion.Personal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Personal.TPersonal;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VPersonal extends JFrame{
	
	private JButton altaPersonal_Button;
	private JButton bajaPersonal_Button;
	private JButton modificarPersonal_Button;
	private JButton mostrarUnPersonal_Button;
	private JButton mostrarTodosPersonal_Button;
	private JButton backButton;

	private JPanel j;
	private TPersonal tPersonal;

	public VPersonal() {
		super("Gestor de Campamentos");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 1000;
		int alto = 525;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		j = new JPanel();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}

	public void update(Object object, Evento event) {
		
	}

	public void initGUI() {
		tPersonal = new TPersonal();
		JLabel label = ComponentsBuilder.createLabel("Personal", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

		altaPersonal_Button = ComponentsBuilder.createButton("Alta Personal", 100, 120, 185, 100);

		altaPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(tPersonal, Evento.EAltaPersonal);
			}

		});
		altaPersonal_Button.setVisible(true);
		this.add(altaPersonal_Button);

		bajaPersonal_Button = ComponentsBuilder.createButton("Baja Personal", 407, 120, 185, 100);
		bajaPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(tPersonal, Evento.EBajaPersonal);

			}
		});

		bajaPersonal_Button.setVisible(true);
		this.add(bajaPersonal_Button);

		modificarPersonal_Button = ComponentsBuilder.createButton("Modificar Personal", 715, 120, 185, 100);
		modificarPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(tPersonal, Evento.EModificarPersonal);

			}
		});
		modificarPersonal_Button.setVisible(true);
		this.add(modificarPersonal_Button);

		mostrarUnPersonal_Button = ComponentsBuilder.createButton("Mostrar un Personal", 213, 290, 185, 100);
		mostrarUnPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(tPersonal, Evento.EMostrarUnPersonal);

			}
		});
		mostrarUnPersonal_Button.setVisible(true);
		this.add(mostrarUnPersonal_Button);

		mostrarTodosPersonal_Button = ComponentsBuilder.createButton("Mostrar todos Personal", 602, 290, 200, 100);
		mostrarTodosPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(tPersonal, Evento.EMostrarTodosPersonal);

			}
		});
		mostrarTodosPersonal_Button.setVisible(true);
		this.add(mostrarTodosPersonal_Button);

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});
		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
}
