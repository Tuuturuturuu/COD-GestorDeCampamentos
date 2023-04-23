package Negocio.Actividad;

import java.util.Set;

 public interface SAActividad {
	
	public TActividad crearActividad (TActividad tActividad);

	public TActividad modificarActividad(TActividad tActividad);

	public TActividad borrarActividad(TActividad tActividad);

	public TActividad mostrarActividad(TActividad tActividad);

	public Set<TActividad> mostrarActividades();
	
	public Set<TActividad> mostrarActividadesporPersonal(Integer IdPersonal );
	
	public Set<TActividad> mostarActividadporMaterial(Integer IdMaterial);
}