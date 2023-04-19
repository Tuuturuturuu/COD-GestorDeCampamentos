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
	
	public TMaterial crearMaterial(TMaterial tMaterial) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
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
	
	@Override
	public TMaterial buscarMaterialID(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Material WHERE IdMaterial = ?");
			ps.setInt(1, tMaterial.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				//TODO ENEL ORDEN DE LABBDD???
				tMaterial.setId(rs.getInt(1));
				tMaterial.setNombre(rs.getString(1));
				tMaterial.setNAlmacen(rs.getInt(3));
				tMaterial.setExistencias(rs.getInt(9));
				tMaterial.setIdActividad(rs.getInt(6));
				tMaterial.setActivo(rs.getBoolean(7));
			} else
				tMaterial.setIdActividad(-1);


			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tMaterial;
	}
}