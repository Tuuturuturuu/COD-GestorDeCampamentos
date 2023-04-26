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

	public Set<TActividad> mostrarActividadesporPersonal(Integer IdPersonal);
	
	public Set<TActividad> mostrarActividadesActivasporPersonal(Integer IdPersonal);

	public TActividad buscarActividadID(TActividad tActividad);
	
	public TActividad buscarActividadNombreLugar(TActividad tActividad);
	
	public Integer activar(Integer IdActividad);

}