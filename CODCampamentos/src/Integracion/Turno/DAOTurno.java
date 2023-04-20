
package Integracion.Turno;

import Negocio.Turno.TTurno;
import java.util.Set;

//EN PRINCIPIO ESTA
public interface DAOTurno {
	public Integer CrearTurno(TTurno tTurno);

	public Integer EliminarTurno(Integer id);

	public Integer ModificarTurno(TTurno tTurno);

	public TTurno MostrarTurno(Integer idTurno);
	
	public Set<TTurno> MostrarAllTurnos();

	public TTurno buscarPorNombre(String nombreTurno);

	public void activar();
}