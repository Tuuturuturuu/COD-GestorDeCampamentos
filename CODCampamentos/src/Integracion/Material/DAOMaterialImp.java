/**
 * 
 */
package Integracion.Material;

import Negocio.Material.TMaterial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import Integracion.Connection.ConnectorBD;

public class DAOMaterialImp implements DAOMaterial {
	
	@Override
	public TMaterial crearMaterial(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Actividad (idActividad, Nombre, Lugar, NumPlazas, Precio, IdPersonal, Activo) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			// ON DUPLICATE KEY UPDATE activo = ? lo que hace es que si ya
			// existe el ID pone el empleado activo. (ya se ha comprobado en
			// negocio q este inactivo)

			ps.setInt(1, tMaterial.getId());
			ps.setString(2, tMaterial.getNombre());
			ps.setInt(3, tMaterial.getNAlmacen());
			ps.setInt(4, tMaterial.getExistencias());
			ps.setBoolean(7, tMaterial.getActivo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tMaterial.setId(rs.getInt(1));

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tMaterial;
	}

	public Integer eliminarMaterial(Integer id) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer modificarMaterial(TMaterial tMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TMaterial mostrarMaterial(Integer idMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TMaterial> mostrarTodosMateriales() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}