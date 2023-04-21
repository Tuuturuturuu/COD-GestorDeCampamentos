package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Material.TMaterial;
import Presentacion.Material.VistaMaterialGeneral;
import Presentacion.Material.VAltaMaterial.VAltaMaterial;
import Presentacion.Material.VBajaMaterial.VBajaMaterial;
import Presentacion.Material.VModificarMaterial.VModificarMaterial;
import Presentacion.Material.VMostrarMaterial.VMostrarMaterial;
import Presentacion.Material.VMostrarMaterialPorActividad.VMostrarMaterialPorActividad;
import Presentacion.Material.VMostrarTodosMateriales.VMostrarTodosMateriales;


public class FactoriaVistaMaterialImp implements FactoriaVistaMaterial {

	@Override
	public VistaMaterialGeneral getVista_VistaMaterialGeneral() {
		
		return new VistaMaterialGeneral();
	}

	@Override
	public VAltaMaterial getVista_AltaMaterial() {
		return new VAltaMaterial();
	}

	@Override
	public VBajaMaterial getVista_BajaMaterial() {
		return new VBajaMaterial();
	}

	@Override
	public VModificarMaterial getVista_ModificarMaterial() {
		return new VModificarMaterial();
	}

	@Override
	public VMostrarMaterial getVista_MostrarMaterial() {
		return new VMostrarMaterial();
	}

	@Override
	public VMostrarTodosMateriales getVista_MostrarTodosMateriales(Set<TMaterial> listaMateriales) {
		return new VMostrarTodosMateriales(listaMateriales);
	}

	@Override
	public VMostrarMaterialPorActividad getVista_MostrarMaterialPorActividad() {
		return new VMostrarMaterialPorActividad();
	}
}