/**
 * 
 */
package Negocio.Factura;

public class TLineaFactura {

	public TLineaFactura(Integer idActividad, Integer idFactura, Float precio, Integer cantidad) {
		super();
		this.idActividad = idActividad;
		this.idFactura = idFactura;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public TLineaFactura() {
		// TODO Auto-generated constructor stub
	}

	private Integer idActividad;

	private Integer idFactura;

	private Float precio;

	private Integer cantidad;

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}