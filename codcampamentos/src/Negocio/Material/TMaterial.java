
package Negocio.Material;

public class TMaterial {

	private String _nombre;
	private Integer _idMaterial;
	private Boolean _activo;
	private Integer _existencias;
	private Integer _nAlmacen;
	private Integer _idActividad;

	public TMaterial(int id, String nombre, int existencias, int nAlmacen, int idActividad, boolean activo) {
		_nombre=nombre;
		_idMaterial=id;
		_activo=activo;
		_existencias=existencias;
		_nAlmacen=nAlmacen;
		_idActividad=idActividad;
	}

	public TMaterial() {
		// TODO Auto-generated constructor stub
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