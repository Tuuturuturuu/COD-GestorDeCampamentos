package Negocio.ComprobacionesRequisitosBBDD;

public class ComprobacionesRequisitosBBDD_IMP extends ComprobacionesRequisitosBBDD {
	public boolean nombreValido(String nombre) {
		if (nombre.trim().length() > 100 || nombre.trim().length() < 1)
			return false;
		else
			return true;
	}

	public boolean tlValido(String tlf) {
		if (tlf.trim().length() > 15)
			return false;
		else
			return true;
	}
	
	//Metodo para Actividad
	public boolean numPlazas(int plazas) {
		if (plazas > 500)
			return false;
		else
			return true;
	}
	
	public boolean precio(float precio) {
		if (precio > 1000)
			return false;
		else
			return true;
	}

	public boolean dniValido(String dni) {
		String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (dni.length() != 9)
			return false;
		String parteEnteraDNI = dni.trim().replaceAll(" ", "").substring(0, 7);
		char ltrDNI = dni.charAt(8);
		int valNumDni = Integer.parseInt(parteEnteraDNI) % 23;
		if (dni.length() != 9 && isNumeric(parteEnteraDNI) == false && dniChars.charAt(valNumDni) != ltrDNI)
			return false;
		else
			return true;
	}

	public boolean isNumeric(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean direccionValido(String direccionLab) {
		if (direccionLab.trim().length() > 45 || direccionLab.trim().length() < 1)
			return false;
		else
			return true;
	}
}