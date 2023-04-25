package Integracion.Turno;

import Negocio.Turno.TTurno;
import java.util.Set;

public interface DAOTurno {

	public TTurno CrearTurno(TTurno tTurno);

	public TTurno EliminarTurno(TTurno turno);

	public TTurno ModificarTurno(TTurno tTurno);

	public TTurno MostrarTurno(Integer integer);

	public Set<TTurno> MostrarAllTurnos();

	public TTurno buscarPorNombre(String nombreTurno);

	public void activar();
}