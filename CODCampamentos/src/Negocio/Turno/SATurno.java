/**
 * 
 */
package Negocio.Turno;

import java.util.Set;

public interface SATurno {
	public TTurno crearTurno(TTurno tTurno);
	public TTurno ModificarTurno(TTurno tTurno);
	public TTurno BorrarTurno(TTurno tTurno);
	public TTurno MostrarTurno(TTurno tTurno);
	public Set<TTurno> MostrarTurnos();
}