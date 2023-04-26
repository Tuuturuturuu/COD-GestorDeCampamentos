package Negocio.Actividad;

import java.util.HashSet;
import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.Actividad.DAOActividadMaterial;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Material.DAOMaterial;
import Integracion.Personal.DAOPersonal;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;
import Negocio.Material.TMaterial;
import Negocio.Personal.TPersonal;


public class SAActividadImp implements SAActividad{
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	private DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
	private DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
	private DAOActividadMaterial daoActividadMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividadMaterial();
	@Override
	public TActividad crearActividad(TActividad tActividad) {
		TActividad actividadBBDD = new TActividad();
<<<<<<< Updated upstream
		if (tActividad.getLugar().isEmpty() || tActividad.getNombre().isEmpty() || tActividad.getNumplazas() == 0 || tActividad.getIdPersonal() == 0)
			tActividad.setIdActividad(-37);
		else if (!compr.nombreValido(tActividad.getNombre()))
			tActividad.setIdActividad(-2);
		else if (!compr.nombreValido(tActividad.getLugar()))
			tActividad.setIdActividad(-3);
		else if (!compr.numPlazas(tActividad.getNumplazas()))
			tActividad.setIdActividad(-7);
		else if (!compr.precio(tActividad.getPrecio()))
			tActividad.setIdActividad(-8);
		else if (daoPersonal.MostrarUno(tActividad.getIdPersonal()).getIdPersonal() == -1 ) //Comprobar que el id de Personal existe
			tActividad.setIdActividad(-9);
		else {
			actividadBBDD = daoActividad.buscarActividadNombreLugar(tActividad);
			if (actividadBBDD.getIdActividad() != -1) {// encontrado en bbdd
				if (actividadBBDD.getActivo() == true)
					tActividad.setIdActividad(-4); // ERROR: ya esta activo
				else
					tActividad.setIdActividad(daoActividad.activar(actividadBBDD.getIdActividad()));
			}else{
				tActividad = daoActividad.crearActividad(tActividad);	
=======
		if(tActividad.getIdActividad() >= 0){
			if (tActividad.getLugar().isEmpty() || tActividad.getNombre().isEmpty() || tActividad.getNumplazas() == 0 || tActividad.getIdPersonal() == 0)
				tActividad.setIdActividad(-37);
			else if (!compr.nombreValido(tActividad.getNombre()))
				tActividad.setIdActividad(-2);
			else if (!compr.checkString(tActividad.getNombre()))
				tActividad.setIdActividad(-38);
			else if (!compr.nombreValido(tActividad.getLugar()))
				tActividad.setIdActividad(-3);
			else if (!compr.checkString(tActividad.getLugar()))
				tActividad.setIdActividad(-38);
			else if (!compr.numPlazas(tActividad.getNumplazas()))
				tActividad.setIdActividad(-7);
			else if (!compr.precio(tActividad.getPrecio()))
				tActividad.setIdActividad(-8);
			else if (daoPersonal.MostrarUno(tActividad.getIdPersonal()).getIdPersonal() == -1 ) //Comprobar que el id de Personal existe
				tActividad.setIdActividad(-9);
			else {
				actividadBBDD = daoActividad.buscarActividadNombreLugar(tActividad);
				if (actividadBBDD.getIdActividad() != -1) {// encontrado en bbdd
					if (actividadBBDD.getActivo() == true)
						tActividad.setIdActividad(-4); // ERROR: ya esta activo
					else
						tActividad.setIdActividad(-6);
				}else{
					tActividad = daoActividad.crearActividad(tActividad);	
				}
>>>>>>> Stashed changes
			}
		}
		return tActividad;
	}

	@Override
	public TActividad modificarActividad(TActividad tActividad) {
		TActividad tActividadBBDD = new TActividad();
		//Buscar que existe la actividad con dicho id en la BBDD
		if(tActividad.getIdActividad() >= 0){
			tActividadBBDD = daoActividad.buscarActividadID(tActividad);
	
			// si no ha encontrado la Actividad a modificar no se le puede cambiar el
			// nombre
			if (tActividadBBDD.getIdActividad() == -1)
				tActividad.setIdActividad(-1);
			else{
				// no esta activo
				if (tActividadBBDD.getActivo() == false)
					tActividad.setIdActividad(-5);
			}
			// se quiere cambiar el nombre
			if (tActividad.getNombre().equals("") && tActividad.getIdActividad() > 0) {
				// los campos modificables que vengan en nulo los rellenamos con los
				// valores de bbdd
				tActividad.setNombre(tActividadBBDD.getNombre());
			} else if (tActividad.getIdActividad() > 0) {
				if (!compr.nombreValido(tActividad.getNombre()))
					tActividad.setIdActividad(-2);
				else if (!compr.checkString(tActividad.getNombre()))
					tActividad.setIdActividad(-38);
			}
	
			// se quiere cambiar lugar
			if (tActividad.getLugar().equals("") && tActividad.getIdActividad() > 0) {
				tActividad.setLugar(tActividadBBDD.getLugar());
			} else if (tActividad.getIdActividad() > 0)
				if (!compr.nombreValido(tActividad.getLugar()))
					tActividad.setIdActividad(-3);	
				else if (!compr.checkString(tActividad.getLugar()))
					tActividad.setIdActividad(-38);
			
			// se quiere cambiar numPlazas
			if (tActividad.getNumplazas() != 0 && tActividad.getIdActividad() > 0) {
				if (!compr.numPlazas(tActividad.getNumplazas()))
					tActividad.setIdActividad(-7);
			} else if (tActividad.getIdActividad() > 0)
				tActividad.setNumplazas(tActividadBBDD.getNumplazas());
					
			// se quiere cambiar precio
			if (tActividad.getPrecio() != 0 && tActividad.getIdActividad() > 0) {
				if (!compr.precio(tActividad.getPrecio()))
					tActividad.setIdActividad(-7);
			} else if (tActividad.getIdActividad() > 0)
				tActividad.setPrecio(tActividadBBDD.getPrecio());
			
			// se quiere cambiar idPersonal Y DEBERIAMOS COMPROBAR QUE ID DE EMPLEADO EXISTA EN LA BASE DE DATOS
			if (tActividad.getIdPersonal() != 0 && tActividad.getIdActividad() > 0 ) {
				if (daoPersonal.MostrarUno(tActividad.getIdPersonal()).getIdPersonal() == -1) //Comprobar que el id de Personal existe
					tActividad.setIdActividad(-9);
			} else if (tActividad.getIdActividad() > 0)
						tActividad.setIdPersonal(tActividadBBDD.getIdPersonal());
	
			// si no ha habido ningun codigo de error puede modificarse.
			if (tActividad.getIdActividad() > 0) {
				tActividad = daoActividad.modificarActividad(tActividad);
			}
		}
		return tActividad;
	}

	@Override
	public TActividad borrarActividad(TActividad tActividad) {
		TActividad tActividadbbdd = new TActividad();
		tActividadbbdd = daoActividad.buscarActividadID(tActividad);
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();
		int i = 0;
		Integer correct;
		// si no ha encontrado la Actividad el id sera -1
		if (tActividadbbdd.getIdActividad() != -1){
			if (tActividadbbdd.getActivo() == true){
				//Conseguimos todos los elementos ActividadMaterial que tengan el idActividad en com�n
				ActividadesMaterial = daoActividadMaterial.BuscarporActividad(tActividad.getIdActividad());
				//Recorremos todos esos elementos y los vamos desvinculando
				for (TActividadMaterial actividadMaterial : ActividadesMaterial) {
				    //Desvinculamos pasando el id del Material y de la Actividad para asegurarnos que es correcto
				    correct = daoActividadMaterial.desvincular(actividadMaterial.getIdActividad(), actividadMaterial.getIdMaterial());
				    if(correct == 1) i++;
				}
				if(ActividadesMaterial.size() == i) //Si hemos desvinculado todos los elementos correctamente, entonces damos de baja a dicha actividad, caso contrario enviamos un error
					tActividad = daoActividad.borrarActividad(tActividad);
				else
					tActividad.setIdActividad(-22);
			}
			else
				tActividad.setIdActividad(-5); // ya estaba desactivada
		}
		else
			tActividad.setIdActividad(-1); //No se encuentra el id en BD
		return tActividad;
	}

	@Override
	public TActividad mostrarActividad(TActividad tActividad) {	
		if(daoActividad.mostrarActividad(tActividad).getActivo() == false)
			tActividad.setIdActividad(-5);
		return tActividad;
	}

	@Override
	public Set<TActividad> mostrarActividades() {
		return daoActividad.mostrarActividades();
	}

	@Override
	public Set<TActividad> mostrarActividadesporPersonal(Integer IdPersonal) {
		
		Set<TActividad> Actividades = new HashSet<TActividad>();
		
		//Comprobar que el Personal existe
		TPersonal tPersonalBuscado = daoPersonal.MostrarUno(IdPersonal);
		TActividad tActividad = new TActividad();
		if(tPersonalBuscado.getIdPersonal() <= 0){
			tActividad.setIdActividad(-1);
			Actividades.add(tActividad);	
		}else{
			//Comprobar que el personal esta activo
			if(tPersonalBuscado.getIsActivo() == false){
				tActividad.setIdActividad(-5);
				Actividades.add(tActividad);
			}
			else{
				//Buscar las actividades de dicho personal
				Actividades = daoActividad.mostrarActividadesporPersonal(IdPersonal);
			}
		}
	
		// TODO Auto-generated method stub
		return Actividades;
	}

	@Override
	public Set<TActividad> mostarActividadporMaterial(Integer IdMaterial) {

		Set<TActividad> Actividades = new HashSet<TActividad>();
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();

		//Comprobar que el material existe
		TMaterial tMaterialBuscado = new TMaterial(IdMaterial,null,0,0,0,false);
		tMaterialBuscado = daoMaterial.buscarMaterialID(tMaterialBuscado);
		if(tMaterialBuscado.getId() <= 0){
			TActividad tActividad = new TActividad();
			tActividad.setIdActividad(-1);
			Actividades.add(tActividad);	
		}else{
			//Comprobar que el material esta activo
			if(tMaterialBuscado.getActivo() == false){
				TActividad tActividad = new TActividad();
				tActividad.setIdActividad(-12);
				Actividades.add(tActividad);
			}else{
				//Buscar en DAOActividadMaterial
				ActividadesMaterial = daoActividadMaterial.BuscarporMaterial(IdMaterial);
				for (TActividadMaterial actividadMaterial : ActividadesMaterial) {
				    int idActividad = actividadMaterial.getIdActividad();
				    // Buscar cada actividad
					TActividad tActividad = new TActividad();
				    tActividad.setIdActividad(idActividad);
				    TActividad tActividadAux = daoActividad.mostrarActividad(tActividad);
					Actividades.add(tActividadAux);	
				}
			}			
		}

		
		return Actividades;
	}

}