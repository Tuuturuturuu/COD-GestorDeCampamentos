package Presentacion.Factura.VAbrirFactura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;
import Presentacion.Evento;
import Presentacion.ComponentsBuilder.ComponentsBuilder;
import Presentacion.Controlador.Controlador;

public class VAbrirFacturaOk extends JFrame {

	private JButton CerrarFactura_Button;
	private JButton AnadirActividadFactura_Button;
	private JButton QuitarActividadDeFactura_Button;
	private JButton backButton;

	private TFactura tFactura;

	public VAbrirFacturaOk(TCarrito tCarrito) {
		super("Gestor de Campamentos");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 800;
		int alto = 600;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setLayout(null);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI(tCarrito);
		this.setVisible(true);
	}

	public void initGUI(TCarrito tCarrito) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);

		JLabel msgIntroIDCabecera = ComponentsBuilder.createLabel(
				"Introduzca el ID de la actividad que desea agregar a la factura ", 1, 10, 80, 20, Color.BLACK);
		msgIntroIDCabecera.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msgIntroIDCabecera);

		// Panel para agregar Actividad
		JPanel panelID = new JPanel();
		panelID.setBorder(new EmptyBorder(10, 10, 10, 10)); // agregado
		panelID.setAlignmentX(CENTER_ALIGNMENT); // agregado
		mainPanel.add(panelID);

		JLabel idActividad = new JLabel("Id Actividad");
		idActividad.setPreferredSize(new Dimension(100, 30));
		panelID.add(idActividad);

		JTextField id = new JTextField();
		id.setPreferredSize(new Dimension(250, 30));
		id.setEditable(true);
		panelID.add(id);

		JPanel panelPlazas = new JPanel();
		panelPlazas.setBorder(new EmptyBorder(10, 10, 10, 10)); // agregado
		panelPlazas.setAlignmentX(CENTER_ALIGNMENT); // agregado
		mainPanel.add(panelPlazas);

		JLabel plazas = new JLabel("Numero de plazas");
		plazas.setPreferredSize(new Dimension(100, 30));
		panelPlazas.add(plazas);

		JTextField nPlazas = new JTextField();
		nPlazas.setPreferredSize(new Dimension(250, 30));
		nPlazas.setEditable(true);
		panelPlazas.add(nPlazas);

		JPanel panelAniadirButton = new JPanel();
		panelAniadirButton.setBorder(new EmptyBorder(10, 10, 10, 10)); // agregado
		panelAniadirButton.setAlignmentX(CENTER_ALIGNMENT); // agregado
		mainPanel.add(panelAniadirButton);

		JButton botonAniadirActividad = new JButton("Aniadir");
		botonAniadirActividad.setBounds(75, 50, 100, 100);
		panelAniadirButton.add(botonAniadirActividad);

		// Panel Quitar Actividad
		JLabel msg = ComponentsBuilder.createLabel("Introduzca el ID de la actividad que desea eliminar de la factura ",
				1, 150, 80, 20, Color.BLACK);
		msg.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(msg);

		JPanel panelQuitar = new JPanel();
		panelQuitar.setBorder(new EmptyBorder(10, 10, 10, 10)); // agregado
		panelQuitar.setAlignmentX(CENTER_ALIGNMENT); // agregado
		mainPanel.add(panelQuitar);

		JLabel idActividadOut = new JLabel("Id Actividad");
		idActividadOut.setPreferredSize(new Dimension(100, 30));
		panelQuitar.add(idActividadOut);

		JTextField idOut = new JTextField();
		idOut.setPreferredSize(new Dimension(250, 30));

		idOut.setEditable(true);
		panelQuitar.add(idOut);

		JPanel panelQuitarButton = new JPanel();
		panelQuitarButton.setBorder(new EmptyBorder(10, 10, 10, 10)); // agregado
		panelQuitarButton.setAlignmentX(CENTER_ALIGNMENT); // agregado
		mainPanel.add(panelQuitarButton);

		JButton botonQuitarActividad = new JButton("Quitar");
		botonQuitarActividad.setBounds(75, 50, 100, 100);
		panelQuitarButton.add(botonQuitarActividad);

		// Panel para Tabla

		Set<TLineaFactura> LineasFactura = tCarrito.gettLineaFactura();
		String[] nombreColumnas = { "IdActividad", "Precio", "Cantidad" };
		JTable tabla = ComponentsBuilder.createTable(LineasFactura.size(), 3, nombreColumnas);
		int i = 0;
		for (TLineaFactura t : LineasFactura) {
			tabla.setValueAt(t.getIdActividad(), i, 0);
			tabla.setValueAt(t.getPrecio(), i, 1);
			tabla.setValueAt(t.getCantidad(), i, 2);
			i++;
		}
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(50, 115, 900, 288);
		this.add(scroll);

		// Panel de botones
		JPanel panelBotones = new JPanel();
		mainPanel.add(panelBotones);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(75, 50, 100, 100);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFacturaOk.this.setVisible(false);
				try {
					Controlador.obtenerInstancia().run(!id.getText().isEmpty() ? Integer.parseInt(id.getText()) : 0,
							Evento.EMostrarTodosLosActividadporMaterialOK);
				} catch (Exception ex) {
					Controlador.obtenerInstancia().run(-38, Evento.EMostrarTodosLosActividadporMaterialOK);
				}

			}
		});
		panelBotones.add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(200, 50, 100, 100);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAbrirFacturaOk.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaFacturaGeneral);

			}
		});
		panelBotones.add(botonCancelar);

		JButton botonCerrar = new JButton("Cerrar Factura");
		botonCerrar.setBounds(75, 50, 100, 100);
		panelBotones.add(botonCerrar);
		this.setVisible(true);
		this.setResizable(true);

	}

	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub

	}
}
