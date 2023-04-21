
package Negocio.Material;

import java.util.Set;

public interface SAMaterial {
	
	public TMaterial crearMaterial(TMaterial tMaterial);
	
	public Integer modificarMaterial(TMaterial tMaterial);

	public Integer eliminarMaterial(Integer idMaterial);

	public TMaterial mostrarMaterial(Integer idMaterial);

	public Set<TMaterial> mostrarTodosMateriales();

	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad);
}