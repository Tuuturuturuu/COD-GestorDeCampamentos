/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import Integracion.Connection.ConnectorBD;
import Negocio.Factura.TFactura;

public class DAOFacturaImp implements DAOFactura {

	public TFactura cerrarFactura(TFactura tFactura) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Factura ( idCliente, fecha, total, Activo) VALUES (?,DATE_FORMAT(NOW(), '%Y-%m-%d'),?,?) ON DUPLICATE KEY UPDATE Activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tFactura.getIdCliente());
			ps.setFloat(2, tFactura.getTotal());
			ps.setBoolean(3, tFactura.getActivo());
			ps.setBoolean(4, tFactura.getActivo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tFactura.setIdFactura(rs.getInt(1));

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return tFactura;
	}

	public Integer modificarFactura(TFactura tfactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TFactura mostrarFactura(TFactura tfactura) {
		TFactura tFactura = new TFactura();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Factura WHERE idFactura = ?");
			ps.setInt(1, tfactura.getIdFactura());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tFactura.setIdFactura(rs.getInt(1));
				tFactura.setIdCliente(rs.getInt(2));
				tFactura.setFecha(rs.getDate(3));
				tFactura.setTotal(rs.getFloat(4));
				tFactura.setActivo(rs.getBoolean(5));
			} else {
				tFactura.setIdFactura(-1);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tFactura;
	}

	public Set<TFactura> mostrarFacturas() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TFactura> mostrarFacturasporCliente(Integer idCliente) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}