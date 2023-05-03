package TNegocio.Factura;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Integracion.Actividad.DAOActividad;
import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class NFacturaTest {

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
	public void abrirVenta() {
		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		int idCliente = 1;

		TFactura tFactura = new TFactura();
		tFactura.setIdCliente(idCliente);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TCarrito expected = new TCarrito(tFactura, LineasFactura);
		TCarrito actual = saFactura.abrirVenta(idCliente);
		assertTrue(compCarrito(expected, actual));

	}

	@Test
	public void mostrarFacturas() {
		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();

		TFactura tFacturaAct = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("5"), false);
		Set<TLineaFactura> LineasFacturaAct = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
		LineasFacturaAct.add(linea);
		TCarrito actualCarrito = new TCarrito(tFacturaAct, LineasFacturaAct);
		saFactura.cerrarVenta(actualCarrito);
		Set<TFactura> actual = new HashSet<TFactura>();
		actual.add(actualCarrito.gettFactura());
		Set<TFactura> expected = new HashSet<TFactura>();
		expected = saFactura.mostrarFacturas();

		boolean ok = expected.size() == actual.size();

		Iterator<TFactura> i = expected.iterator();
		Iterator<TFactura> j = actual.iterator();

		while (ok && i.hasNext() && j.hasNext()) {
			ok = compFacturas((TFactura) i.next(), (TFactura) j.next());
		}

		Assert.assertTrue(ok);
	}

	// @Test
	// public void CerrarVenta() {
	// int idCliente = 1;
	// TFactura tFacturaExp = new TFactura(1, idCliente,
	// Date.valueOf("2023-05-02"), Float.parseFloat("5"), false);
	// Set<TLineaFactura> LineasFacturaExp = new HashSet<TLineaFactura>();
	// TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
	// LineasFacturaExp.add(linea);
	// TCarrito expected = new TCarrito(tFacturaExp, LineasFacturaExp);
	//
	// SAFactura saFactura =
	// FactoriaSAImp.obtenerInstancia().generarSAFactura();
	//
	// TFactura tFacturaAct = new TFactura();
	// tFacturaAct.setIdCliente(idCliente);
	// Set<TLineaFactura> LineasFacturaActual = new HashSet<TLineaFactura>();
	// LineasFacturaActual.add(linea);
	// TCarrito actual = saFactura.cerrarVenta(new TCarrito(tFacturaAct,
	// LineasFacturaActual));
	//
	// Assert.assertTrue(compCarrito(expected, actual));
	//
	// }

	@Test
	public void mostrarVentaOK() {

		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura exp = new TFactura(0, 1, Date.valueOf("2023-02-23"), Float.parseFloat("0"), true);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
		LineasFactura.add(linea);
		TCarrito expected = new TCarrito(exp, LineasFactura);

		TCarrito act = saFactura.cerrarVenta(expected);
		act = saFactura.mostarVenta(act.gettFactura().getIdFactura());

		Assert.assertTrue(compCarrito(expected, act));

	}

	@Test
	public void aniadirActividad() {
		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura tFacturaExp = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("0"), false);
		Set<TLineaFactura> LineasFacturaExp = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("110"), 22);
		LineasFacturaExp.add(linea);
		TCarrito expected = new TCarrito(tFacturaExp, LineasFacturaExp);

		TFactura tFacturaAct = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("0"), false);
		Set<TLineaFactura> LineasFacturaAct = new HashSet<TLineaFactura>();
		TCarrito actual = new TCarrito(tFacturaAct, LineasFacturaAct);
		TActividad tActividad = new TActividad(1, "futbol", "bosque", 22, Float.parseFloat("5"), 1, true);
		actual = saFactura.aniadirActividad(tActividad, actual);

		Assert.assertTrue(compCarrito(expected, actual));
	}

	@Test
	public void quitarActividad() {
		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura tFacturaExp = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("5"), false);
		Set<TLineaFactura> LineasFacturaExp = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
		LineasFacturaExp.add(linea);
		TCarrito expected = new TCarrito(tFacturaExp, LineasFacturaExp);

		TFactura tFacturaAct = new TFactura(1, 1, Date.valueOf("2023-05-02"), Float.parseFloat("5"), false);
		Set<TLineaFactura> LineasFacturaAct = new HashSet<TLineaFactura>();
		TLineaFactura linea2 = new TLineaFactura(2, 1, Float.parseFloat("5"), 10);
		LineasFacturaAct.add(linea);
		LineasFacturaAct.add(linea2);
		TCarrito actual = new TCarrito(tFacturaAct, LineasFacturaAct);
		TActividad tActividad = new TActividad(2, null, null, null, null, null, true);
		actual = saFactura.quitarActividad(tActividad, actual);

		Assert.assertTrue(compCarrito(expected, actual));

	}
	//
	// @Test
	// public void devolucionVenta() {
	// SAFactura saFactura =
	// FactoriaSAImp.obtenerInstancia().generarSAFactura();
	// TFactura tFacturaExp = new TFactura(1, 1, Date.valueOf("2023-05-02"),
	// Float.parseFloat("5"), true);
	//
	// TFactura tFacturaAct = new TFactura(1, 1, Date.valueOf("2023-05-02"),
	// Float.parseFloat("5"), false);
	// Set<TLineaFactura> LineasFacturaAct = new HashSet<TLineaFactura>();
	// TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
	// LineasFacturaAct.add(linea);
	// TCarrito actual = new TCarrito(tFacturaAct, LineasFacturaAct);
	// saFactura.cerrarVenta(actual);
	// tFacturaAct = saFactura.devolucionVenta(tFacturaAct.getIdFactura());
	//
	// Assert.assertTrue(compFacturas(tFacturaExp, tFacturaAct));
	//
	// }

	@Test
	public void mostarVentaporActividad() {
		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura exp = new TFactura(0, 1, Date.valueOf("2023-02-23"), Float.parseFloat("0"), true);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(1, 1, Float.parseFloat("5"), 10);
		LineasFactura.add(linea);
		TCarrito expected = new TCarrito(exp, LineasFactura);

		TCarrito act = saFactura.cerrarVenta(expected);
		act = saFactura.mostarVentaporActividad(1);

		boolean ok = expected.gettLineaFactura().size() == act.gettLineaFactura().size();

		Iterator<TLineaFactura> i = expected.gettLineaFactura().iterator();
		Iterator<TLineaFactura> j = act.gettLineaFactura().iterator();

		while (ok && i.hasNext() && j.hasNext()) {
			ok = complineaFactura((TLineaFactura) i.next(), (TLineaFactura) j.next());
		}

		Assert.assertTrue(ok);
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