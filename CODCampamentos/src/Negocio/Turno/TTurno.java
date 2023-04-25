package Negocio.Turno;

import java.util.Date;

public class TTurno {
	private Integer IdTurno;
	public TTurno(Integer idTurno, String nombreTurno, Date fecha, String hora, Boolean activo) {
		super();
		IdTurno = idTurno;
		NombreTurno = nombreTurno;
		Fecha = fecha;
		Hora = hora;
		Activo = activo;
	}
	public TTurno() {
		// TODO Auto-generated constructor stub
	}
	private String NombreTurno;
	private Date Fecha;
	private String Hora;
	private Boolean Activo;

	public TTurno(Integer idTurno, String nombreTurno, Date fecha, String hora, Boolean activo) {
		IdTurno = idTurno;
		NombreTurno = nombreTurno;
		Fecha = fecha;
		Hora = hora;
		Activo = activo;
	}

	public TTurno() {

	}

	public Integer getIdTurno() {
		return IdTurno;
	}

	public void setIdTurno(Integer idTurno) {
		IdTurno = idTurno;
	}

	public String getNombreTurno() {
		return NombreTurno;
	}

	public void setNombreTurno(String nombreTurno) {
		NombreTurno = nombreTurno;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public Boolean getActivo() {
		return Activo;
	}

	public void setActivo(Boolean activo) {
		Activo = activo;
	}

}