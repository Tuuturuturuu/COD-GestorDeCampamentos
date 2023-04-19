
package Integracion.Material;

import Negocio.Material.TMaterial;
import java.util.Set;


public interface DAOMaterial {
	
	public TMaterial crearMaterial(TMaterial tMaterial);

	public Integer eliminarMaterial(Integer id);

	public Integer modificarMaterial(TMaterial tMaterial);

	public TMaterial mostrarMaterial(Integer idMaterial);

	public Set<TMaterial> mostrarTodosMateriales();

	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad);
	
	public TMaterial buscarMaterialID(TMaterial tMaterial);

}