package Negocio.Factura;

public class TLineaFactura {

	private Integer idActividad;

	private Integer idFactura;

	private Integer cantidad;

	private Float precio;

	public TLineaFactura(Integer idActividad, Integer idFactura, Integer cantidad, Float precio) {

	}

	public TLineaFactura() {

	}

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