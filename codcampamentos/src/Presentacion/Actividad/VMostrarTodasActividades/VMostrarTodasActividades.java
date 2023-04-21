
package Presentacion.Actividad.VMostrarTodasActividades;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;

import Negocio.Actividad.TActividad;

public class VMostrarTodasActividades extends JFrame implements IGUI {
	public VMostrarTodasActividades(Set<TActividad> listaActividades){
		super("Mostrar todas las Actividades");
		this.setBounds(100, 100, 630, 330);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI((Set<TActividad>) listaActividades);
	}
	
	private void initGUI(Set<TActividad> listaActividades) {
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
				VMostrarTodasActividades.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaActividadGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		String[] nombreColumnas = { "ID", "Nombre", "Lugar", "Num Plazas", "Precio", "Id Empleado", "Activa" };
		JTable tabla = ComponentsBuilder.createTable(listaActividades.size(), 7, nombreColumnas);
		int i = 0;
		for (TActividad t : listaActividades) {
			tabla.setValueAt(t.getIdActividad(), i, 0);
			tabla.setValueAt(t.getNombre(), i, 1);
			tabla.setValueAt(t.getLugar(), i, 2);
			tabla.setValueAt(t.getNumplazas(), i, 3);
			tabla.setValueAt(t.getPrecio(), i, 4);
			tabla.setValueAt(t.getIdPersonal(), i, 5);
			tabla.setValueAt(t.getActivo(), i, 6);
			i++;
		}
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(50, 115, 900, 288);
		this.add(scroll);

		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}