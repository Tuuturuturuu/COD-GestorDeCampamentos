package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Presentacion.Actividad.VistaActividadGeneral;
import Presentacion.Actividad.VAltaActividad.VAltaActividad;
import Presentacion.Actividad.VBajaActividad.VBajaActividad;
import Presentacion.Actividad.VModificarActividad.VModificarActividad;
import Presentacion.Actividad.VMostrarActividad.VMostrarActividad;
import Presentacion.Actividad.VMostrarTodasActividades.VMostrarTodasActividades;

public interface FactoriaVistaActividad {
	public VAltaActividad getVista_AltaActividad();

	public VBajaActividad getVista_BajaActividad();

	public VModificarActividad getVista_ModificarActividad();

	public VMostrarActividad getVista_MostrarActividad();

	public VMostrarTodasActividades getVista_MostrarTodosActividad(Set<TActividad> listaActividad);

	public VistaActividadGeneral getVista_VistaActividadGeneral();

}
