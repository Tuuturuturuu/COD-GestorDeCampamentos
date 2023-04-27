/**
 * 
 */
package Negocio.Actividad;

public class TActividadMaterial {

	public TActividadMaterial(Integer idActividad, Integer idMaterial) {
		this.idActividad = idActividad;
		this.idMaterial = idMaterial;
	}

	public TActividadMaterial() {
		// TODO Auto-generated constructor stub
	}

	private Integer idActividad;
	private Integer idMaterial;

	public Integer getIdActividad() {

		return idActividad;

	}

	public Integer getIdMaterial() {

		return idMaterial;

	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}
}