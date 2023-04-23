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
		// begin-user-code
		// TODO Auto-generated method stub
		return idActividad;
		// end-user-code
	}

	public Integer getIdMaterial() {
		// begin-user-code
		// TODO Auto-generated method stub
		return idMaterial;
		// end-user-code
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}
}