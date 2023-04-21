/**
 * 
 */
package Negocio.Personal;

public class TPersonal  {

	public Integer getIdPersonal() {
		return IdPersonal;
	}
	public void setIdPersonal(Integer idPersonal) {
		IdPersonal = idPersonal;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipoPersonal() {
		return TipoPersonal;
	}
	public void setTipoPersonal(String tipoPersonal) {
		TipoPersonal = tipoPersonal;
	}
	public Integer getIdTurno() {
		return IdTurno;
	}
	public void setIdTurno(Integer idTurno) {
		IdTurno = idTurno;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public TPersonal(Integer idPersonal, String dNI, String nombre, String tipoPersonal, Integer idTurno,
			boolean activo) {
		super();
		IdPersonal = idPersonal;
		DNI = dNI;
		Nombre = nombre;
		TipoPersonal = tipoPersonal;
		IdTurno = idTurno;
		this.activo = activo;
	}
	public TPersonal() {
		// TODO Auto-generated constructor stub
	}
	private Integer IdPersonal;
	private String DNI;
	private String Nombre;
	private String TipoPersonal;
	private Integer IdTurno;
	private boolean activo;

}