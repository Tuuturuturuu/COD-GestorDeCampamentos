/**
 * 
 */
package Presentacion.Turno;

import javax.swing.JFrame;

import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;



public class VTurno extends JFrame implements IGUI {
	
	private JButton altaTurno_button;
	private JButton bajaTurno_button;
	private JButton modifTurno_button;
	private JButton mostrarTodosTurnos_button;
	private JButton mostrarUnTurno_button;
	private JButton backButton;
	private JPanel j;
	
	public VTurno() {
		super("Gestor de Campamentos");
		this.setBounds(100, 100, 1000, 525);
		this.setLayout(null);
		j = new JPanel();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}


	public void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Turno", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

		altaTurno_button = ComponentsBuilder.createButton("Alta Turno", 100, 120, 185, 100);

		altaTurno_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EAltaTurno);
			}

		});
		altaTurno_button.setVisible(true);
		this.add(altaTurno_button);

		bajaTurno_button = ComponentsBuilder.createButton("Baja Turno", 407, 120, 185, 100);
		bajaTurno_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EBajaTurno);

			}
		});

		bajaTurno_button.setVisible(true);
		this.add(bajaTurno_button);

		modifTurno_button = ComponentsBuilder.createButton("Modificar Turno", 715, 120, 185, 100);
		modifTurno_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EModifTurno);

			}
		});
		modifTurno_button.setVisible(true);
		this.add(modifTurno_button);

		mostrarUnTurno_button = ComponentsBuilder.createButton("Mostrar un Turno", 213, 290, 185, 100);
		mostrarUnTurno_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EMostrarUnTurno);

			}
		});
		mostrarUnTurno_button.setVisible(true);
		this.add(mostrarUnTurno_button);

		mostrarTodosTurnos_button = ComponentsBuilder.createButton("Mostrar todos los Turnos", 602, 290, 200, 100);
		mostrarTodosTurnos_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EMostrarTodosLosTurnos);

			}
		});
		mostrarTodosTurnos_button.setVisible(true);
		this.add(mostrarTodosTurnos_button);

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaTurnoGeneral);

			}
		});
		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}