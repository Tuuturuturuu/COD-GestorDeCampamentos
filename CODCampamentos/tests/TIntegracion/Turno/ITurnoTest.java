package TIntegracion.Turno;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Turno.DAOTurno;
import Negocio.Turno.TTurno;

public class ITurnoTest {

	private boolean compTurnos(TTurno a, TTurno b) {
		return a.getActivo() == b.getActivo() && a.getHora().equals(b.getHora()) && a.getIdTurno() == b.getIdTurno()
				&& a.getFecha().equals(b.getFecha()) && a.getNombreTurno().equals(b.getNombreTurno());
	}

	@Test
	public void altaTurnoOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		TTurno tTurno = daoTurno.CrearTurno(tur);

		Assert.assertTrue(tur.equals(tTurno));
	}

	@Test
	public void modificarTurnoOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		daoTurno.CrearTurno(tur);

		TTurno tur2 = new TTurno(1, "test2", Date.valueOf("2024-02-23"), "09:40", true);
		TTurno tTurno = daoTurno.ModificarTurno(tur2);

		Assert.assertTrue(compTurnos(tur2, tTurno));
	}

	@Test
	public void eliminarTurnolOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);
		TTurno turBaja = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", false);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		TTurno tTurno = daoTurno.CrearTurno(tur);
		tTurno = daoTurno.EliminarTurno(tur);

		Assert.assertTrue(turBaja.getActivo() == tTurno.getActivo() && tTurno.getIdTurno() == 1);
	}

	@Test
	public void buscarTurnoIDOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		TTurno tTurno = daoTurno.CrearTurno(tur);
		tTurno = daoTurno.BuscarTurnoPorNombre(tur.getNombreTurno());

		Assert.assertTrue(compTurnos(tur, tTurno));
	}

	@Test
	public void buscarTurnoNombreOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		TTurno tTurno = daoTurno.CrearTurno(tur);
		tTurno = daoTurno.BuscarTurnoPorNombre(tTurno.getNombreTurno());

		Assert.assertTrue(compTurnos(tur, tTurno));
	}

	@Test
	public void mostrarTurnoOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		TTurno tTurno = daoTurno.CrearTurno(tur);
		tTurno = daoTurno.MostrarTurno(tur.getIdTurno());

		Assert.assertTrue(compTurnos(tur, tTurno));
	}

	@Test
	public void activarTurnoOK() {

		TTurno turAlta = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		daoTurno.CrearTurno(turAlta);
		daoTurno.EliminarTurno(turAlta);
		int ok = daoTurno.activar(turAlta.getIdTurno());

		Assert.assertTrue(ok == 0);
	}

	@Test
	public void mostrarTodosTurnosOK() {

		TTurno tur = new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true);
		TTurno tur2 = new TTurno(1, "test2", Date.valueOf("2026-01-20"), "11:38", true);

		Set<TTurno> turnosExpected = new HashSet<TTurno>();
		turnosExpected.add(tur);
		turnosExpected.add(tur2);

		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		daoTurno.CrearTurno(tur);
		daoTurno.CrearTurno(tur2);
		Set<TTurno> turnos = daoTurno.MostrarAllTurnos();

		boolean ok = true;

		Iterator<TTurno> i = turnosExpected.iterator();
		Iterator<TTurno> j = turnosExpected.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compTurnos((TTurno) i.next(), (TTurno) j.next());
		}

		Assert.assertTrue(ok && turnos.size() == turnosExpected.size());

	}

	@After
	public void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

}
