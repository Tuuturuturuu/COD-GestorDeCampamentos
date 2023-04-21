
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
		if (!compr.nombreValido(tMaterial.getNombre()))
			tMaterial.setId(-2);
		else if (!compr.almacenValido(tMaterial.getNAlmacen()))
			tMaterial.setId(-10);
		else if (!compr.nExistenciasValido(tMaterial.getExistencias()))
			tMaterial.setId(-11);
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

	public TMaterial modificarMaterial(TMaterial tMaterial) {
		TMaterial tMaterialBBDD = new TMaterial();

		// existe el Material en bbdd
		tMaterialBBDD.setId(tMaterial.getIdActividad());
		tMaterialBBDD = daoMaterial.mostrarMaterial(tMaterialBBDD);

		// si no ha encontrado el Material a modificar no se le puede cambiar el
		// nombre
		if (tMaterialBBDD.getId() == -1)
			tMaterial.setId(-1);

		// no esta activo
		if (tMaterialBBDD.getActivo() == false)
			tMaterial.setId(-12);

		// se quiere cambiar el nombre
		if (tMaterial.getNombre() != null && tMaterial.getId() > 0) {
			if (!compr.nombreValido(tMaterial.getNombre()))
				tMaterial.setId(-2);
		} else if (tMaterial.getId() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tMaterial.setNombre(tMaterialBBDD.getNombre());
		}

		// se quiere cambiar el numero del almacen
		if (tMaterial.getNAlmacen() != null && tMaterial.getId() > 0) {
			if (!compr.almacenValido(tMaterial.getNAlmacen()))
				tMaterial.setId(-10);
		} else if (tMaterial.getId() > 0)
			tMaterial.setNAlmacen(tMaterialBBDD.getNAlmacen());
		
		// se quiere cambiar el numero de existencias
				if (tMaterial.getExistencias() != null && tMaterial.getId() > 0) {
					if (!compr.nExistenciasValido(tMaterial.getExistencias()))
						tMaterial.setId(-11);
				} else if (tMaterial.getId() > 0)
					tMaterial.setExistencias(tMaterialBBDD.getExistencias());
		
		// se quiere cambiar idActividad Y DEBERIAMOS COMPROBAR QUE ID DE EMPLEADO EXISTA EN LA BASE DE DATOS
		if (tMaterial.getIdActividad() != null && tMaterial.getId() > 0 ) {
			if (!compr.numPlazas(tMaterial.getIdActividad()))
				tMaterial.setId(-1);
		} else if (tMaterial.getId() > 0)
					tMaterial.setIdActividad(tMaterialBBDD.getIdActividad());

		// si no ha habido ningun codigo de error puede modificarse.
		if (tMaterial.getId() > 0) {

			tMaterial = daoMaterial.modificarMaterial(tMaterial);
		}
		return tMaterial;
	}

	public TMaterial eliminarMaterial(TMaterial tMaterial) {
		tMaterial = daoMaterial.mostrarMaterial(tMaterial);
		// si no ha encontrado el Material el id sera -1
		if (tMaterial.getId() != -1)
			if (tMaterial.getActivo() == true)
				tMaterial = daoMaterial.eliminarMaterial(tMaterial);
			else
				tMaterial.setId(-5); // ya estaba desactivada
		return tMaterial;
	}

	public TMaterial mostrarMaterial(TMaterial tMaterial) {
		return tMaterial = daoMaterial.mostrarMaterial(tMaterial);
	}

	public Set<TMaterial> mostrarTodosMateriales() {
		return daoMaterial.mostrarTodosMateriales();
	}
	//TODO ESTO?
	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}