package Integracion.Actividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Integracion.Connection.ConnectorBD;
import Negocio.Actividad.TActividadMaterial;

public class DAOActividadMaterialImp implements DAOActividadMaterial {

	public Integer vincular(TActividadMaterial actividadMaterial) {
		Integer correct = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("INSERT INTO ActividadMaterial (idActividad, idMaterial) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, actividadMaterial.getIdActividad());
			ps.setInt(2, actividadMaterial.getIdMaterial());
			int result = ps.executeUpdate();
			if (result == 1)
				correct = 1;
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return correct;
	}

	public Integer desvincular(Integer idActividad, Integer idMaterial) {
		Integer correct = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("DELETE FROM ActividadMaterial WHERE idActividad = ? AND idMaterial = ?;",
					Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, idActividad);
			ps.setInt(2, idMaterial);
			int result = ps.executeUpdate();
			if (result == 1)
				correct = 1;
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return correct;
		// end-user-code
	}

	public Set<TActividadMaterial> BuscarporActividad(Integer idActividad) {
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();
		TActividadMaterial e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM ActividadMaterial WHERE idActividad = ?");
			ps.setInt(1, idActividad);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TActividadMaterial(rs.getInt("idActividad"), rs.getInt("idMaterial"));
				ActividadesMaterial.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return ActividadesMaterial;
	}

	public Set<TActividadMaterial> BuscarporMaterial(Integer idMaterial) {
		Set<TActividadMaterial> ActividadesMaterial = new HashSet<TActividadMaterial>();
		TActividadMaterial e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM ActividadMaterial WHERE idMaterial = ?");
			ps.setInt(1, idMaterial);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TActividadMaterial(rs.getInt("idActividad"), rs.getInt("idMaterial"));
				ActividadesMaterial.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return ActividadesMaterial;
	}

	@Override
	public TActividadMaterial BuscarActividadMaterial(Integer idActividad, Integer idMaterial) {
		// TODO Auto-generated method stub
		return null;
	}

}