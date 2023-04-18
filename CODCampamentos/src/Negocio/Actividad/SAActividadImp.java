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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad borrarActividad(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad mostrarActividad(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostrarActividades() {
		// TODO Auto-generated method stub
		return null;
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