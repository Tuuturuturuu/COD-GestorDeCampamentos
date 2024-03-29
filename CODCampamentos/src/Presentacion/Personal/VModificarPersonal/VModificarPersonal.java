/**
 * 
 */
package Presentacion.Personal.VModificarPersonal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Personal.TPersonal;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VModificarPersonal extends JFrame implements IGUI {
	public VModificarPersonal() {
		super("Modificar Personal");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 630;
		int alto = 330;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	public void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		// ID
		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel("Introduzca el ID del Personal que quiere modificar ",
				1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelID = new JPanel();
		mainPanel.add(panelID);

		JLabel labelID = ComponentsBuilder.createLabel("           ID Personal: ", 10, 100, 80, 20, Color.BLACK);
		panelID.add(labelID);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelID.add(id);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// NOMBRE
		JPanel panelNombre = new JPanel();
		mainPanel.add(panelNombre);

		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre Personal: ", 10, 100, 80, 20, Color.BLACK);
		panelNombre.add(labelNombre);

		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(250, 30));
		nombre.setEditable(true);
		panelNombre.add(nombre);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// ID TURNO
		JPanel panelIDTurno = new JPanel();
		mainPanel.add(panelIDTurno);

		JLabel labelIDTurno = ComponentsBuilder.createLabel("ID Turno: ", 10, 100, 80, 20, Color.BLACK);
		panelIDTurno.add(labelIDTurno);

		JTextField idTurno = new JTextField();
		idTurno.setPreferredSize(new Dimension(250, 30));
		idTurno.setEditable(true);
		panelIDTurno.add(idTurno);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarPersonal.this.setVisible(false);

				try {
					Controlador.obtenerInstancia()
							.run(new TPersonal(Integer.parseInt(id.getText()), "",
									nombre.getText() != null ? nombre.getText() : "", 0,
									!idTurno.getText().isEmpty() ? Integer.parseInt(idTurno.getText()) : 0, true),
									Evento.EModificarPersonalOK);
				} catch (Exception ex) {
					Controlador.obtenerInstancia().run(new TPersonal(-38, null, null, 0, null, true),
							Evento.EModificarPersonalOK);
				}

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarPersonal.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub

	}

}