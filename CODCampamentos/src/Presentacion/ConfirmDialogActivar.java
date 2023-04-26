package Presentacion;

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

import Presentacion.Controlador.Controlador;

public class ConfirmDialogActivar extends JFrame implements IGUI  {

	private int id;

	public ConfirmDialogActivar() {
		super("Mensaje de confirmacion al activar ");
		initGUI();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 300;
		int alto = 200;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);

		JPanel aux = new JPanel();
		panel.add(aux);
		JLabel info = new JLabel("Has vuelto a activar un objeto inactivo");
		aux.add(info);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel botonPanel = new JPanel();
		panel.add(botonPanel);
		JButton confirmar = new JButton("OK");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfirmDialogActivar.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);
			}

		});
		botonPanel.add(confirmar);
	}
	
	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		if (object != null) {
			Integer res = (Integer) object;
			this.id = res;
			initGUI();
		}
	}

}
