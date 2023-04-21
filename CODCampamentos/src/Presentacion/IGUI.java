
package Presentacion;

import java.util.Set;


public interface IGUI {

	Set<IGUI> iGUI = null;

	
	public void actualizar(Object object, Evento event);
}