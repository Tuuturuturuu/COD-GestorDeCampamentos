package Negocio.Actividad;

import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;


public class SAActividadImp implements SAActividad{
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	

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
		else {
			actividadBBDD.setIdActividad(tActividad.getIdActividad());
			actividadBBDD = daoActividad.buscarActividadID(actividadBBDD);
			if (actividadBBDD.getIdActividad() != -1) // encontrado en bbdd
				if (tActividad.getIdActividad() == (actividadBBDD.getIdActividad())
						&& actividadBBDD.getActivo() == true)
					tActividad.setIdActividad(-4); // ya esta activo
		}
		if (tActividad.getIdActividad() == 0)
			tActividad = daoActividad.crearActividad(tActividad);
		return tActividad;
	}

	@Override
	public TActividad modificarActividad(TActividad tActividad) {
		TActividad tActividadBBDD = new TActividad();

		// existe la Actividad en bbdd
		tActividadBBDD.setIdActividad(tActividad.getIdActividad());
		tActividadBBDD = daoActividad.mostrarActividad(tActividadBBDD);

		// si no ha encontrado la Actividad a modificar no se le puede cambiar el
		// nombre
		if (tActividadBBDD.getIdActividad() == -1)
			tActividad.setIdActividad(-1);

		// no esta activo
		if (tActividadBBDD.getActivo() == false)
			tActividad.setIdActividad(-8);

		// se quiere cambiar el nombre
		if (tActividad.getNombre() != null && tActividad.getIdActividad() > 0) {
			if (!compr.nombreValido(tActividad.getNombre()))
				tActividad.setIdActividad(-2);
		} else if (tActividad.getIdActividad() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tActividad.setNombre(tActividadBBDD.getNombre());
		}

		// se quiere cambiar lugar
		if (tActividad.getLugar() != null && tActividad.getIdActividad() > 0) {
			if (!compr.nombreValido(tActividad.getLugar()))
				tActividad.setIdActividad(-7);
		} else if (tActividad.getIdActividad() > 0)
			tActividad.setLugar(tActividadBBDD.getLugar());
		
		// se quiere cambiar numPlazas
				if (tActividad.getNumplazas() != null && tActividad.getIdActividad() > 0) {
					if (!compr.numPlazas(tActividad.getNumplazas()))
						tActividad.setIdActividad(-7);
				} else if (tActividad.getIdActividad() > 0)
					tActividad.setNumplazas(tActividadBBDD.getNumplazas());
				
		// se quiere cambiar precio
		if (tActividad.getPrecio() != null && tActividad.getIdActividad() > 0) {
			if (!compr.precio(tActividad.getPrecio()))
				tActividad.setIdActividad(-7);
		} else if (tActividad.getIdActividad() > 0)
			tActividad.setPrecio(tActividadBBDD.getPrecio());
		
		// se quiere cambiar idPersonal Y DEBERIAMOS COMPROBAR QUE ID DE EMPLEADO EXISTA EN LA BASE DE DATOS
		if (tActividad.getIdPersonal() != null && tActividad.getIdActividad() > 0 ) {
			if (!compr.numPlazas(tActividad.getIdPersonal()))
				tActividad.setIdActividad(-7);
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
		tActividad = daoActividad.mostrarActividad(tActividad);
		// si no ha encontrado la Cliente el id sera -1
		if (tActividad.getIdActividad() != -1)
			if (tActividad.getActivo() == true)
				tActividad = daoActividad.borrarActividad(tActividad);
			else
				tActividad.setIdActividad(-5); // ya estaba desactivada
		return tActividad;
	}

	@Override
	public TActividad mostrarActividad(TActividad tActividad) {
		return tActividad = daoActividad.mostrarActividad(tActividad);
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
	public TActividad vincularActividadMaterial(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad desvincularActividadMaterial(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostarActividadporMaterial(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}
	


}