package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Presentacion.Actividad.VistaActividadGeneral;
import Presentacion.Actividad.VAltaActividad.VAltaActividad;
import Presentacion.Actividad.VBajaActividad.VBajaActividad;
import Presentacion.Actividad.VModificarActividad.VModificarActividad;
import Presentacion.Actividad.VMostrarActividad.VMostrarActividad;
import Presentacion.Actividad.VMostrarActividadesPorMaterial.MostrarActividadPorMaterialOK;
import Presentacion.Actividad.VMostrarActividadesPorMaterial.VMostrarActividadesPorMaterial;
import Presentacion.Actividad.VMostrarActividadesPorPersonal.VMostrarActividadesPorPersonal;
import Presentacion.Actividad.VMostrarActividadesPorPersonal.VMostrarActividadesPorPersonalOK;
import Presentacion.Actividad.VMostrarTodasActividades.VMostrarTodasActividades;
import Presentacion.Actividad.VVincularActividadConMaterial.VVincularActividadConMaterial;

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
	public VMostrarTodasActividades getVista_MostrarTodosActividad(Set<TActividad> listaActividades) {

		return new VMostrarTodasActividades(listaActividades);
	}

	@Override
	public VistaActividadGeneral getVista_VistaActividadGeneral() {

		return new VistaActividadGeneral();
	}

	public VMostrarActividadesPorPersonal getVista_MostrarActividadPorPersonal() {
		return new VMostrarActividadesPorPersonal();
	}

	@Override
	public VMostrarActividadesPorPersonalOK getVista_MostrarActividadPorPersonalOK(Set<TActividad> listaActividades) {
		// TODO Auto-generated method stub
		return new VMostrarActividadesPorPersonalOK(listaActividades);
	}

	@Override
	public VMostrarActividadesPorMaterial getVista_MostrarActividadPorMaterial() {
		// TODO Auto-generated method stub
		return new VMostrarActividadesPorMaterial();
	}

	@Override
	public MostrarActividadPorMaterialOK getVista_MostrarActividadPorMaterialOK(Set<TActividad> listaActividad) {
		// TODO Auto-generated method stub
		return new MostrarActividadPorMaterialOK(listaActividad);
	}

	@Override
	public VVincularActividadConMaterial getVista_Vincular() {
		// TODO Auto-generated method stub
		return new VVincularActividadConMaterial();
	}

}
