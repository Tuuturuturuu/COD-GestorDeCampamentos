/**
 * 
 */
package Negocio.Factura;

import java.util.Date;

public class TFactura {
	public TFactura(Integer idFactura, Integer idCliente, Date fecha, Float total, Boolean activo,
			TCarrito tFacturaConActividades) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.total = total;
		this.activo = activo;
		this.tFacturaConActividades = tFacturaConActividades;
	}

	public TFactura() {
		// TODO Auto-generated constructor stub
	}

	private Integer idFactura;
	private Integer idCliente;
	private Date fecha;
	private Float total;
	private Boolean activo;
	private TCarrito tFacturaConActividades;

	public Integer getIdFactura() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer getIdCliente() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Date getFecha() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Float getTotal() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Boolean getActivo() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer setIdFactura(Integer idFactura) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer setIdCliente(Integer idCliente) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer setFecha(Date fecha) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer setTotal(Float total) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer setActivo(Boolean activo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}