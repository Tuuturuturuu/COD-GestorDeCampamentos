package Presentacion.Material;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Material.TMaterial;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VistaMaterialGeneral extends JFrame{
	
	private JButton altaMaterial_Button;
	private JButton bajaMaterial_Button;
	private JButton modificarMaterial_Button;
	private JButton aniadirActividad_Button;
	private JButton mostrarMaterial_Button;
	private JButton mostrarTodosMaterial_Button;
	private JButton mostrarMaterialPorActividad;
	private JButton backButton;

	private JPanel j;
	private TMaterial tMaterial;

	public VistaMaterialGeneral() {
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
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void initGUI() {
		tMaterial = new TMaterial();
		JLabel label = ComponentsBuilder.createLabel("Material", 250, 30, 500, 50, Color.BLACK);
		this.add(label);
		
		//ALTA 
		altaMaterial_Button = ComponentsBuilder.createButton("Alta Material", 100, 120, 185, 100);
		altaMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EAltaMaterial);
			}

		});
		altaMaterial_Button.setVisible(true);
		this.add(altaMaterial_Button);
		
		//BAJA
		bajaMaterial_Button = ComponentsBuilder.createButton("Baja Material", 407, 120, 185, 100);
		bajaMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EBajaMaterial);

			}
		});

		bajaMaterial_Button.setVisible(true);
		this.add(bajaMaterial_Button);
		
		//MODIFICAR
		modificarMaterial_Button = ComponentsBuilder.createButton("Modificar Material", 715, 120, 185, 100);
		modificarMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EModificarMaterial);
			}
		});
		
		modificarMaterial_Button.setVisible(true);
		this.add(modificarMaterial_Button);

		//MOSTRAR UNO
		mostrarMaterial_Button = ComponentsBuilder.createButton("Mostrar una Material", 100, 290, 185, 100);
		mostrarMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EMostrarUnMaterial);

			}
		});
		mostrarMaterial_Button.setVisible(true);
		this.add(mostrarMaterial_Button);
		
		//MOSTRAR TODOS
		mostrarTodosMaterial_Button = ComponentsBuilder.createButton("Mostrar todos los Materiales", 710, 290, 200, 100);
		mostrarTodosMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EMostrarTodosLosMateriales);

			}
		});
		mostrarTodosMaterial_Button.setVisible(true);
		this.add(mostrarTodosMaterial_Button);
		
		// MATERIAL POR ACTIVIDAD
		mostrarMaterialPorActividad = ComponentsBuilder.createButton("Mostrar Material por Actividad", 397, 290, 210, 100);
		mostrarMaterialPorActividad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EMostrarMaterialPorActividad);
			}

		});
		mostrarMaterialPorActividad.setVisible(true);
		this.add(mostrarMaterialPorActividad);
		
		//ANIADIR ACTIVIDAD
		aniadirActividad_Button = ComponentsBuilder.createButton("Añadir Actividad", 715, 120, 185, 100);
		aniadirActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EAnadirActividad);
			}
		});
		
		aniadirActividad_Button.setVisible(true);
		this.add(aniadirActividad_Button);

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});

		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
}