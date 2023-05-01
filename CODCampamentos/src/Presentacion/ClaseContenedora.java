package Presentacion;

import Negocio.Actividad.TActividad;
import Negocio.Factura.TCarrito;

//Clase auxiliar para poder enviar al controlador el TActividad y TCarrito en las operaciones de
// EAnadirActividadFactura y EQuitarActividadFactura,
public class ClaseContenedora {
	private TActividad tActividad;
	private TCarrito tCarrito;

	public ClaseContenedora(TActividad tActividad, TCarrito tCarrito) {
		super();
		this.tActividad = tActividad;
		this.tCarrito = tCarrito;
	}

	public TActividad gettActividad() {
		return tActividad;
	}

	public void settActividad(TActividad tActividad) {
		this.tActividad = tActividad;
	}

	public TCarrito gettCarrito() {
		return tCarrito;
	}

	public void settCarrito(TCarrito tCarrito) {
		this.tCarrito = tCarrito;
	}

}