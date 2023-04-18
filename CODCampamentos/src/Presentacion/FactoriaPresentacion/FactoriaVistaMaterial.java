package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Material.TMaterial;
import Presentacion.Material.VistaMaterialGeneral;
import Presentacion.Material.VAltaMaterial.VAltaMaterial;
import Presentacion.Material.VBajaMaterial.VBajaMaterial;
import Presentacion.Material.VModificarMaterial.VModificarMaterial;
import Presentacion.Material.VMostrarMaterial.VMostrarMaterial;
import Presentacion.Material.VMostrarTodosMateriales.VMostrarTodosMateriales;


public interface FactoriaVistaMaterial {
	public VAltaMaterial getVista_AltaActividad();

	public VBajaMaterial getVista_BajaActividad();

	public VModificarMaterial getVista_ModificarActividad();

	public VMostrarMaterial getVista_MostrarActividad();

	public VMostrarTodosMateriales getVista_MostrarTodosActividad(Set<TMaterial> listaActividad);

	public VistaMaterialGeneral getVista_VistaMaterialGeneral();
	
}
