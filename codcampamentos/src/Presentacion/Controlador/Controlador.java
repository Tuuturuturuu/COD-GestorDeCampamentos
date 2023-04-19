
package Presentacion.Controlador;

import Presentacion.Evento;

public abstract class Controlador {
	
	
	public static Controlador controlador;
	 
	 
	public static Controlador obtenerInstancia() {

		return new ControladorImp();

	}
	
	public abstract void run(Object Obj, Evento Evento);


	
	public void accion() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}