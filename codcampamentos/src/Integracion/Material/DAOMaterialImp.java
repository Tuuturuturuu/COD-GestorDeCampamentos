/**
 * 
 */
package Integracion.Material;

import Negocio.Actividad.TActividad;
import Negocio.Material.TMaterial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Integracion.Connection.ConnectorBD;

public class DAOMaterialImp implements DAOMaterial {
	public TMaterial crearMaterial(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Material ( Almacen, Nombre, NumExistencias, Activo) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE Activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			

			ps.setInt(1, tMaterial.getNAlmacen());
			ps.setString(2, tMaterial.getNombre());
			ps.setInt(3, tMaterial.getExistencias());
			ps.setBoolean(4, tMaterial.getActivo());
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

	public TMaterial eliminarMaterial(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Material SET activo = ? WHERE IdMaterial = ?",
					Statement.RETURN_GENERATED_KEYS);
			tMaterial.setActivo(false);

			ps.setBoolean(1, tMaterial.getActivo());
			ps.setInt(2, tMaterial.getId());
			int result = ps.executeUpdate();
			if (result < 1)
				tMaterial.setId(-1);
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tMaterial;
	}

	public TMaterial modificarMaterial(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Material SET Almacen = ?, Nombre = ?, NumExistencias = ? WHERE idMaterial = ? ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tMaterial.getNAlmacen());
			ps.setString(2, tMaterial.getNombre());
			ps.setInt(3, tMaterial.getExistencias());
			ps.setInt(4, tMaterial.getIdActividad());
			ps.executeUpdate();

			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tMaterial;
	}

	public TMaterial mostrarMaterial(TMaterial tMaterial) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Material SET Almacen = ?, Nombre = ?, NumExistencias = ? WHERE idMaterial = ? ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tMaterial.getNAlmacen());
			ps.setString(2, tMaterial.getNombre());
			ps.setInt(3, tMaterial.getExistencias());
			ps.setFloat(4, tMaterial.getId());
			ps.executeUpdate();

			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tMaterial;
	}

	public Set<TMaterial> mostrarTodosMateriales() {
		Set<TMaterial> Materiales = new HashSet<TMaterial>();
		TMaterial e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Material");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TMaterial(rs.getInt("IdMaterial"), rs.getString("Nombre"), rs.getInt("Almacen"), 
						rs.getInt("NumExistencias"),0, rs.getBoolean("Activo"));
				Materiales.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return Materiales;
	}
}