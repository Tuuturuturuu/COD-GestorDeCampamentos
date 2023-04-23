
package Negocio.Personal;

//HECHO
public class TPersonal  {
	
	private Integer IdPersonal;	
	private String DNI;	
	private String Nombre;	
	private String Especialidad;	
	private String Estudios;	
	private String Experiencia;
	private Integer NumeroDeCocina;
	private Integer IdTurno;

	TPersonal(Integer IdPersonal, String DNI,String Nombre,String Especialidad,	 
			String Estudios, String Experiencia,Integer NumeroDeCocina,Integer IdTurno){
		
		this.DNI=DNI;
		this.Especialidad=Especialidad;
		this.Estudios=Estudios;
		this.Experiencia=Experiencia;
		this.IdPersonal=IdPersonal;
		this.IdTurno=IdTurno;
		this.Nombre=Nombre;
		this.NumeroDeCocina=NumeroDeCocina;
	}
	
	TPersonal(){
	}
	
	public Integer getIdPersonal() {	
		return IdPersonal;	
	}

	public String getDNI() {	
		return DNI;	
	}

	public String getNombre() {	
		return Nombre;	
	}

	public String getEspecialidad() {	
		return Especialidad;	
	}
	
	public String getEstudios() {	
		return Estudios;
	}

	public String getExperiencia() {	
		return Experiencia;	
	}

	public Integer getNumDeCocina() {	
		return NumeroDeCocina;
	}

	public void setIdPersonal(Integer id) {	
		
	}

	public void setDNI(String DNI) {
		this.DNI=DNI;
	}

	public void setNombre(String nom) {
		this.Nombre=nom;
	}

	public void setEspecialidad(String esp) {
		this.Especialidad=esp;
	}

	public void setEstudios(String est) {
		this.Estudios=est;
	}
	public void setExperiencia(String exp) {
		this.Experiencia=exp;
	}

	public void setNumeroDeCocina(Integer num) {
		this.NumeroDeCocina=num;
	}
	
	public void setidTurno(Integer id) {
		this.IdTurno=id;
	}
}