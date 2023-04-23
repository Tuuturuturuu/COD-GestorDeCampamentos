package Presentacion.Actividad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Actividad.TActividad;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VistaActividadGeneral extends JFrame{
	
	private JButton altaActividad_Button;
	private JButton bajaActividad_Button;
	private JButton modificarActividad_Button;
	private JButton mostrarActividad_Button;
	private JButton mostrarTodasActividades_Button;
	private JButton mostrarTodasActividadesPersonal_Button;
	private JButton mostrarTodasActividadesMaterial_Button;
	private JButton backButton;

	private JPanel j;
	private TActividad tActividad;

	public VistaActividadGeneral() {
		super("Gestor de Campamentos");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 1000;
		int alto = 525;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
	//this.setBounds(100, 100, 1000, 525);
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
		tActividad = new TActividad();
		JLabel label = ComponentsBuilder.createLabel("Actividad", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

		altaActividad_Button = ComponentsBuilder.createButton("Alta Actividad", 100, 100, 185, 100);
		altaActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EAltaActividad);
			}

		});
		altaActividad_Button.setVisible(true);
		this.add(altaActividad_Button);

		bajaActividad_Button = ComponentsBuilder.createButton("Baja Actividad", 300, 100, 185, 100);
		bajaActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EBajaActividad);

			}
		});

		bajaActividad_Button.setVisible(true);
		this.add(bajaActividad_Button);

		modificarActividad_Button = ComponentsBuilder.createButton("Modificar Actividad", 500, 100, 185, 100);
		modificarActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EModificarActividad);

			}
		});
		modificarActividad_Button.setVisible(true);
		this.add(modificarActividad_Button);

		mostrarActividad_Button = ComponentsBuilder.createButton("Mostrar una Actividad", 700, 100, 185, 100);
		mostrarActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarUnActividad);

			}
		});
		mostrarActividad_Button.setVisible(true);
		this.add(mostrarActividad_Button);

		mostrarTodasActividades_Button = ComponentsBuilder.createButton("Mostrar todos las Actividades", 150, 250, 200, 100);
		mostrarTodasActividades_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarTodosLosActividad);

			}
		});
		
		mostrarTodasActividades_Button.setVisible(true);
		this.add(mostrarTodasActividades_Button);
		
		mostrarTodasActividadesPersonal_Button = ComponentsBuilder.createButton("Mostrar Actividades por Personal", 400, 250, 200, 100);
		mostrarTodasActividadesPersonal_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarTodosLosActividadporPersonal);

			}
		});
		mostrarTodasActividadesPersonal_Button.setVisible(true);
		this.add(mostrarTodasActividadesPersonal_Button);

		mostrarTodasActividadesMaterial_Button = ComponentsBuilder.createButton("Mostrar Actividades por Material", 700, 250, 200, 100);
		mostrarTodasActividadesMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarTodosLosActividadporMaterial);

			}
		});
		mostrarTodasActividadesMaterial_Button.setVisible(true);
		this.add(mostrarTodasActividadesMaterial_Button);

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaActividadGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});
		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
}
