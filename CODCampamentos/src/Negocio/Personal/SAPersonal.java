/**
 * 
 */
package Negocio.Personal;

import java.util.Set;
import Negocio.Turno.TTurno;

public interface SAPersonal {

	public TPersonal crearPersonal(TPersonal tPersonal);

	public TPersonal eliminarPersonal(TPersonal tPersonal);

	public TPersonal modificarPersonal(TPersonal tPersonal);

	public TPersonal mostrarUno(TPersonal tPersonal);

	public Set<TPersonal> mostrarTodos();

	public Set<TPersonal> mostrarPersonalPorTurno(TTurno turno);
}