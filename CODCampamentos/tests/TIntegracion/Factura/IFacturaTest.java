package TIntegracion.Factura;

import java.sql.Date;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Integracion.Actividad.DAOActividad;
import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.Actividad.TActividad;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class IFacturaTest {
	private boolean compFacturas(TFactura a, TFactura b) {
		boolean fechaok = (a.getFecha() == null && b.getFecha() == null) ? true : a.getFecha().equals(b.getFecha());
		boolean totalok = (a.getTotal() == null && b.getTotal() == null) ? true : a.getTotal().equals(b.getTotal());
		return a.getActivo() == b.getActivo() && a.getIdFactura() == b.getIdFactura()
				&& a.getIdCliente() == b.getIdCliente() && fechaok && totalok;
	}

	private boolean complineaFactura(TLineaFactura a, TLineaFactura b) {
		boolean preciook = (a.getPrecio() == null && b.getPrecio() == null) ? true
				: a.getPrecio().equals(b.getPrecio());
		return a.getIdFactura() == b.getIdFactura() && a.getIdActividad() == b.getIdActividad() && preciook
				&& a.getCantidad() == b.getCantidad();
	}

	private boolean compCarrito(TCarrito a, TCarrito b) {
		boolean ok = compFacturas(a.gettFactura(), b.gettFactura());

		ok = ok && a.gettLineaFactura().size() == b.gettLineaFactura().size();

		Iterator<TLineaFactura> i = a.gettLineaFactura().iterator();
		Iterator<TLineaFactura> j = b.gettLineaFactura().iterator();

		while (ok && i.hasNext() && j.hasNext()) {
			ok = ok && complineaFactura((TLineaFactura) i.next(), (TLineaFactura) j.next());
		}
		return ok;
	}

	@Test
	public void cerrarFacturaOK() {
		TFactura facturaExp = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("5"), true);

	}

	@Test
	public void devolverFacturaOK() {

	}

	@Test
	public void mostrarFacturaOK() {

	}

	@Test
	public void mostrarFacturasOK() {

	}

	@Before
	public void populateBBDD() {
		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoTurno.CrearTurno(new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true));
		daoPersonal.CrearPersonal(new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4));
		daoActividad.crearActividad(new TActividad(0, "futbol", "bosque", 22, Float.parseFloat("5"), 1, true));
		daoActividad.crearActividad(new TActividad(0, "surf", "playa", 40, Float.parseFloat("7"), 1, true));
	}

	@After
	public void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("Actividad");
		TestsBorrarDatos.borrarDatosTabla("ActividadMaterial");
		TestsBorrarDatos.borrarDatosTabla("Factura");
		TestsBorrarDatos.borrarDatosTabla("TLineaFactura");
		TestsBorrarDatos.borrarDatosTabla("Monitores");
		TestsBorrarDatos.borrarDatosTabla("Cocineros");
		TestsBorrarDatos.borrarDatosTabla("Personal");
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

}
