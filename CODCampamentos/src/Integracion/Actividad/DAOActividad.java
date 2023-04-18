package Integracion.Actividad;

import Negocio.Actividad.TActividad;
import Negocio.Actividad.TActividadMaterial;

import java.util.Set;

public interface DAOActividad {
	
	public TActividad crearActividad(TActividad tActividad);

	public TActividad modificarActividad(TActividad tActividad);

	public TActividad borrarActividad(TActividad tActividad);

	public TActividad mostrarActividad(TActividad tActividad);

	public Set<TActividad> mostrarActividades();

	public Set<TActividad> mostrarActividadesporPersonal(TActividadMaterial tActividadMaterial);

	public TActividad activar(TActividad tActividad);
	
	public TActividad vincularActividadMaterial(TActividadMaterial tActividadMaterial);

	public TActividad desvincularActividadMaterial(TActividadMaterial tActividadMaterial);

	public Set<TActividad> mostrarActividadporMaterial(TActividad tActividad);

	public TActividad buscarActividadID(TActividad tActividad);
}