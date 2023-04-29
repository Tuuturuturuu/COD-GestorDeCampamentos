package TNegocio.Actividad;

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
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.Actividad.SAActividad;
import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class NActividadTest {

	private boolean compActividades(TActividad a, TActividad b) {
		return a.getActivo() == b.getActivo() && a.getNumplazas() == b.getNumplazas()
				&& a.getPrecio().equals(b.getPrecio()) && a.getIdActividad() == b.getIdActividad()
				&& a.getLugar().equals(b.getLugar()) && a.getNombre().equals(b.getNombre());
	}

	@Test
	public void crearActividadOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();
		TActividad exp = new TActividad(0, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		TActividad act = saActividad.crearActividad(exp);

		Assert.assertTrue(compActividades(exp, act));
	}

	@Test
	public void eliminarActividadOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();
		TActividad aux = new TActividad(0, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);
		TActividad exp = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, false);

		TActividad act = saActividad.crearActividad(aux);
		act = saActividad.borrarActividad(act);

		Assert.assertTrue(compActividades(exp, act));
	}

	@Test
	public void modificarActividadOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();
		TActividad aux = new TActividad(0, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);
		TActividad exp = new TActividad(1, "testNuevoNombre", "testNuevoLugar", 50, Float.parseFloat("8"), 1, true);

		TActividad act = saActividad.crearActividad(aux);
		act = saActividad.modificarActividad(
				(new TActividad(1, "testNuevoNombre", "testNuevoLugar", 50, Float.parseFloat("8"), 1, true)));

		Assert.assertTrue(compActividades(exp, act));
	}

	@Test
	public void mostrarActividadOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();
		TActividad exp = new TActividad(0, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);

		TActividad act = saActividad.crearActividad(exp);
		act = saActividad.mostrarActividad(act);

		Assert.assertTrue(compActividades(exp, act));
	}

	@Test
	public void mostrarTodosActividadOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();

		TActividad aux1 = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);
		Set<TActividad> exp = new HashSet<TActividad>();
		exp.add(aux1);

		saActividad.crearActividad(aux1);
		Set<TActividad> act = saActividad.mostrarActividades();

		boolean ok = exp.size() == act.size();

		Iterator<TActividad> i = exp.iterator();
		Iterator<TActividad> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compActividades((TActividad) i.next(), (TActividad) j.next());
		}

		Assert.assertTrue(ok);
	}

	@Test
	public void mostrarActividadPorPersonalOK() {
		SAActividad saActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad();

		int idPers = 1;
		TActividad aux1 = new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true);
		Set<TActividad> exp = new HashSet<TActividad>();
		exp.add(aux1);

		saActividad.crearActividad(aux1);
		Set<TActividad> act = saActividad.mostrarActividadesporPersonal(idPers);

		boolean ok = exp.size() == act.size();

		Iterator<TActividad> i = exp.iterator();
		Iterator<TActividad> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
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
