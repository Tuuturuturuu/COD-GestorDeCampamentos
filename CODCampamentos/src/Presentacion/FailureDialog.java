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

public class FailureDialog extends JFrame implements IGUI {

	// Errores Genericos
	private static final String error1 = "Error: ID no encontrado en la BD";
	private static final String error2 = "Error: Nombre con longitud incorrecta";
	private static final String error14 = "Error: Id no valido";
	private static final String error5 = "Error: Dicho objeto se encuentra inactivo";
	private static final String error6 = "Error: Campo unico ya en uso";
	private static final String error15 = "Error: Fallo a la hora de borrar en la BD";
	private static final String error32 = "Error: El DNI introducido es incorrecto";
	private static final String error33 = "Error: El DNI introducido ya corresponde a un Personal";
	private static final String error37 = "Error: No se pueden dejar campos vacios en ALTA";
	private static final String error38 = "Error: Caracter introducido invalido";

	// Errores Actividad
	private static final String error4 = "Error: Actividad ya presente en la BD";
	private static final String error3 = "Error: Lugar especificado con longitud incorrecta";
	private static final String error7 = "Error: Numero de plazas con longitud incorrecta";
	private static final String error8 = "Error: El precio con longitud incorrecta";
	private static final String error22 = "Error: Fallo en desvincular Actividad y Material";
	private static final String error23 = "Error: No existe actividad con dicho ID";
	private static final String error25 = "Error: La actividad esta dada de baja";
	private static final String error36 = "Error: El lugar y el nombre de la actividad no pueden estar duplicados";

	// Errores Personal
	private static final String error9 = "Error: El personal con dicho ID, no existe";
	private static final String error16 = "Error: campo especialidad incorrecto";
	private static final String error17 = "Error: campo estudios incorrecto";
	private static final String error18 = "Error: campo puesto incorrecto";
	private static final String error19 = "Error: campo Anios de Experiencia incorrecto";
	private static final String error20 = "Error: El DNI ya se encuentra en la BD";
	private static final String error21 = "Error: Ya estaba desactivado";
	private static final String error24 = "Error: Fallo a la hora de vincular Actividad con el Material";
	private static final String error28 = "Error: El personal se encuentra inactivo";
	private static final String error35 = "Error: El personal tiene actividades activas";
	private static final String error39 = "Error: El DNI introducido ya corresponde a un Personal Activo";

	// Errores Material
	private static final String error10 = "Error: El almacen introducido con longitud incorrecta";
	private static final String error11 = "Error: Numero de existencias introducido con longitud incorrecta";
	private static final String error12 = "Error: El material esta dado de baja";
	private static final String error13 = "Error: No hay ningun material para ese id de Actividad";
	private static final String error26 = "Error: Ya hay material con este nombre";
	private static final String error27 = "Error: No hay material con dicho id";

	// Errores Turno
	private static final String error29 = "Error: El nombre del turno ya existe ";
	private static final String error30 = "Error: Turno ya activo en BBDDexiste ";
	private static final String error31 = "Error: El Turno tiene personal activo asignado";
	private static final String error34 = "Error: El Turno está dado de baja";

	private int id;

	public FailureDialog() {
		super("Mensaje de fracaso");
		initGUI();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = 400;
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
		JLabel info;
		switch (id) {
		case -1:
			info = new JLabel(error1);
			break;
		case -2:
			info = new JLabel(error2);
			break;
		case -3:
			info = new JLabel(error3);
			break;
		case -4:
			info = new JLabel(error4);
			break;
		case -5:
			info = new JLabel(error5);
			break;
		case -6:
			info = new JLabel(error6);
			break;
		case -7:
			info = new JLabel(error7);
			break;
		case -8:
			info = new JLabel(error8);
			break;
		case -9:
			info = new JLabel(error9);
			break;
		case -10:
			info = new JLabel(error10);
			break;
		case -11:
			info = new JLabel(error11);
			break;
		case -12:
			info = new JLabel(error12);
			break;
		case -13:
			info = new JLabel(error13);
			break;
		case -14:
			info = new JLabel(error14);
			break;
		case -15:
			info = new JLabel(error15);
			break;
		case -16:
			info = new JLabel(error16);
			break;
		case -17:
			info = new JLabel(error17);
			break;
		case -18:
			info = new JLabel(error18);
			break;
		case -19:
			info = new JLabel(error19);
			break;
		case -20:
			info = new JLabel(error20);
			break;
		case -21:
			info = new JLabel(error21);
			break;
		case -22:
			info = new JLabel(error22);
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
		case -26:
			info = new JLabel(error26);
			break;
		case -27:
			info = new JLabel(error27);
			break;
		case -28:
			info = new JLabel(error28);
			break;
		case -29:
			info = new JLabel(error29);
			break;
		case -30:
			info = new JLabel(error30);
			break;
		case -31:
			info = new JLabel(error31);
			break;
		case -32:
			info = new JLabel(error32);
			break;
		case -33:
			info = new JLabel(error33);
			break;
		case -34:
			info = new JLabel(error34);
			break;
		case -35:
			info = new JLabel(error35);
			break;
		case -36:
			info = new JLabel(error36);
			break;
		case -37:
			info = new JLabel(error37);
			break;
		case -38:
			info = new JLabel(error38);
			break;
		case -39:
			info = new JLabel(error39);
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
				FailureDialog.this.setVisible(false);
				Controlador.obtenerInstancia().run(null, Evento.EVistaGeneral);
			}

		});
		botonPanel.add(confirmar);
	}

	@Override
	public void actualizar(Object object, Evento event) {
		if (object != null) {
			Integer res = (Integer) object;
			this.id = res;
			initGUI();
		}

	}

}