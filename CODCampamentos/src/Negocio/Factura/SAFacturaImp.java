/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Factura.DAOFactura;
import Integracion.Factura.DAOLineaFactura;
import Negocio.Actividad.TActividad;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;

public class SAFacturaImp implements SAFactura {

	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	private DAOFactura daoFactura = FactoriaIntegracionImp.obtenerInstancia().generaDAOFactura();
	private DAOLineaFactura daoLineaFactura = FactoriaIntegracionImp.obtenerInstancia().generaDAOLineaFactura();

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
		return daoFactura.mostrarFacturas();
		// end-user-code
	}

	public TCarrito cerrarVenta(TCarrito tCarrito) {

		// Factura con la que trabajaremos
		TFactura tFactura = new TFactura();
		TFactura tFacturaBBDD = new TFactura();

		// Objetos auxiliares
		TFactura tFacturaCarrito = tCarrito.gettFactura();
		Set<TLineaFactura> LineasFactura = tCarrito.gettLineaFactura();
		TActividad tActividadBBDD = new TActividad();
		TActividad tActividadFinal = new TActividad();

		// Comprobar Stock de la Actividad de cada LineaFactura
		boolean correct = true;
		for (TLineaFactura linea : LineasFactura) {
			// Obtenemos el idActividad de esa linea y miramos stock
			tActividadBBDD.setIdActividad(linea.getIdActividad());
			tActividadBBDD = daoActividad.buscarActividadID(tActividadBBDD);

			// Comprobamos stock en cada Actividad
			if (tActividadBBDD.getNumplazas() < linea.getCantidad()) {
				// Si no hay stock, paramos de recorrer el LineasFactura
				correct = false;
				break;

			} // Si hay stock, seguimos comprobando stock en siguiente linea
		}

		if (!correct) { // Si no hay stock, enviamos error de no hay Stock
			tFacturaCarrito.setIdFactura(tCarrito.gettFactura().getIdCliente());
			tFacturaCarrito.setIdCliente(-26);
			tCarrito.settFactura(tFacturaCarrito);
		} else {
			// Si no hubo errores de stock modificamos cada Actividad su numero
			// de plazas
			float PrecioTotalFactura = 0;
			for (TLineaFactura linea : LineasFactura) {
				// Obtenemos el idActividad de esa linea para conseguir todos
				// sus datos
				tActividadBBDD.setIdActividad(linea.getIdActividad());
				tActividadBBDD = daoActividad.buscarActividadID(tActividadBBDD);

				// Modificamos numPlazas
				int numPlazasNew = tActividadBBDD.getNumplazas() - linea.getCantidad();
				tActividadBBDD.setNumplazas(numPlazasNew);
				tActividadFinal = daoActividad.modificarActividad(tActividadBBDD);

				// Acumulo el precio total
				PrecioTotalFactura += linea.getPrecio();
			}

			// Si no ha habido errores, crear TFactura

			// Agrego los valores de idCliente y total y
			// activo ponemos a false, porque no es devuelta
			tFactura.setIdCliente(tCarrito.gettFactura().getIdCliente());
			tFactura.setTotal(PrecioTotalFactura);
			tFactura.setActivo(false);

			// Agregar la TFactura a la base de datos
			tFacturaBBDD = daoFactura.cerrarFactura(tFactura);

			// Obtenemos todos los valores de la factura creada, conseguimos la
			// fecha
			tFacturaBBDD = daoFactura.mostrarFactura(tFacturaBBDD);

			// Recorremos LineasFactura para modificar el idFactura
			for (TLineaFactura linea : LineasFactura) {
				// Modificamos el idFactura
				linea.setIdFactura(tFacturaBBDD.getIdFactura());
				// Metemos cada lineaFactura a la Base de datos
				daoLineaFactura.crearLineaFactura(linea);
			}

			/*
			 * // Si ha habido un error a la hora de agregar las lineaFactura,
			 * informamos del error if (!CorrectLineaFactura){
			 * tFacturaCarrito.setIdFactura(tCarrito.gettFactura().getIdCliente(
			 * )); tFacturaCarrito.setIdCliente(-26);
			 * tCarrito.settFactura(tFacturaCarrito); }
			 */

			// Metemos la nueva Factura al carrito
			tCarrito.settFactura(tFacturaBBDD);
		}

		return tCarrito;
	}

	public TCarrito mostarVenta(Integer idFactura) {

		// Vars Auxiliares
		TCarrito Venta = new TCarrito();
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TFactura tFactura = new TFactura();
		TFactura tFacturaBBDD = new TFactura();

		// Comprobar que no hay fallo en el campo integer
		if (idFactura >= 0) {
			// Comprobar que no es un campo vac�o
			if (idFactura == 0) {
				tFactura.setIdCliente(-37);
				Venta.settFactura(tFactura);
				Venta.settLineaFactura(LineasFactura);
			} else {
				// Comprobar que el idFactura existe
				tFactura.setIdFactura(idFactura);
				tFacturaBBDD = daoFactura.mostrarFactura(tFactura);

				if (tFacturaBBDD.getIdFactura() != -1) {
					// La factura existe, la agregamos al carrito
					Venta.settFactura(tFacturaBBDD);

					// Conseguimos todos los tLineaFactura que tengan el
					// idFactura
					LineasFactura = daoLineaFactura.mostrarLineaFacturaPorFactura(tFacturaBBDD.getIdFactura());

					// Agregamos al carrito
					Venta.settLineaFactura(LineasFactura);

				} else {// Informamos del error de que no existe
					tFactura.setIdCliente(-42);
					Venta.settFactura(tFactura);
					Venta.settLineaFactura(LineasFactura);
				}

			}

		} else {
			tFactura.setIdCliente(idFactura);
			Venta.settFactura(tFactura);
			Venta.settLineaFactura(LineasFactura);
		}
		// Devolver el carrito
		return Venta;
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
			if (tActividad.getIdActividad() == 0 || tActividad.getNumplazas() == 0) {
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
						Integer cantidadTotal = 0;
						float PrecioTotal = 0;
						for (TLineaFactura linea : LineasFactura) {
							if (linea.getIdActividad() == tActividad.getIdActividad()) {
								// Si lo encuentra, modificamos la cantidad
								encontrado = true;
								cantidadTotal = linea.getCantidad() + tActividad.getNumplazas();
								linea.setCantidad(cantidadTotal);

								// Modificamos el precio
								PrecioTotal = actividadBBDD.getPrecio() * cantidadTotal;
								linea.setPrecio(PrecioTotal);
							}
						}

						// Si no se encuentra, agrega una nueva LineaFactua
						if (!encontrado) {
							cantidadTotal = tActividad.getNumplazas();
							tLineaFactura.setCantidad(tActividad.getNumplazas());
							// Conseguir el precio de la BBDD
							PrecioTotal = actividadBBDD.getPrecio() * cantidadTotal;
							tLineaFactura.setPrecio(PrecioTotal);
							// Rellenar el resto de atributos
							tLineaFactura.setIdActividad(tActividad.getIdActividad());
							tLineaFactura.setIdFactura(tFactura.getIdFactura()); // 0
							// Agregar el TLineaFactura al Set
							LineasFactura.add(tLineaFactura);
						}
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

	public TFactura devolucionVenta(Integer idFactura) {

		// Vars Auxiliares
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TFactura tFactura = new TFactura();
		TFactura tFacturaBBDD = new TFactura();
		TActividad tActividadBBDD = new TActividad();
		Integer correct;

		// Comprobar que no hay fallo en el campo integer
		if (idFactura >= 0) {
			// Comprobar que no es un campo vacio
			if (idFactura == 0) {
				tFactura.setIdCliente(-37);
			} else {
				// Comprobar que el idFactura existe
				tFactura.setIdFactura(idFactura);
				tFacturaBBDD = daoFactura.mostrarFactura(tFactura);

				if (tFacturaBBDD.getIdFactura() != -1) {
					// La factura existe, procedemos a indicar que esta devuelta
					tFactura = daoFactura.devolverFactura(tFacturaBBDD);

					// Conseguimos todos los tLineaFactura que tengan ese id
					// Factura
					LineasFactura = daoLineaFactura.mostrarLineaFacturaPorFactura(tFactura.getIdFactura());

					// Recorremos cada LineaFactura para conseguir el
					// idActividad
					// y de esta manera volvemos a actualizar el numPlazas con
					// las devoluciones

					for (TLineaFactura linea : LineasFactura) {

						tActividadBBDD.setIdActividad(linea.getIdActividad());
						// Conseguimos todos los datos de la Actividad buscando
						// en la base de datos
						tActividadBBDD = daoActividad.buscarActividadID(tActividadBBDD);

						// Actualizamos el numPlazas de cada Actividad
						Integer newNumPlazas = tActividadBBDD.getNumplazas() + linea.getCantidad();
						tActividadBBDD.setNumplazas(newNumPlazas);
						tActividadBBDD = daoActividad.modificarActividad(tActividadBBDD);

					}

					// Eliminamos todos los tLineaFactura que tengan el
					// idFactura
					correct = daoLineaFactura.eliminarLineaFactura(tFacturaBBDD.getIdFactura());

					// Comprobamos si ha habido un error al eliminar
					if (correct == 0) {
						tFactura.setIdCliente(-15);
					} // Si no hay errores, devolvemos la factura modificada

				} else {// Informamos del error de que no existe
					tFactura.setIdCliente(-42);
				}
			}
		} else {
			tFactura.setIdCliente(idFactura);
		}
		// Devolver el carrito
		return tFactura;
	}

	@Override
	public TCarrito mostarVentaporActividad(Integer idActividad) {
		// Vars Auxiliares
		TCarrito Venta = new TCarrito();
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TActividad tActividad = new TActividad();
		TActividad tActividadBBDD = new TActividad();
		TFactura tFactura = new TFactura();

		// Comprobar que no hay fallo en el campo integer
		if (idActividad >= 0) {
			// Comprobar que no es un campo vac�o
			if (idActividad == 0) {
				tFactura.setIdCliente(-37);
				Venta.settFactura(tFactura);
				Venta.settLineaFactura(LineasFactura);
			} else {
				// Comprobar que el idActividad existe
				tActividad.setIdActividad(idActividad);
				tActividadBBDD = daoActividad.buscarActividadID(tActividad);

				if (tActividadBBDD.getIdActividad() != -1) {
					// La actividad existe

					// Conseguimos todos los tLineaFactura que tengan el
					// idActividad
					LineasFactura = daoLineaFactura.mostrarLineaFacturaPorActividad(tActividadBBDD.getIdActividad());

					// Agregamos al carrito
					Venta.settLineaFactura(LineasFactura);

					tFactura.setIdCliente(1);
					Venta.settFactura(tFactura);

				} else {// Informamos del error de que no existe
					tFactura.setIdCliente(-23);
					Venta.settFactura(tFactura);
					Venta.settLineaFactura(LineasFactura);
				}
			}

		} else {
			tFactura.setIdCliente(idActividad);
			Venta.settFactura(tFactura);
			Venta.settLineaFactura(LineasFactura);
		}

		return Venta;
	}

}