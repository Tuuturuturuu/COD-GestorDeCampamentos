package Integracion.Material;

import Negocio.Material.TMaterial;
import java.util.Set;

public interface DAOMaterial {

	public TMaterial crearMaterial(TMaterial tMaterial);
	
	public TMaterial eliminarMaterial(TMaterial tMaterial);
	
	public TMaterial modificarMaterial(TMaterial tMaterial);
	
	public TMaterial mostrarMaterial(TMaterial tMaterial);
	
	public Set<TMaterial> mostrarTodosMateriales();
	
	//ANIADIDOS PARA NEGOCIO
	public TMaterial buscarMaterialID(TMaterial tMaterial);
	public TMaterial buscarMaterialNombre(TMaterial tMaterial);

	public Set<TMaterial> listarMaterialPorActividad(int idActividad);
	
	public Integer activar(Integer IdMaterial);
	
}