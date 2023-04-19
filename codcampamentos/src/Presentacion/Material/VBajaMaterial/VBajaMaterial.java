/**
 * 
 */
package Presentacion.Material.VBajaMaterial;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.Actividad.VAltaActividad.VAltaActividad;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VBajaMaterial extends JFrame implements IGUI {
	
	private JButton jButton;
	private JDialog jDialog;
	private JDialog jDialog2;
	private JFrame jFrame;
	private Set<JLabel> jLabel;
	private Set<JPanel> jPanel;
	
	public VBajaMaterial(){
		super("Eliminar Material");
		this.setBounds(100, 100, 430, 330);
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
				"Introduzca el id del material que quieres dar de baja", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelId = new JPanel();
		mainPanel.add(panelId);

		JLabel labelId = ComponentsBuilder.createLabel("ID Material: ", 10, 100, 80, 20, Color.BLACK);
		panelId.add(labelId);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelId.add(id);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VAltaMaterial.this.setVisible(false);

//				Controlador.obtenerInstancia().run(
//						new TActividad(0, nombre.getText(), dni.getText(), tfno.getText(), true), Evento.EAltaActividadOK);

			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VAltaMaterial.this.setVisible(false);
				//Controlador.obtenerInstancia().run(null, Evento.EVistaMaterialGeneral);

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