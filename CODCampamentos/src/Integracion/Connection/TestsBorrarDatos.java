package Integracion.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestsBorrarDatos {

	public static void borrarDatosTabla(String nombreTabla) {

		try {
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;

			// ps = conexion.prepareStatement("TRUNCATE TABLE " + nombreTabla);
			ps = conexion.prepareStatement("DELETE FROM " + nombreTabla);
			ps.execute();

			ps = conexion.prepareStatement("ALTER TABLE " + nombreTabla + " AUTO_INCREMENT = 1");
			ps.execute();

			ps.close();
			conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
