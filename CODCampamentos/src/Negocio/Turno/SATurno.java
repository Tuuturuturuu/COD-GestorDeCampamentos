/**
 * 
 */
package Negocio.Turno;

import java.util.Set;

public interface SATurno {
	public TTurno crearTurno(TTurno tTurno);
	public TTurno ModificarTurno(TTurno tTurno);
	public TTurno BorrarTurno(Integer idTurno);
	public TTurno MostrarTurno(Integer idTurno);
	public Set<TTurno> MostrarTurnos();
}