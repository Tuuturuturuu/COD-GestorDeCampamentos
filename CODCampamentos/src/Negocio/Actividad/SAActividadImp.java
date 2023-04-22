package Negocio.Actividad;

import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;


public class SAActividadImp implements SAActividad{
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	private DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
	

	@Override
	public TActividad crearActividad(TActividad tActividad) {
		TActividad actividadBBDD = new TActividad();
		if (!compr.nombreValido(tActividad.getNombre()))
			tActividad.setIdActividad(-2);
		else if (!compr.nombreValido(tActividad.getLugar()))
			tActividad.setIdActividad(-3);
		else if (!compr.numPlazas(tActividad.getNumplazas()))
			tActividad.setIdActividad(-7);
		else if (!compr.precio(tActividad.getPrecio()))
			tActividad.setIdActividad(-8);
		else if (daoPersonal.MostrarUno(tActividad.getIdPersonal()).getIdPersonal() == -1) //Comprobar que el id de Personal existe
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
		}
		return tActividad;
	}

	@Override
	public TActividad modificarActividad(TActividad tActividad) {
		TActividad tActividadBBDD = new TActividad();
		TActividad tActividadAux = tActividad;
		//Buscar que existe la actividad con dicho id en la BBDD
		tActividadBBDD = daoActividad.buscarActividadID(tActividad);

		// si no ha encontrado la Actividad a modificar no se le puede cambiar el
		// nombre
		if (tActividadBBDD.getIdActividad() == -1)
			tActividad.setIdActividad(-1);

		// no esta activo
		if (tActividadBBDD.getActivo() == false)
			tActividad.setIdActividad(-5);

		// se quiere cambiar el nombre
		if (tActividad.getNombre().equals("") && tActividad.getIdActividad() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tActividad.setNombre(tActividadBBDD.getNombre());
		} else if (tActividad.getIdActividad() > 0) {
			if (!compr.nombreValido(tActividad.getNombre()))
				tActividad.setIdActividad(-2);
		}

		// se quiere cambiar lugar
		if (tActividad.getLugar().equals("") && tActividad.getIdActividad() > 0) {
			tActividad.setLugar(tActividadBBDD.getLugar());
		} else if (tActividad.getIdActividad() > 0)
			if (!compr.nombreValido(tActividad.getLugar()))
				tActividad.setIdActividad(-3);			
		
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
		return tActividad;
	}

	@Override
	public TActividad borrarActividad(TActividad tActividad) {
		TActividad tActividadbbdd = new TActividad();
		tActividadbbdd = daoActividad.buscarActividadID(tActividad);
		// si no ha encontrado la Cliente el id sera -1
		if (tActividadbbdd.getIdActividad() != -1){
			if (tActividad.getActivo() == true)
				tActividad = daoActividad.borrarActividad(tActividad);
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
	public Set<TActividad> mostrarActividadesporPersonal(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostarActividadporMaterial(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}
	


}