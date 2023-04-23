/**
 * 
 */
package Negocio.Personal;

import java.util.Set;
import Negocio.Turno.TTurno;

public interface SAPersonal {
	
	public Integer CrearPersonal(TPersonal tPersonal);

	public Class EiminarPersonal(TPersonal IdPersonal);

	public Class ModificarPersonal(Object tPersonal);

	public TPersonal MostrarUno(TPersonal IdPersonal);

	public Set<TPersonal> MostrarTodos();
	public Set<TPersonal> MostrarPersonalPorTurno(TTurno idTurno);
}