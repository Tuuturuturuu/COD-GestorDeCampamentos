/**
 * 
 */
package Integracion.Turno;

import java.util.Set;

import Negocio.Turno.TTurno;
public interface DAOTurno {
	public TTurno CrearTurno(TTurno tTurno);
	public TTurno EliminarTurno(TTurno tTurno);
	public TTurno ModificarTurno(TTurno tTurno);
	public TTurno MostrarTurno(Integer idTurno);
	public Set<TTurno> MostrarAllTurnos();
	public TTurno BuscarTurnoPorNombre(String NombreTurno);
	public Integer activar(Integer IdTurno);
}