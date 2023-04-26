
package Presentacion.Turno.VModificarTurno;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;
import Presentacion.Turno.VAltaTurno.VAltaTurno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Turno.TTurno;

import javax.swing.JLabel;
public class VModificarTurno extends JFrame implements IGUI {
	public VModificarTurno(){
		super("Modificar Turno");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 600;
		int alto = 450;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	private void initGUI(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		//ID
		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
				"Introduzca el nombre, fecha y hora del turno que quiera modificar ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		//IDTurno
				JPanel panelId = new JPanel();
				mainPanel.add(panelId);

				JLabel labelId = ComponentsBuilder.createLabel("IdTurno: ", 10, 100, 80, 20, Color.BLACK);
				panelId.add(labelId);

				JTextField id = new JTextField();
				id.setPreferredSize(new Dimension(250, 30));
				id.setEditable(true);
				panelId.add(id);

				mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		
		//NOMBRE
		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre: ", 30, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		//FECHA
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField campoFecha = new JFormattedTextField(formatoFecha);
		campoFecha.setValue(new Date()); // establece la fecha actual como valor inicial
		JLabel etiquetaFecha = new JLabel("Fecha:");
		JPanel panelFecha = new JPanel();
		panelFecha.add(etiquetaFecha);
		panelFecha.add(campoFecha);
		
		mainPanel.add(panelFecha);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		//HORA
		JPanel panelHora = new JPanel();

		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
		JFormattedTextField campoHora = new JFormattedTextField(formatoHora);
		campoHora.setValue(new Date());
		
		JLabel etiquetaHora = new JLabel("Hora:");
		
		panelHora.add(etiquetaHora);
		panelHora.add(campoHora);
		
		Date hora = (Date) campoHora.getValue();
		
		mainPanel.add(panelHora);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(new TTurno(
						Integer.parseInt(id.getText()),
						nombre.getText() != null ? nombre.getText() : "" , 
								(Date) campoFecha.getValue(), 
						campoHora.getText()  != null ? campoHora.getText() : "",
						true), Evento.EModificarTurnoOK);
			}
			
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarTurno.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaTurnoGeneral);
			}
		});
		panelBotones.add(botonCancelar);

		this.setVisible(true);
		this.setResizable(true);
	}
	public void actualizar() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void actualizar(Object object, Evento event) {
	
	}
}