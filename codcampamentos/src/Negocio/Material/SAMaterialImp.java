/**
 * 
 */
package Negocio.Material;

import java.util.Set;


import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Material.DAOMaterial;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;


public class SAMaterialImp implements SAMaterial {
	
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
	
	public TMaterial crearMaterial(TMaterial tMaterial) {
		TMaterial materialBBDD = new TMaterial();
		
		//TODO GETTERS SEGUN LOS ATRIBUTOS DE MATERIAL
		//QUE ES COMPR?
		if (!compr.nombreValido(tMaterial.getNombre()))//nombre
			tMaterial.setId(-2);
		
		else if (!compr.numPlazas(tMaterial.getExistencias()))//existencias
			tMaterial.setId(-3);
		
		else if (!compr.numPlazas(tMaterial.getNAlmacen()))//nAlmacen
			tMaterial.setId(-7);
		
		else {
			materialBBDD.setId(tMaterial.getId());
			materialBBDD = daoMaterial.buscarMaterialID(materialBBDD);
			if (materialBBDD.getId() != -1) // encontrado en bbdd
				if (tMaterial.getId() == (materialBBDD.getId())
						&& materialBBDD.getActivo() == true)
					tMaterial.setId(-4); // ya esta activo
		}
		if (tMaterial.getId() == 0)
			tMaterial = daoMaterial.crearMaterial(tMaterial);
		return tMaterial;
	}


	public Integer modificarMaterial(TMaterial tMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer eliminarMaterial(Integer idMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TMaterial mostrarMaterial(Integer idMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TMaterial> mostrarTodosMateriales() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}