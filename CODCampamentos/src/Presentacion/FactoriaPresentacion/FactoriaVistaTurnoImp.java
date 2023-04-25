package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Turno.TTurno;
import Presentacion.Turno.VTurno;
import Presentacion.Turno.VAltaTurno.VAltaTurno;
import Presentacion.Turno.VBajaTurno.VBajaTurno;
import Presentacion.Turno.VModificarTurno.VModificarTurno;
import Presentacion.Turno.VMostrarTodosTurnos.VMostrarTodosTurnos;
import Presentacion.Turno.VMostrarTurno.VMostrarTurno;

public class FactoriaVistaTurnoImp implements FactoriaVistaTurno {

	@Override
	public VAltaTurno getVista_AltaTurno() {
		return new VAltaTurno();
	}

	@Override
	public VBajaTurno getVista_BajaTurno() {
		
		return new VBajaTurno();
	}

	@Override
	public VModificarTurno getVista_ModificarTurno() {
		return new VModificarTurno();
	}

	@Override
	public VMostrarTurno getVista_MostrarTurno() {
		return new VMostrarTurno();
	}

	@Override
	public VMostrarTodosTurnos getVista_MostrarTodosTurnos(Set<TTurno> listaTurnos) {
		return new VMostrarTodosTurnos(listaTurnos);
	}

	@Override
	public VTurno getVista_VistaTurnoGeneral() {
		return new VTurno();
	}

}
