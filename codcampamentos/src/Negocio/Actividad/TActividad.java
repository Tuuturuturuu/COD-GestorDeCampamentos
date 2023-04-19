/**
 * 
 */
package Negocio.Actividad;


public class TActividad {

	private Integer idActividad;
	private String nombre;
	private Integer numplazas;
	private String lugar;
	private Float precio;
	private Integer idPersonal;
	private Boolean activo;
	
	public TActividad(int idActividad, String nombre, Integer numplazas, String lugar, Float precio,
			Integer idPersonal, Boolean activo ){
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.numplazas = numplazas;
		this.lugar = lugar;
		this.precio = precio;
		this.idPersonal = idPersonal;
		this.activo = activo;
		
	}
	
	public TActividad() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdActividad() {
		return idActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getNumplazas() {
		return numplazas;
	}
	public String getLugar() {
		return lugar;
	}
	public Float getPrecio() {
		return precio;
	}
	public Boolean getActivo() {
		return activo;
	}
	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumplazas(Integer numplazas) {
		this.numplazas = numplazas;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

	
}