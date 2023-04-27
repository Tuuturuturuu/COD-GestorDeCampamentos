package Negocio.Actividad;

public class TActividad {

	private Integer idActividad;
	private String nombre;
	private String lugar;
	private Integer numplazas;
	private Float precio;
	private Integer idPersonal;
	private Boolean activo;

	public TActividad(Integer idActividad, String nombre, String lugar, Integer numplazas, Float precio,
			Integer idPersonal, Boolean activo) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.numplazas = numplazas;
		this.lugar = lugar;
		this.precio = precio;
		this.idPersonal = idPersonal;
		this.activo = activo;

	}

	public TActividad() {

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

	@Override
	public String toString() {
		return "idActividad =" + idActividad + " , nombre = " + nombre + " , lugar = " + lugar + " , numplazas = "
				+ numplazas + " , precio = " + precio + " , idPersonal = " + idPersonal + " , activo = " + activo + "]";
	}

	public String toStringModificar() {
		String sol = null;
		sol = "ID: " + this.getIdActividad() + "   ";
		sol += "Nombre: " + this.getNombre() + "    ";
		sol += "Lugar: " + this.getLugar() + "    ";
		sol += "NumPlazas:  " + this.getNumplazas() + "   ";
		sol += "Precio:  " + this.getPrecio() + "   ";
		sol += "IdPersonal: " + this.getIdPersonal();
		return sol;
	}

}