package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Turno.TTurno;
import Presentacion.Turno.VTurno;
import Presentacion.Turno.VAltaTurno.VAltaTurno;
import Presentacion.Turno.VBajaTurno.VBajaTurno;
import Presentacion.Turno.VModificarTurno.VModificarTurno;
import Presentacion.Turno.VMostrarTodosTurnos.VMostrarTodosTurnos;
import Presentacion.Turno.VMostrarTurno.VMostrarTurno;


public interface FactoriaVistaTurno {
	public VAltaTurno getVista_AltaTurno();

	public VBajaTurno getVista_BajaTurno();

	public VModificarTurno getVista_ModificarTurno();

	public VMostrarTurno getVista_MostrarTurno();

	public VMostrarTodosTurnos getVista_MostrarTodosTurnos(Set<TTurno> listaTurnos);
	
	public VTurno getVista_VistaTurnoGeneral();
}
