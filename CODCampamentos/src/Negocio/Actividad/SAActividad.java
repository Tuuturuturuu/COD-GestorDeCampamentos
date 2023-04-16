package Negocio.Actividad;

import java.util.Set;

 public interface SAActividad {
	
	public TActividad crearActividad(TActividad tActividad);

	public TActividad modificarActividad(TActividad tActividad);

	public TActividad borrarActividad(TActividad tActividad);

	public TActividad mostrarActividad(TActividad tActividad);

	public Set<TActividad> mostrarActividades();
	
	public Set<TActividad> mostrarActividadesporPersonal(TActividadMaterial tActividadMaterial);

	public TActividad vincularActividadMaterial(TActividadMaterial tActividadMaterial);

	public TActividad desvincularActividadMaterial(TActividadMaterial tActividadMaterial);
	
	public Set<TActividad> mostarActividadporMaterial(TActividad tActividad);
}