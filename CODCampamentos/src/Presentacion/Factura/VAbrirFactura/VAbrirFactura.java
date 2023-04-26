
package Presentacion.Factura.VAbrirFactura;

import javax.swing.JFrame;

import Presentacion.Evento;
import Presentacion.IGUI;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;
import Presentacion.Factura.VistaGeneralFactura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Negocio.Factura.TFactura;


public class VAbrirFactura extends JFrame {
	private JButton CerrarFactura_Button;
	private JButton AnadirActividadFactura_Button;
	private JButton QuitarActividadDeFactura_Button;
	private JButton backButton;
	
	private JPanel j;
	private TFactura tFactura;
	
	public VAbrirFactura(){
		super("Gestor de Campamentos");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 1000;
		int alto = 525;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);
		j = new JPanel();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}
	
	public void initGUI() {
		tFactura = new TFactura();
		JLabel label = ComponentsBuilder.createLabel("Factura", 250, 30, 500, 50, Color.BLACK);
		this.add(label);
		
	
		
		//cerrarFactura
		CerrarFactura_Button = ComponentsBuilder.createButton("Cerrar Factura", 100, 150, 185, 100);
		CerrarFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.ECerrarFactura);

			}
		});

		CerrarFactura_Button.setVisible(true);
		this.add(CerrarFactura_Button);
		
		
		//Añadir Actividad a Factura
		AnadirActividadFactura_Button = ComponentsBuilder.createButton("Añadir Actividad a Factura", 400, 150, 185, 100);
		AnadirActividadFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EAñadirActividadFactura);
			}
		});
		
		AnadirActividadFactura_Button.setVisible(true);
		this.add(AnadirActividadFactura_Button);
		
		
		//Quitar Actividad De Factura
		QuitarActividadDeFactura_Button = ComponentsBuilder.createButton("Quitar Actividad de Factura", 700, 150, 200, 100);
		QuitarActividadDeFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EQuitarActividadFactura);

			}
		});
		QuitarActividadDeFactura_Button.setVisible(true);
		this.add(QuitarActividadDeFactura_Button);
		

		
		
				
				

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});

		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
	
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		
	}
}