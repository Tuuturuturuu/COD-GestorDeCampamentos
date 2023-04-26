
package Integracion.Actividad;

import Negocio.Actividad.TActividad;
import Negocio.Actividad.TActividadMaterial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
					"INSERT INTO Actividad ( Nombre, Lugar, NumPlazas, Precio, IdPersonal, Activo) VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE Activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, tActividad.getNombre());
			ps.setString(2, tActividad.getLugar());
			ps.setInt(3, tActividad.getNumplazas());
			ps.setFloat(4, tActividad.getPrecio());
			ps.setInt(5, tActividad.getIdPersonal());
			ps.setBoolean(6, tActividad.getActivo());
			ps.setBoolean(7, tActividad.getActivo());
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Actividad SET Nombre = ?, Lugar = ?, NumPlazas = ?, Precio = ?, IdPersonal = ? WHERE idActividad = ? ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, tActividad.getNombre());
			ps.setString(2, tActividad.getLugar());
			ps.setInt(3, tActividad.getNumplazas());
			ps.setFloat(4, tActividad.getPrecio());
			ps.setInt(5, tActividad.getIdPersonal());
			ps.setInt(6, tActividad.getIdActividad());
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			tActividad.setIdActividad(-36);
		}
		return tActividad;
	}

	@Override
	public TActividad borrarActividad(TActividad tActividad) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Actividad SET activo = ? WHERE IdActividad = ?",
					Statement.RETURN_GENERATED_KEYS);
			tActividad.setActivo(false);

			ps.setBoolean(1, tActividad.getActivo());
			ps.setInt(2, tActividad.getIdActividad());
			int result = ps.executeUpdate();
			if (result < 1)
				tActividad.setIdActividad(-15);
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tActividad;
	}

	@Override
	public TActividad mostrarActividad(TActividad tActividad) {
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
				tActividad.setNombre(rs.getString(2));
				tActividad.setLugar(rs.getString(3));
				tActividad.setNumplazas(rs.getInt(4));
				tActividad.setPrecio(rs.getFloat(5));
				tActividad.setIdPersonal(rs.getInt(6));
				tActividad.setActivo(rs.getBoolean(7));
			} else {
				tActividad.setIdActividad(-1);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return tActividad;
	}

	@Override
	public Set<TActividad> mostrarActividades() {
		Set<TActividad> Actividades = new HashSet<TActividad>();
		TActividad e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TActividad(rs.getInt("IdActividad"), rs.getString("Nombre"), rs.getString("lugar"),
						rs.getInt("NumPlazas"),rs.getFloat("Precio"), rs.getInt("IdPersonal"), rs.getBoolean("Activo"));
				Actividades.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return Actividades;
	}

	@Override
	public Set<TActividad> mostrarActividadesporPersonal(Integer IdPersonal) {
		Set<TActividad> ActividadesPersonal = new HashSet<TActividad>();
		TActividad e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE IDPersonal = ?");
			ps.setInt(1, IdPersonal);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TActividad(rs.getInt("IdActividad"), rs.getString("Nombre"), rs.getString("lugar"),
						rs.getInt("NumPlazas"),rs.getFloat("Precio"), rs.getInt("IdPersonal"), rs.getBoolean("Activo"));
				ActividadesPersonal.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return ActividadesPersonal;
	}
	
	public Set<TActividad> mostrarActividadesActivasporPersonal(Integer IdPersonal) {
		Set<TActividad> ActividadesPersonal = new HashSet<TActividad>();
		TActividad e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE IDPersonal = ?");
			ps.setInt(1, IdPersonal);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TActividad(rs.getInt("IdActividad"), rs.getString("Nombre"), rs.getString("lugar"),
						rs.getInt("NumPlazas"),rs.getFloat("Precio"), rs.getInt("IdPersonal"), rs.getBoolean("Activo"));
				if (e.getActivo())
					ActividadesPersonal.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return ActividadesPersonal;
	}

	@Override
	public TActividad buscarActividadID(TActividad tActividad) {
		TActividad tActividadBBDD = new TActividad();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE IdActividad = ?");
			ps.setInt(1, tActividad.getIdActividad());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tActividadBBDD.setIdActividad(rs.getInt(1));
				tActividadBBDD.setNombre(rs.getString(2));
				tActividadBBDD.setLugar(rs.getString(3));
				tActividadBBDD.setNumplazas(rs.getInt(4));
				tActividadBBDD.setPrecio(rs.getFloat(5));
				tActividadBBDD.setIdPersonal(rs.getInt(6));
				tActividadBBDD.setActivo(rs.getBoolean(7));
			} else
				tActividadBBDD.setIdActividad(-1);


			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tActividadBBDD;
	}

	@Override
	public TActividad buscarActividadNombreLugar(TActividad tActividad) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE Nombre = ? AND Lugar = ?");
			ps.setString(1, tActividad.getNombre());
			ps.setString(2, tActividad.getLugar());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tActividad.setIdActividad(rs.getInt(1));
				tActividad.setNombre(rs.getString(2));
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