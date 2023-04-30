/**
 * 
 */
package Integracion.Factura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Integracion.Connection.ConnectorBD;
import Negocio.Factura.TLineaFactura;

public class DAOLineaFacturaImp implements DAOLineaFactura {

	public Integer crearLineaFactura(TLineaFactura tLinea) {
		Integer correct = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO TLineaFactura ( idFactura, idActividad, precio, cantidad) VALUES (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, tLinea.getIdFactura());
			ps.setInt(2, tLinea.getIdActividad());
			ps.setFloat(3, tLinea.getPrecio());
			ps.setInt(4, tLinea.getCantidad());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				correct = 1;

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return correct;
	}

	public Integer eliminarLineaFactura(Integer idFactura, Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer modificarLineaFactura(TLineaFactura tLinea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TLineaFactura mostrarLineaFactura(Integer idActividad, Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TLineaFactura> mostrarAllLineaFacturas() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TLineaFactura mostrarLineaFacturaPorActividad(Integer idActividad) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TLineaFactura> mostrarLineaFacturaPorFactura(Integer idFactura) {

		Set<TLineaFactura> LineasFacturas = new HashSet<TLineaFactura>();
		TLineaFactura e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM TLineaFactura WHERE idFactura = ?");
			ps.setInt(1, idFactura);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TLineaFactura(rs.getInt("idActividad"), rs.getInt("idFactura"), rs.getFloat("precio"),
						rs.getInt("Cantidad"));
				LineasFacturas.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return LineasFacturas;
	}
}