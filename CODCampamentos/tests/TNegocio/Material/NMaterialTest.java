package TNegocio.Material;

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
import Negocio.Material.SAMaterial;
import Negocio.Material.TMaterial;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Turno.TTurno;

public class NMaterialTest {

	private boolean compMateriales(TMaterial a, TMaterial b) {
		return a.getActivo() == b.getActivo() && a.getExistencias() == b.getExistencias() && a.getId() == b.getId()
				&& a.getNAlmacen() == b.getNAlmacen() && a.getNombre().equals(b.getNombre());
	}

	@Test
	public void crearMaterialOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();
		TMaterial exp = new TMaterial(0, "test", 1, 10, 1, true);

		TMaterial act = saMaterial.crearMaterial(exp);

		Assert.assertTrue(compMateriales(exp, act));
	}

	@Test
	public void eliminarMaterialOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();
		TMaterial aux = new TMaterial(0, "test", 1, 10, 1, true);
		TMaterial exp = new TMaterial(1, "test", 1, 10, 1, false);

		TMaterial act = saMaterial.crearMaterial(aux);
		act = saMaterial.eliminarMaterial(act);

		Assert.assertTrue(compMateriales(exp, act));
	}

	@Test
	public void modificarMaterialOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();
		TMaterial aux = new TMaterial(0, "test", 1, 10, 1, true);
		TMaterial exp = new TMaterial(1, "testNuevoNombre", 2, 20, 1, true);

		TMaterial act = saMaterial.crearMaterial(aux);
		act = saMaterial.modificarMaterial(new TMaterial(1, "testNuevoNombre", 2, 20, 0, true));

		Assert.assertTrue(compMateriales(exp, act));
	}

	@Test
	public void mostrarMaterialOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();
		TMaterial exp = new TMaterial(0, "test", 1, 10, 1, true);

		TMaterial act = saMaterial.crearMaterial(exp);
		act = saMaterial.mostrarMaterial(exp);

		Assert.assertTrue(compMateriales(exp, act));
	}

	@Test
	public void vincularMaterialActividadOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();
		TMaterial exp = new TMaterial(0, "test", 1, 10, 1, true);

		TMaterial act = saMaterial.crearMaterial(exp);
		act = saMaterial.vincularMaterialActividad(exp);

		Assert.assertTrue(compMateriales(exp, act));
	}

	@Test
	public void mostrarMaterialPorActividadOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();

		int idAct = 1;
		TMaterial aux1 = new TMaterial(0, "test", 1, 10, idAct, true);
		Set<TMaterial> exp = new HashSet<TMaterial>();
		exp.add(aux1);

		saMaterial.crearMaterial(aux1);
		saMaterial.vincularMaterialActividad(aux1);
		Set<TMaterial> act = saMaterial.listarMaterialPorActividad(idAct);

		boolean ok = exp.size() == act.size();

		Iterator<TMaterial> i = exp.iterator();
		Iterator<TMaterial> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compMateriales((TMaterial) i.next(), (TMaterial) j.next());
		}

		Assert.assertTrue(ok);
	}

	@Test
	public void mostrarTodosMaterialOK() {
		SAMaterial saMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial();

		int idAct = 1;
		TMaterial aux1 = new TMaterial(0, "test", 1, 10, idAct, true);
		Set<TMaterial> exp = new HashSet<TMaterial>();
		exp.add(aux1);

		saMaterial.crearMaterial(aux1);
		Set<TMaterial> act = saMaterial.mostrarTodosMateriales();

		boolean ok = exp.size() == act.size();

		Iterator<TMaterial> i = exp.iterator();
		Iterator<TMaterial> j = act.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compMateriales((TMaterial) i.next(), (TMaterial) j.next());
		}

		Assert.assertTrue(ok);
	}

	@BeforeClass
	public static void populateBBDD() {
		DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
		DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
		DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
		daoTurno.CrearTurno(new TTurno(1, "test", Date.valueOf("2023-02-23"), "09:30", true));
		daoPersonal.CrearPersonal(new TPersonalCocinero(1, "12345678A", "test", 1, 1, true, "testPuesto", 4));
		daoActividad.crearActividad(new TActividad(1, "test", "lugarTest", 10, Float.parseFloat("5"), 1, true));

	}

	@AfterClass
	public static void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("ActividadMaterial");
		TestsBorrarDatos.borrarDatosTabla("Actividad");
		TestsBorrarDatos.borrarDatosTabla("Monitores");
		TestsBorrarDatos.borrarDatosTabla("Cocineros");
		TestsBorrarDatos.borrarDatosTabla("Personal");
		TestsBorrarDatos.borrarDatosTabla("Turno");
	}

	@After
	public void borrarBD_Actividad() {
		TestsBorrarDatos.borrarDatosTabla("Material");
	}

}
