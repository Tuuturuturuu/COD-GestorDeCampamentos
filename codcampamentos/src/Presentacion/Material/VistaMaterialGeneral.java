package Presentacion.Material;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Actividad.TActividad;
//import Negocio.Material.TMaterial;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VistaMaterialGeneral extends JFrame{
	
	private JButton altaMaterial_Button;
	private JButton bajaMaterial_Button;
	private JButton modificarMaterial_Button;
	private JButton mostrarMaterial_Button;
	private JButton mostrarTodosMaterial_Button;
	private JButton mostrarMaterialPorActividad;
	private JButton backButton;

	private JPanel j;
	private TActividad tActividad;

	public VistaMaterialGeneral() {
		super("Gestor de Campamentos");
		this.setBounds(100, 100, 1000, 525);
		this.setLayout(null);
		j = new JPanel();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}

	public void update(Object object, Evento event) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void initGUI() {
		tActividad = new TActividad();
		JLabel label = ComponentsBuilder.createLabel("Material", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

		altaMaterial_Button = ComponentsBuilder.createButton("Alta Material", 100, 120, 185, 100);

		altaMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(tActividad, Evento.EAltaMaterial);
			}

		});
		altaMaterial_Button.setVisible(true);
		this.add(altaMaterial_Button);

		bajaMaterial_Button = ComponentsBuilder.createButton("Baja Material", 407, 120, 185, 100);
		bajaMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(tActividad, Evento.EBajaActividad);

			}
		});

		bajaMaterial_Button.setVisible(true);
		this.add(bajaMaterial_Button);

		modificarMaterial_Button = ComponentsBuilder.createButton("Modificar Material", 715, 120, 185, 100);
		modificarMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tActividad, Evento.EBajaMaterial);
			}
		});
		
		modificarMaterial_Button.setVisible(true);
		this.add(modificarMaterial_Button);

		mostrarMaterial_Button = ComponentsBuilder.createButton("Mostrar una Material", 100, 290, 185, 100);
		
		mostrarMaterial_Button = ComponentsBuilder.createButton("Mostrar un Material", 213, 290, 185, 100);

		mostrarMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarUnActividad);

			}
		});
		mostrarMaterial_Button.setVisible(true);
		this.add(mostrarMaterial_Button);

		mostrarTodosMaterial_Button = ComponentsBuilder.createButton("Mostrar todos los Materiales", 710, 290, 200, 100);
		mostrarTodosMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(tActividad, Evento.EMostrarTodosLosActividad);

			}
		});
		mostrarTodosMaterial_Button.setVisible(true);
		this.add(mostrarTodosMaterial_Button);
		
		
		mostrarMaterialPorActividad = ComponentsBuilder.createButton("Mostrar Material por Actividad", 397, 290, 210, 100);

		mostrarMaterialPorActividad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(tActividad, Evento.EAltaActividad);
			}

		});
		mostrarMaterialPorActividad.setVisible(true);
		this.add(mostrarMaterialPorActividad);

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				//Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});
		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
}

