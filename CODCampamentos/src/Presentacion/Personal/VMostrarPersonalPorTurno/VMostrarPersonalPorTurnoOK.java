package Presentacion.Personal.VMostrarPersonalPorTurno;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VMostrarPersonalPorTurnoOK extends JFrame implements IGUI {

	public VMostrarPersonalPorTurnoOK(Set<TPersonal> listaPersonal) {
		super("Mostrar todo el Personal de un Turno");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 630;
		int alto = 330;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
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
				VMostrarPersonalPorTurnoOK.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaPersonalGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		String[] nombreColumnas = { "ID", "DNI", "Nombre", "Tipo Personal", "IdTurno", "Activo", "Especialidad",
				"Estudios", "Puesto", "A�os Experiencia" };
		JTable tabla = ComponentsBuilder.createTable(listaPersonal.size(), 10, nombreColumnas);
		int i = 0;
		for (TPersonal t : listaPersonal) {
			tabla.setValueAt(t.getIdPersonal(), i, 0);
			tabla.setValueAt(t.getDNI(), i, 1);
			tabla.setValueAt(t.getNombre(), i, 2);
			tabla.setValueAt(t.getTipo(), i, 3);
			tabla.setValueAt(t.getIdTurno(), i, 4);
			tabla.setValueAt(t.getIsActivo(), i, 5);
			if (t.getTipo() == 0) {
				TPersonalMonitor aux = (TPersonalMonitor) t;
				tabla.setValueAt(aux.getEspecialidad(), i, 6);
				tabla.setValueAt(aux.getEstudios(), i, 7);
				tabla.setValueAt(null, i, 8);
				tabla.setValueAt(null, i, 9);
			} else {
				TPersonalCocinero aux = (TPersonalCocinero) t;
				tabla.setValueAt(null, i, 6);
				tabla.setValueAt(null, i, 7);
				tabla.setValueAt(aux.getPuestoEnCocina(), i, 8);
				tabla.setValueAt(aux.getAniosExperiencia(), i, 9);
			}
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
