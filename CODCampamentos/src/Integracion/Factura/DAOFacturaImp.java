package Integracion.Factura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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

	public TFactura devolverFactura(TFactura tfactura) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Factura SET activo = ? WHERE idFactura = ?",
					Statement.RETURN_GENERATED_KEYS);
			tfactura.setActivo(true);

			ps.setBoolean(1, tfactura.getActivo());
			ps.setInt(2, tfactura.getIdFactura());
			int result = ps.executeUpdate();
			if (result < 1)
				tfactura.setIdFactura(-15);
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tfactura;
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
		Set<TFactura> Facturas = new HashSet<TFactura>();
		TFactura e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Factura");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TFactura(rs.getInt("idFactura"), rs.getInt("idCliente"), rs.getDate("fecha"),
						rs.getFloat("Total"), rs.getBoolean("Activo"));
				Facturas.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return Facturas;
	}

}