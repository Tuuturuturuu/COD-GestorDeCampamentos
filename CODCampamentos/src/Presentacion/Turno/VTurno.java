/**
 * 
 */
package Presentacion.Turno;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.Actividad.VistaActividadGeneral;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;

import Negocio.Actividad.TActividad;
import Negocio.Turno.TTurno;

import javax.swing.JButton;
import javax.swing.JLabel;

public class VTurno extends JFrame implements IGUI {
	private JButton altaTurno_Button;
	private JButton bajaTurno_Button;
	private JButton modificarTurno_Button;
	private JButton mostrarTurno_Button;
	private JButton mostrarTodosTurnos_Button;
	private JButton backButton;

	private JPanel j;
	private TTurno tTurno;

	public VTurno() {
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
		tTurno = new TTurno();
		JLabel label = ComponentsBuilder.createLabel("Turno", 250, 30, 500, 50, Color.BLACK);
		this.add(label);

		altaTurno_Button = ComponentsBuilder.createButton("Alta Turno", 100, 100, 185, 100);
		altaTurno_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(tTurno, Evento.EAltaTurno);
			}

		});
		altaTurno_Button.setVisible(true);
		this.add(altaTurno_Button);

		bajaTurno_Button = ComponentsBuilder.createButton("Baja Turno", 300, 100, 185, 100);
		bajaTurno_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(tTurno, Evento.EBajaTurno);

			}
		});

		bajaTurno_Button.setVisible(true);
		this.add(bajaTurno_Button);

		modificarTurno_Button = ComponentsBuilder.createButton("Modificar Turno", 500, 100, 185, 100);
		modificarTurno_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(tTurno, Evento.EModificarTurno);

			}
		});
		modificarTurno_Button.setVisible(true);
		this.add(modificarTurno_Button);

		mostrarTurno_Button = ComponentsBuilder.createButton("Mostrar un Turno,", 700, 100, 185, 100);
		mostrarTurno_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(tTurno, Evento.EMostrarUnTurno);

			}
		});
		mostrarTurno_Button.setVisible(true);
		this.add(mostrarTurno_Button);

		mostrarTodosTurnos_Button = ComponentsBuilder.createButton("Mostrar todos los Turnos", 100, 250, 185, 100);
		mostrarTodosTurnos_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(tTurno, Evento.EMostrarTodosLosTurnos);

			}
		});
		
		mostrarTodosTurnos_Button.setVisible(true);
		this.add(mostrarTodosTurnos_Button);
		

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

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