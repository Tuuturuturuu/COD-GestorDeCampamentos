package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Presentacion.Actividad.VistaActividadGeneral;
import Presentacion.Actividad.VAltaActividad.VAltaActividad;
import Presentacion.Actividad.VBajaActividad.VBajaActividad;
import Presentacion.Actividad.VModificarActividad.VModificarActividad;
import Presentacion.Actividad.VMostrarActividad.VMostrarActividad;
import Presentacion.Actividad.VMostrarTodasActividades.VMostrarTodasActividades;

public class FactoriaVistaActividadImp implements FactoriaVistaActividad {

	@Override
	public VAltaActividad getVista_AltaActividad() {

		return new VAltaActividad();
	}

	@Override
	public VBajaActividad getVista_BajaActividad() {

		return new VBajaActividad();
	}

	@Override
	public VModificarActividad getVista_ModificarActividad() {

		return new VModificarActividad();
	}

	@Override
	public VMostrarActividad getVista_MostrarActividad() {

		return new VMostrarActividad();
	}

	@Override
	public VMostrarTodasActividades getVista_MostrarTodosActividad(Set<TActividad> listaActividad) {

		return new VMostrarTodasActividades();
	}

	@Override
	public VistaActividadGeneral getVista_VistaActividadGeneral() {

		return new VistaActividadGeneral();
	}

}
