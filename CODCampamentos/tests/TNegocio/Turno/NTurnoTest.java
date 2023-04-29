package TNegocio.Turno;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Integracion.Connection.TestsBorrarDatos;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Turno.SATurno;
import Negocio.Turno.TTurno;

public class NTurnoTest {

	private boolean compTurnos(TTurno a, TTurno b) {
		return a.getActivo() == b.getActivo() && a.getFecha().equals(b.getFecha()) && a.getHora().equals(b.getHora())
				&& a.getIdTurno() == b.getIdTurno() && a.getNombreTurno().equals(b.getNombreTurno());
	}

	@Test
	public void crearTurnoOK() {
		SATurno saTurno = FactoriaSAImp.obtenerInstancia().generarSATurno();
		TTurno exp = new TTurno(0, "test", Date.valueOf("2023-02-23"), "09:30", true);

		TTurno act = saTurno.crearTurno(exp);

		Assert.assertTrue(compTurnos(exp, act));
	}

	@Test
	public void eliminarTurnoOK() {
		SATurno saTurno = FactoriaSAImp.obtenerInstancia().generarSATurno();
		TTurno aux = new TTurno(0, "test", Date.valueOf("2023-02-23"), "09:30", true);
		TTurno exp = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", false);

		TTurno act = saTurno.crearTurno(aux);
		act = saTurno.BorrarTurno(act);

		Assert.assertTrue(compTurnos(exp, act));
	}

	@Test
	public void modificarTurnoOK() {
		SATurno saTurno = FactoriaSAImp.obtenerInstancia().generarSATurno();
		TTurno aux = new TTurno(0, "test", Date.valueOf("2023-02-23"), "09:30", true);
		TTurno exp = new TTurno(1, "testNuevoNombre", Date.valueOf("2025-03-22"), "10:20", true);

		TTurno act = saTurno.crearTurno(aux);
		act = saTurno.ModificarTurno((new TTurno(1, "testNuevoNombre", Date.valueOf("2025-03-22"), "10:20", true)));

		Assert.assertTrue(compTurnos(exp, act));
	}

	@Test
	public void mostrarTurnoOK() {
		SATurno saTurno = FactoriaSAImp.obtenerInstancia().generarSATurno();
		TTurno exp = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		TTurno act = saTurno.crearTurno(exp);
		act = saTurno.MostrarTurno(act);

		Assert.assertTrue(compTurnos(exp, act));
	}

	@Test
	public void mostrarTodosTurnoOK() {
		SATurno saTurno = FactoriaSAImp.obtenerInstancia().generarSATurno();

		TTurno aux1 = new TTurno(0, "test", Date.valueOf("2023-02-23"), "09:30", true);
		Set<TTurno> exp = new HashSet<TTurno>();
		exp.add(aux1);

		saTurno.crearTurno(aux1);
		Set<TTurno> act = saTurno.MostrarTurnos();

		boolean ok = exp.size() == act.size();

		Iterator<TTurno> i = exp.iterator();
		Iterator<TTurno> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compTurnos((TTurno) i.next(), (TTurno) j.next());
		}

		Assert.assertTrue(ok);
	}

	@After
	public void borrarBD_Turno() {
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

}
