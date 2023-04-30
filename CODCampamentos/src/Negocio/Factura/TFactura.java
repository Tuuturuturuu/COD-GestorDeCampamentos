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
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public TCarrito gettFacturaConActividades() {
		return tFacturaConActividades;
	}

	public void settFacturaConActividades(TCarrito tFacturaConActividades) {
		this.tFacturaConActividades = tFacturaConActividades;
	}

	@Override
	public String toString() {
		return "idFactura=" + idFactura + ", \nidCliente=" + idCliente + ", \nfecha=" + fecha + ", \ntotal=" + total
				+ ", Devuelto=" + activo;
	}

}