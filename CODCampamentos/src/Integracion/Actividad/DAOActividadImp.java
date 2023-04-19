
package Integracion.Actividad;

import Negocio.Actividad.TActividad;
import Negocio.Actividad.TActividadMaterial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import Integracion.Connection.ConnectorBD;


public class DAOActividadImp implements DAOActividad {

	@Override
	public TActividad crearActividad(TActividad tActividad) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Actividad (idActividad, Nombre, Lugar, NumPlazas, Precio, IdPersonal, Activo) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			

			ps.setString(1, tActividad.getNombre());
			ps.setInt(2, tActividad.getNumplazas());
			ps.setString(3, tActividad.getLugar());
			ps.setFloat(4, tActividad.getPrecio());
			ps.setInt(5, tActividad.getIdPersonal());
			ps.setBoolean(6, tActividad.getActivo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tActividad.setIdActividad(rs.getInt(1));

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tActividad;
	}

	@Override
	public TActividad modificarActividad(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad borrarActividad(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad mostrarActividad(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostrarActividades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostrarActividadesporPersonal(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad activar(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad vincularActividadMaterial(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad desvincularActividadMaterial(TActividadMaterial tActividadMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TActividad> mostrarActividadporMaterial(TActividad tActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TActividad buscarActividadID(TActividad tActividad) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE IdActividad = ?");
			ps.setInt(1, tActividad.getIdActividad());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				tActividad.setIdActividad(rs.getInt(1));
				tActividad.setNombre(rs.getString(1));
				tActividad.setLugar(rs.getString(3));
				tActividad.setNumplazas(rs.getInt(4));
				tActividad.setPrecio(rs.getFloat(5));
				tActividad.setIdPersonal(rs.getInt(6));
				tActividad.setActivo(rs.getBoolean(7));
			} else
				tActividad.setIdActividad(-1);


			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tActividad;
	}
	
}