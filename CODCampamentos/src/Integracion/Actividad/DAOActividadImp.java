
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
			// ON DUPLICATE KEY UPDATE activo = ? lo que hace es que si ya
			// existe el ID pone el empleado activo. (ya se ha comprobado en
			// negocio q este inactivo)

			ps.setInt(1, tActividad.getIdActividad());
			ps.setString(2, tActividad.getNombre());
			ps.setInt(3, tActividad.getNumplazas());
			ps.setString(4, tActividad.getLugar());
			ps.setFloat(5, tActividad.getPrecio());
			ps.setInt(6, tActividad.getIdPersonal());
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
	
}