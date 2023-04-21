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



public interface FactoriaVistaMaterial {
	public VistaMaterialGeneral getVista_VistaMaterialGeneral() ;

	public VAltaMaterial getVista_AltaMaterial();

	public VBajaMaterial getVista_BajaMaterial();

	public VModificarMaterial getVista_ModificarMaterial();

	public VMostrarMaterial getVista_MostrarMaterial();

	public VMostrarTodosMateriales getVista_MostrarTodosMateriales(Set<TMaterial> listaMateriales);

	public VMostrarMaterialPorActividad getVista_MostrarMaterialPorActividad();

}
