
package Negocio.Material;

public class TMaterial {

	private String _nombre;
	private Integer _idMaterial;
	private Boolean _activo;
	private Integer _existencias;
	private Integer _nAlmacen;
	private Integer _idActividad;
	
	public TMaterial(Integer idMaterial, String nombre, Integer nAlmacen,  Integer existencias,
			Integer idActividad, Boolean activo){
		
		this._activo =activo;
		this._existencias =existencias;
		this._idActividad = idActividad;
		this._idMaterial =idMaterial;
		this._nombre =nombre;
		this._nAlmacen =nAlmacen;
	}
	
	public TMaterial(){
		
	}

	@Override
	public String toString() {
		return "Nombre: " + _nombre + ", ID Material: " + _idMaterial + ", Activo: " + _activo
				+ ", Existencias: " + _existencias + ", Almacen: " + _nAlmacen + ", ID Actividad: " + _idActividad;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String _nombre) {
		this._nombre = _nombre;
	}

	public Integer getId() {
		return _idMaterial;
	}

	public void setId(Integer _idMaterial) {
		this._idMaterial = _idMaterial;
	}

	public Boolean getActivo() {
		return _activo;
	}

	public void setActivo(Boolean _activo) {
		this._activo = _activo;
	}

	public Integer getExistencias() {
		return _existencias;
	}

	public void setExistencias(Integer _existencias) {
		this._existencias = _existencias;
	}

	public Integer getNAlmacen() {
		return _nAlmacen;
	}

	public void setNAlmacen(Integer _nAlmacen) {
		this._nAlmacen = _nAlmacen;
	}

	public Integer getIdActividad() {
		return _idActividad;
	}

	public void setIdActividad(Integer _idActividad) {
		this._idActividad = _idActividad;
	}
}