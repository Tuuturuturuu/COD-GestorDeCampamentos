package Presentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGeneral extends JFrame{
	
	private Object controlador;
	
	private JButton VistaActividadGeneral_Button;
	private JButton VistaPersonalGeneral_Button;
	private JButton VistaFacturaGeneral_Button;
	private JButton VistaMaterialGeneral_Button;
	private JButton VistaTurnoGeneral_Button;
	
	private JLabel label;

	public VistaGeneral() {
		super("Gestor de Campamentos");
		this.setBounds(100, 100, 950, 500);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI() {
		
		label = ComponentsBuilder.createLabel("Selecciona el módulo sobre el cual quieres trabajar", 50, 30, 900, 50,
				Color.BLACK);
		this.add(label);

		VistaActividadGeneral_Button = ComponentsBuilder.createButton("Actividad", 100, 120, 185, 100);
		VistaActividadGeneral_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaActividadGeneral);

			}
		});

		this.add(VistaActividadGeneral_Button);

		VistaPersonalGeneral_Button = ComponentsBuilder.createButton("Personal", 350, 120, 185, 100);
		VistaPersonalGeneral_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

			}
		});

		this.add(VistaPersonalGeneral_Button);

		VistaFacturaGeneral_Button = ComponentsBuilder.createButton("Factura", 600, 120, 185, 100);
		VistaFacturaGeneral_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaFacturaGeneral);

			}
		});

		this.add(VistaFacturaGeneral_Button);

		VistaMaterialGeneral_Button = ComponentsBuilder.createButton("Material", 200, 300, 185, 100);
		VistaMaterialGeneral_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaMaterialGeneral);

			}
		});

		this.add(VistaMaterialGeneral_Button);

		VistaTurnoGeneral_Button = ComponentsBuilder.createButton("Turno", 500, 300, 185, 100);
		VistaTurnoGeneral_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneral.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaTurnoGeneral);

			}
		});

		this.add(VistaTurnoGeneral_Button);

		
	
	}


}
