/**
 * 
 */
package Presentacion.Actividad.VVincularActividadConMaterial;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;
import Presentacion.Material.VVincularMaterialActividad.VVincularMaterialActividad;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Material.TMaterial;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;


public class VVincularActividadConMaterial extends JFrame implements IGUI {

	public VVincularActividadConMaterial(){
		super("Vincular Actividad con Material");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 600;
		int alto = 330;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
				"Introduzca los IDs de la actividad que quieres vincular y el material correspondiente", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		// ID material
		JPanel panelMatId = new JPanel();
		mainPanel.add(panelMatId);

		JLabel labelMatId = ComponentsBuilder.createLabel("ID Material: ", 10, 100, 80, 20, Color.BLACK);
		panelMatId.add(labelMatId);

		JTextField matId = new JTextField();
		matId.setPreferredSize(new Dimension(250, 30));
		matId.setEditable(true);
		panelMatId.add(matId);
		
		// ID actividad
		JPanel panelActId = new JPanel();
		mainPanel.add(panelActId);

		JLabel labelActId = ComponentsBuilder.createLabel("ID Actividad: ", 10, 100, 80, 20, Color.BLACK);
		panelActId.add(labelActId);

		JTextField actId = new JTextField();
		actId.setPreferredSize(new Dimension(250, 30));
		actId.setEditable(true);
		panelActId.add(actId);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VVincularActividadConMaterial.this.setVisible(false);
				try{
					Controlador.obtenerInstancia().run(
							new TMaterial(!matId.getText().isEmpty() ? Integer.parseInt(matId.getText()) : 0, null, null, null,  !actId.getText().isEmpty() ? Integer.parseInt(actId.getText()) : 0, null), Evento.EVincularMaterialActividadOK);
				}
				catch(Exception ex){
					Controlador.obtenerInstancia().run(
							new TMaterial(-38, null, null, null,  null, null), Evento.EVincularMaterialActividadOK);
				}
			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VVincularActividadConMaterial.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaMaterialGeneral);

			}
		});
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(botonAceptar);
		panelBotones.add(botonCancelar);
		mainPanel.add(panelBotones);

		this.setVisible(true);
		
	}

	public void actualizar() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}