/**
 * 
 */
package Integracion.Actividad;

import java.util.Set;

import Negocio.Actividad.TActividadMaterial;

public interface DAOActividadMaterial {

	public Integer vincular(TActividadMaterial actividadMaterial);

	public Integer desvincular(Integer idActividad, Integer idMaterial);

	public Set<TActividadMaterial> BuscarporActividad(Integer idActividad);

	public Set<TActividadMaterial> BuscarporMaterial(Integer idMaterial);

	public TActividadMaterial BuscarActividadMaterial(Integer idActividad, Integer idMaterial);

	public Integer desvincularIDMaterial(Integer idMaterial);
}