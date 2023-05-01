package TNegocio.Factura;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Integracion.Actividad.DAOActividad;
import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Factura.SAFactura;
import Negocio.Factura.SAFacturaImp;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class NFacturaTest {
	private SAFacturaImp saFactura;

	private boolean compFacturas(TFactura a, TFactura b) {

		return a.getActivo() == b.getActivo() && a.getIdFactura() == b.getIdFactura()
				&& a.getIdCliente() == b.getIdCliente() && a.getFecha() == b.getFecha() && a.getTotal() == b.getTotal();
	}

	private boolean complineaFactura(TLineaFactura a, TLineaFactura b) {
		return a.getIdFactura() == b.getIdFactura() && a.getIdActividad() == b.getIdActividad()
				&& a.getPrecio() == b.getPrecio() && a.getCantidad() == b.getCantidad();
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

	}

	@Test
	public void CerrarVenta() {

	}

	@Test
	public void mostrarVentaOK() {

		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura exp = new TFactura(0, 0, Date.valueOf("2023-02-23"), Float.parseFloat("0"), true);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(0, 0, Float.parseFloat("5"), 10);
		LineasFactura.add(linea);
		TCarrito expected = new TCarrito(exp, LineasFactura);

		TCarrito act = saFactura.cerrarVenta(expected);
		act = saFactura.mostarVenta(act.gettFactura().getIdFactura());

		Assert.assertTrue(compCarrito(expected, act));

	}

	@Test
	public void aniadirActividad() {

		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura exp = new TFactura(0, 0, Date.valueOf("2023-02-23"), Float.parseFloat("0"), true);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(0, 0, Float.parseFloat("2"), 23);
		LineasFactura.add(linea);
		TCarrito expected = new TCarrito(exp, LineasFactura);
		TActividad tactividad = new TActividad(0, "futbol", "campo", 23, Float.parseFloat("2"), 0, true);
		TFactura fAux = new TFactura();
		Set<TLineaFactura> lAux = new HashSet<TLineaFactura>();
		TCarrito aux = new TCarrito(fAux, lAux);

		TCarrito act = saFactura.aniadirActividad(tactividad, aux);

		Assert.assertTrue(compCarrito(expected, act));
	}

	@Test
	public void quitarActividad() {

		SAFactura saFactura = FactoriaSAImp.obtenerInstancia().generarSAFactura();
		TFactura exp = new TFactura(0, 0, Date.valueOf("2023-02-23"), Float.parseFloat("0"), true);
		Set<TLineaFactura> LineasFactura = new HashSet<TLineaFactura>();
		TLineaFactura linea = new TLineaFactura(0, 0, Float.parseFloat("2"), 23);
		LineasFactura.add(linea);
		TCarrito expected = new TCarrito(exp, LineasFactura);
		TActividad tactividad = new TActividad(0, "futbol", "campo", 23, Float.parseFloat("2"), 0, true);
		TFactura fAux = new TFactura();
		Set<TLineaFactura> lAux = new HashSet<TLineaFactura>();
		TCarrito aux = new TCarrito(fAux, lAux);

		TCarrito act = saFactura.quitarActividad(tactividad, expected);

		Assert.assertTrue(compCarrito(act, aux));
	}

	@Test
	public void devolucionVenta() {

	}

	@Test
	public void mostarVentaporActividad() {

	}

	@BeforeClass
	public static void populateBBDD() {
		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoTurno.CrearTurno(new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true));
		daoPersonal.CrearPersonal(new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4));
		daoActividad.crearActividad(new TActividad(0, "futbol", "bosque", 22, Float.parseFloat("5"), 1, true));

	}

	@AfterClass
	public static void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("Actividad");
		TestsBorrarDatos.borrarDatosTabla("ActividadMaterial");
		TestsBorrarDatos.borrarDatosTabla("Factura");
		TestsBorrarDatos.borrarDatosTabla("TLineaFactura");
		TestsBorrarDatos.borrarDatosTabla("Monitores");
		TestsBorrarDatos.borrarDatosTabla("Cocineros");
		TestsBorrarDatos.borrarDatosTabla("Personal");
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

	@After
	public void borrarBD_Factura() {
		TestsBorrarDatos.borrarDatosTabla("Factura");
		TestsBorrarDatos.borrarDatosTabla("TLineaFactura");
	}

}
