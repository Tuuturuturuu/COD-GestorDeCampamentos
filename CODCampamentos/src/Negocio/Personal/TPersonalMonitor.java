package Negocio.Personal;


public class TPersonalMonitor extends TPersonal {
	private String especialidad;
	private String estudios;
	public TPersonalMonitor(Integer idPersonal, String dNI, String nombre, int tipo, Integer idTurno,
			boolean activo, String especialidad, String estudios) {
		super(idPersonal, dNI, nombre, tipo, idTurno, activo);
		this.especialidad = especialidad;
		this.estudios = estudios;
	}
	
	
	public TPersonalMonitor() {
		// TODO Auto-generated constructor stub
	}


	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	

}