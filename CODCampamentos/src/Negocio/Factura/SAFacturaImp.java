/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

public class SAFacturaImp implements SAFactura {
	// private DAOFactura daoFactura =
	// FactoriaIntegracionImp.obtenerInstancia().();

	public TCarrito abrirVenta(Integer idCliente) {
		TFactura tFactura = new TFactura();
		TCarrito tCarrito = new TCarrito();

		if (idCliente >= 0) {
			// Abrimos la factura y modificamos el id del cliente
			tFactura.setIdCliente(idCliente);
			tCarrito.settFactura(tFactura);
		}
		return tCarrito;
	}

	public Set<TCarrito> mostrarFacturas() {
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

	public void aniadirActividad(Integer idActividad, Integer cantidad) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void quitarActividad(Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public Float devolucionVenta(Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

}