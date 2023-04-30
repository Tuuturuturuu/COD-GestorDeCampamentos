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

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Presentacion.Controlador.Controlador;

public class FailureDialogFactura extends JFrame implements IGUI {

	// Errores Genericos
	private static final String error37 = "Error: No se pueden dejar campos vacios";

	// Errores sobre Actividad
	private static final String error7 = "Error: Numero de plazas con longitud incorrecta";
	private static final String error25 = "Error: La actividad esta dada de baja";
	private static final String error23 = "Error: No existe actividad con dicho ID";

	// Errores sobre el carrito
	private static final String error24 = "Error: La actividad a eliminar no esta en el carrito";

	private TCarrito tCarrito = new TCarrito();

	public FailureDialogFactura(TCarrito tCarrito) {
		super("Mensaje de fracaso");
		initGUI(tCarrito);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 400;
		int alto = 200;
		int x = (pantalla.width - ancho) / 2;
		int y = (pantalla.height - alto) / 2;
		this.setBounds(x, y, ancho, alto);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initGUI(TCarrito tCarrito) {

		int id = tCarrito.gettFactura().getIdCliente();

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);

		JPanel aux = new JPanel();
		panel.add(aux);
		JLabel info;
		switch (id) {
		case -7:
			info = new JLabel(error7);
			break;
		case -23:
			info = new JLabel(error23);
			break;
		case -24:
			info = new JLabel(error24);
			break;
		case -25:
			info = new JLabel(error25);
			break;
		case -37:
			info = new JLabel(error37);
			break;
		default:
			info = new JLabel("Error en la operacion");

		}
		aux.add(info);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel botonPanel = new JPanel();
		panel.add(botonPanel);
		JButton confirmar = new JButton("OK");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FailureDialogFactura.this.setVisible(false);
				// Recupero el id del cliente
				TFactura tFactura = tCarrito.gettFactura();
				tFactura.setIdCliente(tFactura.getIdFactura());
				// Pongo el id de Factura en 0
				tFactura.setIdFactura(0);
				tCarrito.settFactura(tFactura);
				Controlador.obtenerInstancia().run(tCarrito, Evento.EVistaCrearFacturaFailure);
			}

		});
		botonPanel.add(confirmar);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		// TODO Auto-generated method stub
		if (object != null) {
			TCarrito res = (TCarrito) object;
			this.tCarrito = res;
			initGUI(this.tCarrito);
		}
	}

}
