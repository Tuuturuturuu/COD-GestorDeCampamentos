/**
 * 
 */
package Presentacion.Personal.VMostrarTodos;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.Actividad.VMostrarTodasActividades.VMostrarTodasActividades;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;
import Presentacion.Personal.IGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import Negocio.Actividad.TActividad;
import Negocio.Personal.TPersonal;

import javax.swing.JLabel;
import javax.swing.JTable;

public class VMostrarTodos extends JFrame implements IGUI {
	public VMostrarTodos(Set<TPersonal> listaPersonal){
		super("Mostrar todo el Personal");
		this.setBounds(100, 100, 630, 330);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI((Set<TPersonal>) listaPersonal);
	}
	
	private void initGUI(Set<TPersonal> listaPersonal) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelID = new JPanel();
		mainPanel.add(panelID);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarTodos.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		String[] nombreColumnas = { "ID", "DNI", "Nombre", "Tipo Personal", "IdTurno",  "Activo" };
		JTable tabla = ComponentsBuilder.createTable(listaPersonal.size(), 7, nombreColumnas);
		int i = 0;
		for (TPersonal t : listaPersonal) {
			tabla.setValueAt(t.getIdPersonal(), i, 0);
			tabla.setValueAt(t.getDNI(), i, 1);
			tabla.setValueAt(t.getNombre(), i, 2);
			tabla.setValueAt(t.getTipoPersonal(), i, 3);
			tabla.setValueAt(t.getIdTurno(), i, 4);
			tabla.setValueAt(t.isActivo(), i, 5);
			i++;
		}
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(50, 115, 900, 288);
		this.add(scroll);

		this.setVisible(true);
		this.setResizable(true);
	}

	public void actualizar() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}