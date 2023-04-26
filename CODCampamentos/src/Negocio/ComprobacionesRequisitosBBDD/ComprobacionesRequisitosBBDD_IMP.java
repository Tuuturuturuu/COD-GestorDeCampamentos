package Negocio.ComprobacionesRequisitosBBDD;

import java.text.SimpleDateFormat;

public class ComprobacionesRequisitosBBDD_IMP extends ComprobacionesRequisitosBBDD {
	public boolean nombreValido(String nombre) {
		if (nombre.trim().length() > 100 || nombre.trim().length() < 1)
			return false;
		else
			return true;
	}
	
	public boolean checkString (String s){
		return s.matches("[a-zA-Z\\s]*"); 
	}
	
	public boolean tlValido(String tlf) {
		return tlf.matches("\\d{9}");
	}
	
	public boolean dniValido(String dni) {
		
		return dni.matches("\\d{8}[a-zA-Z]");
	}
	
	public boolean idValido(Integer idActividad) {
		if (idActividad > 10000 )
			return false;
		else
			return true;
	}
	
	//METODOS PARA MATERIAL
	public boolean almacenValido(int nAlmacen) {
		if (nAlmacen > 100 && nAlmacen > 0)
			return false;
		else
			return true;
	}
	
	public boolean nExistenciasValido(Integer existencias) {
		if (existencias > 10000 && existencias > 0)
			return false;
		else
			return true;
	}

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
	
	//Personal
	
	public boolean tipoPersonalValido(String p) {
		if (p.trim().length() > 45 || p.trim().length() < 1)
			return false;
		else
			return true;
	}
	
	public boolean aniosExp(int anios) {
		if (anios > 70 && anios < 0)
			return false;
		else
			return true;
	}
	
}