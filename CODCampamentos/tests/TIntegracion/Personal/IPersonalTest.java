package TIntegracion.Personal;

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
import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class IPersonalTest {

	private boolean compPersonales(TPersonal a, TPersonal b) {
		return a.getIsActivo() == b.getIsActivo() && a.getDNI().equals(b.getDNI())
				&& a.getIdPersonal() == b.getIdPersonal() && a.getNombre().equals(b.getNombre())
				&& a.getTipo() == b.getTipo() && a.getIdTurno() == b.getIdTurno();
	}

	@Test
	public void altaPersonalOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		TPersonal tPersonal = daoPersonal.CrearPersonal(per);

		Assert.assertTrue(compPersonales(per, tPersonal));
	}

	@Test
	public void modificarPersonalOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		daoPersonal.CrearPersonal(per);

		TPersonalCocinero per2 = new TPersonalCocinero(1, "12345678A", "test2", 1, 1, true, "testPuesto", 4);
		TPersonal tPersonal = daoPersonal.ModificarPersonal(per2);

		Assert.assertTrue(compPersonales(per2, tPersonal));
	}

	@Test
	public void eliminarPersonallOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);
		TPersonalCocinero perBaja = new TPersonalCocinero(1, "12345678A", "test", 1, 1, false, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		TPersonal tPersonal = daoPersonal.CrearPersonal(per);
		tPersonal = daoPersonal.EliminarPersonal(per);

		Assert.assertTrue(
				perBaja.getIsActivo() == tPersonal.getIsActivo() && tPersonal.getIdPersonal() == per.getIdPersonal());
	}

	@Test
	public void buscarPersonalDNIOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		TPersonal tPersonal = daoPersonal.CrearPersonal(per);
		tPersonal = daoPersonal.buscarPorDNI(per);

		Assert.assertTrue(compPersonales(per, tPersonal));
	}

	@Test
	public void mostrarPersonalOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		TPersonal tPersonal = daoPersonal.CrearPersonal(per);
		tPersonal = daoPersonal.MostrarUno(per.getIdPersonal());

		Assert.assertTrue(compPersonales(per, tPersonal));
	}

	@Test
	public void activarPersonalOK() {

		TPersonalCocinero perAlta = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		daoPersonal.CrearPersonal(perAlta);
		daoPersonal.EliminarPersonal(perAlta);
		int ok = daoPersonal.activar(perAlta.getIdPersonal());

		Assert.assertTrue(ok == 0);
	}

	@Test
	public void mostrarTodosPersonalsOK() {

		TPersonalCocinero per = new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4);
		TPersonalCocinero per2 = new TPersonalCocinero(41, "12345678B", "test2", 1, 1, true, "testPuesto", 4);

		Set<TPersonal> PersonalsExpected = new HashSet<TPersonal>();
		PersonalsExpected.add(per);
		PersonalsExpected.add(per2);

		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		daoPersonal.CrearPersonal(per);
		daoPersonal.CrearPersonal(per2);
		Set<TPersonal> Personals = daoPersonal.MostrarTodos();

		boolean ok = Personals.size() == PersonalsExpected.size();

		Iterator<TPersonal> i = PersonalsExpected.iterator();
		Iterator<TPersonal> j = PersonalsExpected.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compPersonales((TPersonal) i.next(), (TPersonal) j.next());
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
