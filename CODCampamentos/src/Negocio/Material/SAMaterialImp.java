
package Negocio.Material;

import java.util.HashSet;
import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.Actividad.DAOActividadMaterial;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Material.DAOMaterial;
import Negocio.Actividad.TActividad;
import Negocio.Actividad.TActividadMaterial;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;

public class SAMaterialImp implements SAMaterial {
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	private DAOActividadMaterial daoActividadMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividadMaterial();

	
	
	public TMaterial crearMaterial(TMaterial tMaterial) {
		TMaterial materialBBDD = new TMaterial();
//		TActividad tActividad = new TActividad();
//		TActividadMaterial tActividadMaterial = new TActividadMaterial();
		
//		tActividad.setIdActividad(tMaterial.getIdActividad());
		
		if (!compr.nombreValido(tMaterial.getNombre()))
			tMaterial.setId(-2);
		else if (!compr.almacenValido(tMaterial.getNAlmacen()))
			tMaterial.setId(-10);
		else if (!compr.nExistenciasValido(tMaterial.getExistencias()))
			tMaterial.setId(-11);
//		else if (!compr.idValido(tMaterial.getIdActividad()))
//			tMaterial.setId(-14);
//		else if (daoActividad.mostrarActividad(tActividad).getIdActividad() == -1) //Comprobar que el id de Actividad existe
//			tMaterial.setId(-23);
			
		else {
			//materialBBDD.setId(tMaterial.getId());
			materialBBDD = daoMaterial.buscarMaterialNombre(tMaterial);

			if (materialBBDD.getId() != -1) // encontrado en bbdd
				if (materialBBDD.getActivo() == true)
					tMaterial.setId(-26); // ya esta activo
		}
		if (tMaterial.getId() == 0){
			tMaterial = daoMaterial.crearMaterial(tMaterial);
			
//			tActividadMaterial.setIdActividad(tActividad.getIdActividad());
//			tActividadMaterial.setIdMaterial(tMaterial.getId());
//			
//			int correct = daoActividadMaterial.vincular(tActividadMaterial);
//			
//			if (correct == 0)
//				tMaterial.setId(-24);
		}
		
		
		return tMaterial;
	}

	public TMaterial modificarMaterial(TMaterial tMaterial) {
		TMaterial tMaterialBBDD = new TMaterial();
		TActividad tActividad = new TActividad();
		tActividad.setIdActividad(tMaterial.getIdActividad());
		TMaterial materialBBDD = new TMaterial();

		// existe el Material en bbdd
		tMaterialBBDD.setId(tMaterial.getId());
		tMaterialBBDD = daoMaterial.mostrarMaterial(tMaterialBBDD);

		// si no ha encontrado el Material a modificar no se le puede cambiar el
		// nombre
		if (tMaterialBBDD.getId() == -1)
			tMaterial.setId(-1);

		// no esta activo
		else{
			// no esta activo
			if (tMaterialBBDD.getActivo() == false)
				tMaterial.setId(-5);
		}

		// se quiere cambiar el nombre
		if (tMaterial.getNombre().equals("") && tMaterial.getId() > 0) {
			tMaterial.setNombre(tMaterialBBDD.getNombre());
		} else if (tMaterial.getId() > 0) {
			if (!compr.nombreValido(tMaterial.getNombre()))
				tMaterial.setId(-2);
			else {
				materialBBDD = daoMaterial.buscarMaterialNombre(tMaterial);
				if (materialBBDD.getId() != -1) 
						tMaterial.setId(-26);
			}
		}
		

		// se quiere cambiar el numero del almacen
		if (tMaterial.getNAlmacen() != 0 && tMaterial.getId() > 0) {
			
			if (!compr.almacenValido(tMaterial.getNAlmacen()))
				tMaterial.setId(-10);	
		} else if (tMaterial.getId() > 0){
			tMaterial.setNAlmacen(tMaterialBBDD.getNAlmacen());
		}
		
		// se quiere cambiar el numero de existencias
		
		if (tMaterial.getExistencias() != 0 && tMaterial.getId() > 0) {
			if (!compr.nExistenciasValido(tMaterial.getExistencias()))
				tMaterial.setId(-11);
		} else if (tMaterial.getId() > 0){
			tMaterial.setExistencias(tMaterialBBDD.getExistencias());
			
		}
					
		
		// se quiere cambiar idActividad Y DEBERIAMOS COMPROBAR QUE ID DE actividad EXISTA EN LA BASE DE DATOS
		if (tMaterial.getIdActividad() != 0 && tMaterial.getId() > 0 ) {
			if (daoActividad.mostrarActividad(tActividad).getIdActividad() == -1) //Comprobar que el id de Personal existe
				tMaterial.setId(-9);
		} else if (tMaterial.getId() > 0){
			tMaterial.setIdActividad(tMaterialBBDD.getIdActividad());
		}
					

		// si no ha habido ningun codigo de error puede modificarse.
		if (tMaterial.getId() > 0) {

			tMaterial = daoMaterial.modificarMaterial(tMaterial);
		}
		return tMaterial;
	}

	public TMaterial eliminarMaterial(TMaterial tMaterial) {
		tMaterial = daoMaterial.mostrarMaterial(tMaterial);
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();
		Integer correct;
		int i = 0;
		// si no ha encontrado el Material el id sera -1
		if (tMaterial.getId() != -1)
			if (tMaterial.getActivo() == true){
				
				//Conseguimos todos los elementos ActividadMaterial que tengan el idMaterial en com�n
				ActividadesMaterial = daoActividadMaterial.BuscarporActividad(tMaterial.getId());
				//Recorremos todos esos elementos y los vamos desvinculando
				for (TActividadMaterial actividadMaterial : ActividadesMaterial) {
				    //Desvinculamos pasando el id del Material y de la Actividad para asegurarnos que es correcto
				    correct = daoActividadMaterial.desvincular(actividadMaterial.getIdActividad(), actividadMaterial.getIdMaterial());
				    if(correct == 1) i++;
				}
				if(ActividadesMaterial.size() == i) //Si hemos desvinculado todos los elementos correctamente, entonces damos de baja a dicha actividad, caso contrario enviamos un error
					tMaterial = daoMaterial.eliminarMaterial(tMaterial);
				else
					tMaterial.setId(-22);
			}
			else
				tMaterial.setId(-5); // ya estaba desactivada
		return tMaterial;
	}

	public TMaterial mostrarMaterial(TMaterial tMaterial) {
		if(daoMaterial.mostrarMaterial(tMaterial).getActivo() == false)
			tMaterial.setId(-5);
		return tMaterial;
	}

	public Set<TMaterial> mostrarTodosMateriales() {
		return daoMaterial.mostrarTodosMateriales();
	}
	@Override
	public Set<TMaterial> listarMaterialPorActividad(int  idActividad) {
		Set<TMaterial> Materiales = new HashSet<TMaterial>();
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();

		//Comprobar que el material existe
		TActividad tActividadBuscada = new TActividad(idActividad,null,null,null,null, null, false);
		tActividadBuscada = daoActividad.buscarActividadID(tActividadBuscada);
		if(tActividadBuscada.getIdActividad() <= 0){
			TMaterial tMaterial = new TMaterial();
			tMaterial.setId(-1);
			Materiales.add(tMaterial);	
		}else{
			//Comprobar que el material esta activo
			if(tActividadBuscada.getActivo() == false){
				TMaterial tMaterial = new TMaterial();
				tMaterial.setId(-25);
				Materiales.add(tMaterial);
			}else{
				//Buscar en DAOActividadMaterial
				ActividadesMaterial = daoActividadMaterial.BuscarporActividad(idActividad);
				for (TActividadMaterial actividadMaterial : ActividadesMaterial) {
				    int idMaterial = actividadMaterial.getIdMaterial();
				    // Buscar cada actividad
					TMaterial tMaterial = new TMaterial();
				    tMaterial.setId(idMaterial);
				    TMaterial tMaterialAux = daoMaterial.mostrarMaterial(tMaterial);
				    Materiales.add(tMaterialAux);	
				}
			}			
		}
		return Materiales;
		
	}

	@Override
	public TMaterial vincularMaterialActividad(TMaterial tMaterial) {

		TMaterial materialBBDD = new TMaterial();
		TActividad tActividad = new TActividad();
		TActividadMaterial tActividadMaterial = new TActividadMaterial();
		
		tActividad.setIdActividad(tMaterial.getIdActividad());
		// TODO comprobar id valido??
		if (!compr.idValido(tMaterial.getId()))
			tMaterial.setId(-14);
		else if (!compr.idValido(tMaterial.getIdActividad()))
			tMaterial.setId(-14);
		else if (daoActividad.mostrarActividad(tActividad).getIdActividad() == -1)
			//Comprobar que el id de actividad existe
			tMaterial.setId(-23);
		//Comprobar que la actividad esta dada de alta
		else if (daoActividad.mostrarActividad(tActividad).getActivo() == false)
			tMaterial.setId(-25);
		else {
			materialBBDD = daoMaterial.buscarMaterialID(tMaterial);
			//Comprobar que el material existe
			if (materialBBDD.getId() != -1){
				//Comprobar que el material no esta dado de baja
				if (materialBBDD.getActivo() == false)
					tMaterial.setId(-12);
				else{
					tActividadMaterial.setIdActividad(tActividad.getIdActividad());
					tActividadMaterial.setIdMaterial(tMaterial.getId());
					int correct = daoActividadMaterial.vincular(tActividadMaterial);
					
					if (correct == 0)
						tMaterial.setId(-24);
				}
			}else
				tMaterial.setId(-27);				
		}

		
		
		return tMaterial;
	}

	
}