package Presentacion.Factura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Factura.TFactura;
import Negocio.Material.TMaterial;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;
import Presentacion.Material.VistaMaterialGeneral;

public class VistaGeneralFactura extends JFrame{
	private JButton CrearFactura_Button;
	private JButton CerrarFactura_Button;
	private JButton AnadirActividadFactura_Button;
	private JButton QuitarActividadDeFactura_Button;
	private JButton devolverActividad_Button;
	private JButton mostrarUnaFactura_Button;
	private JButton mostrarTodasLasFacturas_Button;
	private JButton mostrarFacturaPorActividad_Button;
	private JButton backButton;

	private JPanel j;
	private TFactura tFactura;

	public VistaGeneralFactura() {
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

	public void update(Object object, Evento event) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void initGUI() {
		tFactura = new TFactura();
		JLabel label = ComponentsBuilder.createLabel("Factura", 250, 30, 500, 50, Color.BLACK);
		this.add(label);
		
		//CrearFactura
		CrearFactura_Button = ComponentsBuilder.createButton("Crear Factura", 85, 100, 200, 100);
		CrearFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EAbrirFactura);
			}

		});
		CrearFactura_Button.setVisible(true);
		this.add(CrearFactura_Button);
		
		//cerrarFactura
		CerrarFactura_Button = ComponentsBuilder.createButton("Cerrar Factura", 300, 100, 185, 100);
		CerrarFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.ECerrarFactura);

			}
		});

		CerrarFactura_Button.setVisible(true);
		this.add(CerrarFactura_Button);
		
		//A�adir Actividad a Factura
		AnadirActividadFactura_Button = ComponentsBuilder.createButton("A�adir Actividad a Factura", 500, 100, 185, 100);
		AnadirActividadFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EAnadirActividadFactura);
			}
		});
		
		AnadirActividadFactura_Button.setVisible(true);
		this.add(AnadirActividadFactura_Button);

		//Quitar Actividad De Factura
		QuitarActividadDeFactura_Button = ComponentsBuilder.createButton("Quitar Actividad de Factura", 700, 100, 200, 100);
		QuitarActividadDeFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EQuitarActividadFactura);

			}
		});
		QuitarActividadDeFactura_Button.setVisible(true);
		this.add(QuitarActividadDeFactura_Button);
		
		//Devolver Actividad 
		devolverActividad_Button = ComponentsBuilder.createButton("Devolucion de Actividad", 85, 250, 200, 100);
		devolverActividad_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EDelvolverUnaActividad);

			}
		});
		devolverActividad_Button.setVisible(true);
		this.add(devolverActividad_Button);
		
		// Mostrar una Factura
		mostrarUnaFactura_Button = ComponentsBuilder.createButton("Mostrar una Factura", 300, 250, 185, 100);
		mostrarUnaFactura_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EMostrarUnaFactura);
			}

		});
		mostrarUnaFactura_Button.setVisible(true);
		this.add(mostrarUnaFactura_Button);
		
		//	Mostrar Todas las facturas
		mostrarTodasLasFacturas_Button = ComponentsBuilder.createButton("Mostrar Todas Las Facturas", 500, 250, 185, 100);
		mostrarTodasLasFacturas_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(tFactura, Evento.EMostrarTodasLasFacturas);
			}
		});
		
		mostrarTodasLasFacturas_Button.setVisible(true);
		this.add(mostrarTodasLasFacturas_Button);
		
		// Mostrar Factura por Actividad
		mostrarFacturaPorActividad_Button = ComponentsBuilder.createButton("Mostrar Factura Por Actividad", 700, 250, 200, 100);
		mostrarFacturaPorActividad_Button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						VistaGeneralFactura.this.setVisible(false);
						Controlador.obtenerInstancia().run(tFactura, Evento.EMostrarFacturaPorActividad);
					}

				});
		mostrarFacturaPorActividad_Button.setVisible(true);
				this.add(mostrarFacturaPorActividad_Button);
				
				

		backButton = ComponentsBuilder.createBackButton();
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaGeneralFactura.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);

			}
		});

		backButton.setVisible(true);
		this.add(backButton);

		getContentPane().add(j);
		//pack();

	}
}
