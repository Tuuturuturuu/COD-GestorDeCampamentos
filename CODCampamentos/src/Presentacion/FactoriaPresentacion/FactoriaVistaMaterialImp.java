package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Material.TMaterial;
import Presentacion.Material.VistaMaterialGeneral;
import Presentacion.Material.VAltaMaterial.VAltaMaterial;
import Presentacion.Material.VBajaMaterial.VBajaMaterial;
import Presentacion.Material.VModificarMaterial.VModificarMaterial;
import Presentacion.Material.VMostrarMaterial.VMostrarMaterial;
import Presentacion.Material.VMostrarTodosMateriales.VMostrarTodosMateriales;

public class FactoriaVistaMaterialImp implements FactoriaVistaMaterial {

	@Override
	public VAltaMaterial getVista_AltaActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VBajaMaterial getVista_BajaActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VModificarMaterial getVista_ModificarActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMostrarMaterial getVista_MostrarActividad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VistaMaterialGeneral getVista_VistaMaterialGeneral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMostrarTodosMateriales getVista_MostrarTodosActividad(Set<TMaterial> listaActividad) {
		// TODO Auto-generated method stub
		return null;
	}

}
