package Negocio.Personal;

public class TPersonal {

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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getIdTurno() {
		return IdTurno;
	}

	public void setIdTurno(Integer idTurno) {
		IdTurno = idTurno;
	}

	public boolean getIsActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public TPersonal(Integer idPersonal, String dNI, String nombre, int tipo, Integer idTurno, boolean activo) {
		super();
		this.IdPersonal = idPersonal;
		this.DNI = dNI;
		this.Nombre = nombre;
		this.tipo = tipo;
		IdTurno = idTurno;
		this.activo = activo;
	}

	public TPersonal() {
		// TODO Auto-generated constructor stub
	}

	private Integer IdPersonal;
	private String DNI;
	private String Nombre;
	private Integer tipo;
	private Integer IdTurno;
	private boolean activo;

	@Override
	public String toString() {
		return "IdPersonal = " + IdPersonal + " , DNI = " + DNI + " , Nombre = " + Nombre + " , tipo = " + tipo
				+ " , IdTurno = " + IdTurno + " , activo= " + activo;
	}

}