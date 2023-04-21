
package Negocio.Material;

import java.util.Set;

public interface SAMaterial {

	public TMaterial crearMaterial(TMaterial tMaterial);

	public TMaterial modificarMaterial(TMaterial tMaterial);

	public TMaterial eliminarMaterial(TMaterial tMaterial);

	public TMaterial mostrarMaterial(TMaterial tMaterial);

	public Set<TMaterial> mostrarTodosMateriales();

	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad);
}