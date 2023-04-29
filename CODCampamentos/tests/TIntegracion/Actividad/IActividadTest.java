package TIntegracion.Actividad;

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
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class IActividadTest {

	private boolean compActividades(TActividad a, TActividad b) {
		return a.getActivo() == b.getActivo() && a.getNumplazas() == b.getNumplazas()
				&& a.getPrecio().equals(b.getPrecio()) && a.getIdActividad() == b.getIdActividad()
				&& a.getLugar().equals(b.getLugar()) && a.getNombre().equals(b.getNombre());
	}

	@Test
	public void altaActividadOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		TActividad tActividad = daoActividad.crearActividad(act);

		Assert.assertTrue(act.equals(tActividad));
	}

	@Test
	public void modificarActividadOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoActividad.crearActividad(act);

		TActividad act2 = new TActividad(1, "test2", "lugarTest", 10, Float.parseFloat("9"), 1, true);
		TActividad tActividad = daoActividad.modificarActividad(act2);

		Assert.assertTrue(compActividades(act2, tActividad));
	}

	@Test
	public void eliminarActividadlOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);
		TActividad actBaja = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, false);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		TActividad tActividad = daoActividad.crearActividad(act);
		tActividad = daoActividad.borrarActividad(act);

		Assert.assertTrue(actBaja.getActivo() == tActividad.getActivo() && tActividad.getIdActividad() == 1);
	}

	@Test
	public void buscarActividadLugarOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		TActividad tActividad = daoActividad.crearActividad(act);
		tActividad = daoActividad.buscarActividadNombreLugar(act);

		Assert.assertTrue(compActividades(act, tActividad));
	}

	@Test
	public void buscarActividadIDOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		TActividad tActividad = daoActividad.crearActividad(act);
		tActividad = daoActividad.buscarActividadID(act);

		Assert.assertTrue(compActividades(act, tActividad));
	}

	@Test
	public void mostrarActividadOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		TActividad tActividad = daoActividad.crearActividad(act);
		tActividad = daoActividad.mostrarActividad(act);

		Assert.assertTrue(compActividades(act, tActividad));
	}

	@Test
	public void activarActividadOK() {

		TActividad actAlta = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoActividad.crearActividad(actAlta);
		daoActividad.borrarActividad(actAlta);
		int ok = daoActividad.activar(actAlta.getIdActividad());

		Assert.assertTrue(ok == 0);
	}

	@Test
	public void mostrarTodosActividadsOK() {

		TActividad act = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		Set<TActividad> ActividadsExpected = new HashSet<TActividad>();
		ActividadsExpected.add(act);

		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoActividad.crearActividad(act);
		Set<TActividad> Actividads = daoActividad.mostrarActividades();

		boolean ok = Actividads.size() == ActividadsExpected.size();

		Iterator<TActividad> i = ActividadsExpected.iterator();
		Iterator<TActividad> j = ActividadsExpected.iterator();

		while (ok && i.hasNext() && j.hasNext()) {
			ok = compActividades((TActividad) i.next(), (TActividad) j.next());
		}

		Assert.assertTrue(ok);

	}

	@BeforeClass
	public static void populateBBDD() {
		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		daoTurno.CrearTurno(new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true));
		daoPersonal.CrearPersonal(new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4));

	}

	@AfterClass
	public static void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("Actividad");
		TestsBorrarDatos.borrarDatosTabla("Monitores");
		TestsBorrarDatos.borrarDatosTabla("Cocineros");
		TestsBorrarDatos.borrarDatosTabla("Personal");
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

	@After
	public void borrarBD_Actividad() {
		TestsBorrarDatos.borrarDatosTabla("Actividad");
	}
}
