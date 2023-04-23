/**
 * 
 */
package Integracion.Actividad;

import Negocio.Actividad.TActividadMaterial;
import java.util.Set;


public interface DAOActividadMaterial {

	public Integer vincular(TActividadMaterial actividadMaterial);
	public Integer desvincular(Integer idActividad, Integer idMaterial);
	public Set<TActividadMaterial> BuscarporActividad(Integer idActividad);
	public Set<TActividadMaterial> BuscarporMaterial(Integer idMaterial);
	public TActividadMaterial BuscarActividadMaterial(Integer idActividad, Integer idMaterial);
}