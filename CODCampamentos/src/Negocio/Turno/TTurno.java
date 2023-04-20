
package Negocio.Turno;

import java.util.Date;
import java.sql.Time;

//EN PRINCIPIO ESTATODO

public class TTurno {
	
	private String Nombre;	
	private Date Fecha;
	private Time Hora;
	private Integer IdTurno;	
	private Integer Activo;
	
	//CAMBIAR EL TIPO DE ACTIVO A BOOLEANO??
	public TTurno(String nombre, Date Fecha, Time Hora, Integer IdTurno, Integer Activo){
		this.Nombre=nombre;
		this.Fecha =Fecha;
		this.Hora =Hora;
		this.IdTurno=IdTurno;
		this.Activo=Activo;
	}
	
	public TTurno(){
		
	}
	
	public Integer getId() {
		// begin-user-code
		// TODO Auto-generated method stub
		return IdTurno;
		// end-user-code
	}

	public String getNombre() {
		return Nombre;	
	}

	public Date getFecha() {
		return Fecha;
	}

	public Time getHora() {
		return Hora;
	}

	public Integer getActivo() {
		return Activo;
	}

	public void setNombre(String Nombre) {
		this.Nombre=Nombre;
	}

	public void serFecha(Date fecha) {
		this.Fecha=fecha;
	}

	public void setHora(Time hora) {
		this.Hora= hora;
	}

	public void setActivo(Integer activo) {
		this.Activo=activo;
	}

	public void setId(Integer IdTurno) {
	this.IdTurno= IdTurno;
	}
}