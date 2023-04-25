/**
 * 
 */
package Negocio.ComprobacionesRequisitosBBDD;

import java.sql.Date;
import java.sql.Time;

public abstract class ComprobacionesRequisitosBBDD {
	private static ComprobacionesRequisitosBBDD comprobacionesR = null;

	public static ComprobacionesRequisitosBBDD getComprobacionesRequisitosBBDD() {

		if (comprobacionesR == null)
			comprobacionesR = new ComprobacionesRequisitosBBDD_IMP();
		return comprobacionesR;
	}

	public abstract boolean nombreValido(String dni);

	public abstract boolean tlValido(String dni);

	public abstract boolean dniValido(String dni);

	public abstract boolean isNumeric(String dni);
	
	public abstract boolean fechaValida(Date dia);
	
	public abstract boolean horaValida(Time fecha);
}