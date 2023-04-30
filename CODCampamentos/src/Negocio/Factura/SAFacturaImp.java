/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Negocio.Actividad.TActividad;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;

public class SAFacturaImp implements SAFactura {

	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();

	public TCarrito abrirVenta(Integer idCliente) {
		TFactura tFactura = new TFactura();
		TCarrito tCarrito = new TCarrito();
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();

		if (idCliente == 0)
			tFactura.setIdCliente(-37);
		else // Abrimos la factura y modificamos el id del cliente
			tFactura.setIdCliente(idCliente);
		tCarrito.settFactura(tFactura);
		tCarrito.settLineaFactura(LineasFactura);
		return tCarrito;
	}

	public Set<TFactura> mostrarFacturas() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer cerrarVenta(Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TCarrito mostarVenta(Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public void modificarVenta(Integer idActividad, Integer newCantidad, Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public TCarrito aniadirActividad(TActividad tActividad, TCarrito tCarrito) {

		// Objetos que usaremos como auxiliares
		TFactura tFactura = tCarrito.gettFactura();
		TActividad actividadBBDD = new TActividad();
		TLineaFactura tLineaFactura = new TLineaFactura();
		Set<TLineaFactura> LineasFactura = tCarrito.gettLineaFactura();

		// Comprobar que no ha habido un error al insertar datos
		if (tActividad.getIdActividad() >= 0) {

			// Comprobar que los datos introducidos no son nulos
			if (tActividad.getIdActividad() == 0 && tActividad.getNumplazas() == 0) {
				// Guardo el id del cliente que creo la factura
				tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
				tFactura.setIdCliente(-37);
				tCarrito.settFactura(tFactura);
			} else if (!compr.numPlazas(tActividad.getNumplazas())) {
				tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
				tFactura.setIdCliente(-7);
				tCarrito.settFactura(tFactura);
			} else { // Comprobar que la Actividad existe y se encuentra activa
				actividadBBDD = daoActividad.buscarActividadID(tActividad);
				if (actividadBBDD.getIdActividad() != -1) {// encontrado en bbdd
					if (actividadBBDD.getActivo() == false) { // esta dada de
																// baja
						tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
						tFactura.setIdCliente(-25);
						tCarrito.settFactura(tFactura);
					} else {

						// Comprobar que no existe una lineaFactura con el mismo
						// id ingresado
						boolean encontrado = false;
						for (TLineaFactura linea : LineasFactura) {
							if (linea.getIdActividad() == tActividad.getIdActividad()) {
								// Guardamos en una lineaFactura auxiliar para
								// luego eliminarla
								encontrado = true;
								tLineaFactura = linea;
							}
						}

						// Comprobar si lo ha encontrado o no
						if (encontrado) {
							// Si lo encuentra, modificamos la cantidad
							Integer cantidadTotal = tLineaFactura.getCantidad() + tActividad.getNumplazas();

							// Eliminamos el lineaFactura antiguo
							LineasFactura.remove(tLineaFactura);

							// Agregamos uno nuevo con cantidad actualizada
							tLineaFactura.setCantidad(cantidadTotal);

						} else // Si no lo encuentra, la cantidad será la
								// ingresada por el usuario
							tLineaFactura.setCantidad(tActividad.getNumplazas());

						// Tanto para modificar como para aniadir, haremos lo
						// mismo
						// por lo tanto dejamos el resto de las operaciones
						// fuera del if

						// Meter los datos en TLineaFactura
						// Conseguir el precio de la BBDD
						tLineaFactura.setPrecio(actividadBBDD.getPrecio());

						// Rellenar el resto de atributos
						tLineaFactura.setIdActividad(tActividad.getIdActividad());

						tLineaFactura.setIdFactura(0);

						// Agregar el TLineaFactura al Set
						LineasFactura.add(tLineaFactura);

						// Modificar el set de Linea Factura en carrito
						tCarrito.settLineaFactura(LineasFactura);

					}
				} else { // No existe actividad con dicho ID
					tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
					tFactura.setIdCliente(-23);
					tCarrito.settFactura(tFactura);
				}
			}
		} else { // Si ha habido un error, modifico el TCarrito para mostrar
					// dicho error
			tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
			tFactura.setIdCliente(tActividad.getIdActividad());
			tCarrito.settFactura(tFactura);
		}
		// Devolver el Carrito
		return tCarrito;
	}

	public TCarrito quitarActividad(TActividad tActividad, TCarrito tCarrito) {

		// Objetos que usaremos como auxiliares
		TFactura tFactura = tCarrito.gettFactura();
		TActividad actividadBBDD = new TActividad();
		TLineaFactura tLineaFactura = new TLineaFactura();
		Set<TLineaFactura> LineasFactura = tCarrito.gettLineaFactura();

		// Comprobar error del campo integer
		if (tActividad.getIdActividad() >= 0) {
			// Comprobar que el campo id Actividad no es nulo
			if (tActividad.getIdActividad() == 0) {
				// Guardo el id del cliente que creo la factura
				tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
				tFactura.setIdCliente(-37);
				tCarrito.settFactura(tFactura);
			} else {

				// Buscar el idActividad en el set de TLineasFactura
				boolean encontrado = false;
				for (TLineaFactura linea : LineasFactura) {
					if (linea.getIdActividad() == tActividad.getIdActividad()) {
						// Guardamos en una lineaFactura auxiliar para luego
						// eliminarla
						encontrado = true;
						tLineaFactura = linea;
					}
				}

				// Comprobar si lo ha encontrado o no
				if (encontrado) {
					// Si lo encuentra, eliminar
					LineasFactura.remove(tLineaFactura);
				} else {
					// Si no lo encuentra enviar un error
					tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
					tFactura.setIdCliente(-24);
					tCarrito.settFactura(tFactura);
				}
			}
		} else {
			// Modifico el carrito para mostrar dicho error
			tFactura.setIdFactura(tCarrito.gettFactura().getIdCliente());
			tFactura.setIdCliente(tActividad.getIdActividad());
			tCarrito.settFactura(tFactura);
		}
		return tCarrito;
	}

	public Float devolucionVenta(Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

}