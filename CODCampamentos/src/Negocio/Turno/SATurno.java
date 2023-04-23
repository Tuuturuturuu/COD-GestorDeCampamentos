package Negocio.Turno;

import java.util.Set;

//EN PRINCIPIO ESTA TODO

public interface SATurno {
	
	public TTurno crearTurno(TTurno tTurno);
	
	public Integer ModificarTurno(TTurno tTurno);
	
	public 	Integer BorrarTurno(TTurno tTurno);

	public TTurno MostrarTurno(TTurno tTurno);

	public Set<TTurno> MostrarTurnos();
}


