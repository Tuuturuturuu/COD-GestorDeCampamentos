package Integracion.Personal;

import Negocio.Personal.TPersonal;
import Negocio.Turno.TTurno;

import java.util.Set;


public interface DAOPersonal {

	public TPersonal CrearPersonal(TPersonal tPersonal);

	public TPersonal EliminarPersonal(TPersonal IdPersonal);

	public TPersonal MostrarUno(Integer idPersonal);

	public Set<TPersonal> MostrarTodos();

	public Set<TPersonal> MostrarPersonalPorTurno(Integer IdTurno);
	
	public Set<TPersonal> MostrarPersonalActivoPorTurno(Integer IdTurno);

	public TPersonal ModificarPersonal(TPersonal tPersonal);

	public TPersonal buscarPorDNI(TPersonal tPersonal);
	
	public Integer activar(Integer IdPersonal);
}