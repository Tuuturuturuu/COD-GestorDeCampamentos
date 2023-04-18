package Presentacion.Material;

import java.awt.Color;
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
	private JButton mostrarMaterial_Button;
	private JButton mostrarTodosMateriales_Button;
	private JButton backButton;

	private JPanel j;
	private TMaterial tMaterial;

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
		tMaterial = new TMaterial();
		JLabel label = ComponentsBuilder.createLabel("Material", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

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

		mostrarMaterial_Button = ComponentsBuilder.createButton("Mostrar un Material", 213, 290, 185, 100);
		mostrarMaterial_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EMostrarUnMaterial);

			}
		});
		mostrarMaterial_Button.setVisible(true);
		this.add(mostrarMaterial_Button);

		mostrarTodosMateriales_Button = ComponentsBuilder.createButton("Mostrar todos los Materiales", 602, 290, 200, 100);
		mostrarTodosMateriales_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMaterialGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(tMaterial, Evento.EMostrarTodosLosMateriales);

			}
		});
		mostrarTodosMateriales_Button.setVisible(true);
		this.add(mostrarTodosMateriales_Button);

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
