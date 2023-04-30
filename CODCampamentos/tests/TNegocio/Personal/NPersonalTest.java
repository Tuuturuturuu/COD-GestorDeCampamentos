package TNegocio.Personal;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Turno.DAOTurno;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Personal.SAPersonal;
import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class NPersonalTest {

	private boolean compPersonal(Negocio.Personal.TPersonal a, Negocio.Personal.TPersonal b) {
		return a.getIsActivo() == b.getIsActivo() && a.getDNI().equals(b.getDNI())
				&& a.getIdPersonal() == b.getIdPersonal() && a.getIdTurno() == b.getIdTurno()
				&& a.getNombre().equals(b.getNombre()) && a.getTipo() == b.getTipo();
	}

	@Test
	public void crearPersonalOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();
		TPersonalCocinero exp = new TPersonalCocinero(0, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		TPersonal act = saPersonal.crearPersonal(exp);

		Assert.assertTrue(compPersonal(exp, act));
	}

	@Test
	public void eliminarPersonalOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();
		TPersonalCocinero aux = new TPersonalCocinero(0, "12345678A", "test", 1, 1, true, "testPuesto", 4);
		TPersonalCocinero exp = new TPersonalCocinero(1, "12345678A", "test", 1, 1, false, "testPuesto", 4);
		TPersonal act = saPersonal.crearPersonal(aux);
		act = saPersonal.eliminarPersonal(act);

		Assert.assertTrue(compPersonal(exp, act));
	}

	@Test
	public void modificarPersonalOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();
		TPersonalCocinero aux = new TPersonalCocinero(0, "12345678A", "test", 1, 1, true, "testPuesto", 4);
		TPersonalCocinero exp = new TPersonalCocinero(1, "12345678A", "testNuevoNombre", 1, 1, true, "testPuesto", 4);

		TPersonal act = saPersonal.crearPersonal(aux);
		act = saPersonal.modificarPersonal(new TPersonal(1, "12345678A", "testNuevoNombre", 1, 1, true));

		Assert.assertTrue(compPersonal(exp, act));
	}

	@Test
	public void mostrarPersonalOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();
		TPersonalCocinero exp = new TPersonalCocinero(0, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		TPersonal act = saPersonal.crearPersonal(exp);
		act = saPersonal.mostrarUno(exp);

		Assert.assertTrue(compPersonal(exp, act));
	}

	@Test
	public void mostrarPersonalPorTurnoOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();

		int idTur = 1;
		TPersonalCocinero aux1 = new TPersonalCocinero(0, "12345678A", "test", 1, idTur, true, "testPuesto", 4);
		Set<TPersonal> exp = new HashSet<TPersonal>();
		exp.add(aux1);

		saPersonal.crearPersonal(aux1);
		Set<TPersonal> act = saPersonal.mostrarPersonalPorTurno(idTur);

		boolean ok = exp.size() == act.size();

		Iterator<TPersonal> i = exp.iterator();
		Iterator<TPersonal> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compPersonal((TPersonal) i.next(), (TPersonal) j.next());
		}

		Assert.assertTrue(ok);
	}

	@Test
	public void mostrarTodosPersonalOK() {
		SAPersonal saPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal();

		TPersonalCocinero aux1 = new TPersonalCocinero(0, "12345678A", "test", 1, 1, true, "testPuesto", 4);
		Set<TPersonal> exp = new HashSet<TPersonal>();
		exp.add(aux1);

		saPersonal.crearPersonal(aux1);
		Set<TPersonal> act = saPersonal.mostrarTodos();

		boolean ok = exp.size() == act.size();

		Iterator<TPersonal> i = exp.iterator();
		Iterator<TPersonal> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compPersonal((TPersonal) i.next(), (TPersonal) j.next());
		}

		Assert.assertTrue(ok);
	}

	@BeforeClass
	public static void populateBBDD() {
		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		daoTurno.CrearTurno(new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true));

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
	public void borrarBD_Personal() {
		TestsBorrarDatos.borrarDatosTabla("Monitores");
		TestsBorrarDatos.borrarDatosTabla("Cocineros");
		TestsBorrarDatos.borrarDatosTabla("Personal");
	}

}
