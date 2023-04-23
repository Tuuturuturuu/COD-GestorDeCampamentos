package Integracion.Turno;

import Negocio.Turno.TTurno;
import java.util.Set;

public interface DAOTurno {

	public Integer CrearTurno(TTurno tTurno);

	public Integer EliminarTurno(TTurno turno);

	public Integer ModificarTurno(TTurno tTurno);

	public TTurno MostrarTurno(Integer integer);

	public Set<TTurno> MostrarAllTurnos();

	public TTurno buscarPorNombre(String nombreTurno);

	public void activar();
}