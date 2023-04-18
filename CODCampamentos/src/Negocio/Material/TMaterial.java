
package Negocio.Material;

public class TMaterial {

	private String _nombre;
	private Integer _idMaterial;
	private Boolean _Activo;
	private Integer _existencias;
	private Integer _nAlmacen;

	public Integer getId() {
		return _idMaterial;
	}

	public String getNombre() {
		return _nombre;
	}

	public Boolean getActivo() {
		return _Activo;
	}
	
	public Integer getExistencias() {
		return _existencias;
	}
	
	public Integer getNAlmacen() {
		return _nAlmacen;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public void setActivo(Boolean activo) {
		this._Activo = activo;
	}

	public void setId(Integer id) {
		this._idMaterial = id;
	}
	public void setExistencias(Integer existencias) {
		this._existencias = existencias;
	}
	public void setNAlmacen(Integer nAlmacen) {
		this._nAlmacen = nAlmacen;
	}
}