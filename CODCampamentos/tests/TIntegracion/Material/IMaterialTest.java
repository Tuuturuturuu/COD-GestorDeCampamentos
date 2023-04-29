package TIntegracion.Material;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Integracion.Connection.TestsBorrarDatos;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Material.DAOMaterial;
import Negocio.Material.TMaterial;

public class IMaterialTest {

	private boolean compMateriales(TMaterial a, TMaterial b) {
		return a.getActivo() == b.getActivo() && a.getExistencias() == b.getExistencias() && a.getId() == b.getId()
				&& a.getNAlmacen() == b.getNAlmacen() && a.getNombre().equals(b.getNombre());
	}

	@Test
	public void altaMaterialOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		TMaterial tMaterial = daoMaterial.crearMaterial(mat);

		Assert.assertTrue(mat.equals(tMaterial));
	}

	@Test
	public void modificarMaterialOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		daoMaterial.crearMaterial(mat);

		TMaterial mat2 = new TMaterial(1, "test2", 1, 12, 1, true);
		TMaterial tMaterial = daoMaterial.modificarMaterial(mat2);

		Assert.assertTrue(mat2.equals(tMaterial));
	}

	@Test
	public void eliminarMaterialOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);
		TMaterial matBaja = new TMaterial(1, "test", 1, 10, 1, false);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		TMaterial tMaterial = daoMaterial.crearMaterial(mat);
		tMaterial = daoMaterial.eliminarMaterial(mat);

		Assert.assertTrue(matBaja.getActivo() == tMaterial.getActivo() && tMaterial.getId() == mat.getId());
	}

	@Test
	public void buscarMaterialIDOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		TMaterial tMaterial = daoMaterial.crearMaterial(mat);
		tMaterial = daoMaterial.buscarMaterialID(tMaterial);

		Assert.assertTrue(mat.equals(tMaterial));
	}

	@Test
	public void buscarMaterialNombreOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		TMaterial tMaterial = daoMaterial.crearMaterial(mat);
		tMaterial = daoMaterial.buscarMaterialNombre(tMaterial);

		Assert.assertTrue(compMateriales(mat, tMaterial));
	}

	@Test
	public void mostrarMaterialOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		TMaterial tMaterial = daoMaterial.crearMaterial(mat);
		tMaterial = daoMaterial.mostrarMaterial(mat);

		Assert.assertTrue(mat.equals(tMaterial));
	}

	@Test
	public void activarMaterialOK() {

		TMaterial matAlta = new TMaterial(1, "test", 1, 10, 1, true);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		daoMaterial.crearMaterial(matAlta);
		daoMaterial.eliminarMaterial(matAlta);
		int ok = daoMaterial.activar(matAlta.getId());

		Assert.assertTrue(ok == 0);
	}

	@Test
	public void mostrarTodosMaterialOK() {

		TMaterial mat = new TMaterial(1, "test", 1, 10, 1, true);

		Set<TMaterial> materialesExpected = new HashSet<TMaterial>();
		materialesExpected.add(mat);

		DAOMaterial daoMaterial = FactoriaIntegracionImp.obtenerInstancia().generaDAOMaterial();
		daoMaterial.crearMaterial(mat);
		Set<TMaterial> materiales = daoMaterial.mostrarTodosMateriales();

		boolean ok = materiales.size() == materialesExpected.size();

		Iterator<TMaterial> i = materialesExpected.iterator();
		Iterator<TMaterial> j = materiales.iterator();

		while (i.hasNext() && j.hasNext()) {
			ok = compMateriales((TMaterial) i.next(), (TMaterial) j.next());
		}

		Assert.assertTrue(ok);

	}

	@After
	public void borrarBD() {
		TestsBorrarDatos.borrarDatosTabla("Material");
	}

}
