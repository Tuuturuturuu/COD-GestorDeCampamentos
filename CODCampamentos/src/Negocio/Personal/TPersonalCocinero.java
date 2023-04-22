package Negocio.Personal;

public class TPersonalCocinero extends TPersonal {
	private String puestoEnCocina;
	private Integer aniosExperiencia;
	

	public TPersonalCocinero(Integer idPersonal, String dNI, String nombre, int tipo, Integer idTurno,
			boolean activo, String puestoEnCocina, Integer aniosExperiencia) {
		super(idPersonal, dNI, nombre, tipo, idTurno, activo);
		 this.puestoEnCocina =puestoEnCocina;
		 this.aniosExperiencia = aniosExperiencia;
	}
	
	public TPersonalCocinero(){
		super();
	}

	public String getPuestoEnCocina() {
		return puestoEnCocina;
	}

	public void setPuestoEnCocina(String puestoEnCocina) {
		this.puestoEnCocina = puestoEnCocina;
	}

	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	
	
}