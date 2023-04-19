package Presentacion.FactoriaPresentacion;

import Presentacion.Material.VistaMaterialGeneral;
<<<<<<< Updated upstream
import Presentacion.Material.VAltaMaterial.VAltaMaterial;
import Presentacion.Material.VBajaMaterial.VBajaMaterial;
import Presentacion.Material.VModificarMaterial.VModificarMaterial;
import Presentacion.Material.VMostrarMaterial.VMostrarMaterial;
import Presentacion.Material.VMostrarMaterialPorActividad.VMostrarMaterialPorActividad;
import Presentacion.Material.VMostrarTodosMateriales.VMostrarTodosMateriales;
=======
import Presentacion.Material.VBajaMaterial.VBajaMaterial;
>>>>>>> Stashed changes

public interface FactoriaVistaMaterial {
	public VistaMaterialGeneral getVista_VistaMaterialGeneral() ;

<<<<<<< Updated upstream
	public VAltaMaterial getVista_AltaMaterial();

	public VBajaMaterial getVista_BajaMaterial();

	public VModificarMaterial getVista_ModificarMaterial();

	public VMostrarMaterial getVista_MostrarMaterial();

	public VMostrarTodosMateriales getVista_MostrarTodosMateriales();

	public VMostrarMaterialPorActividad getVista_MostrarMaterialPorActividad();
	
=======
	public VBajaMaterial getVista_BajaMaterial();
>>>>>>> Stashed changes
}
