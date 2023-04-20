/**
 * 
 */
package Negocio.Turno;

import java.util.Set;

//EN PRINCIPIO ESTA TODO

public interface SATurno {
	
	public Integer crearTurno(TTurno tTurno);
	
	public Integer ModificarTurno(TTurno tTurno);
	
	public Integer BorrarTurno(Integer idTurno);

	public TTurno MostrarTurno(Integer idTurno);

	public Set<TTurno> MostrarTurnos();
}