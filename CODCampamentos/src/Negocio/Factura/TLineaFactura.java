/**
 * 
 */
package Negocio.Factura;

public class TLineaFactura {

	private Integer idActividad;

	private Integer idFactura;

	private Float precio;

	private Integer cantidad;

	private TCarrito tFacturaConActividades;

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

	public TCarrito gettFacturaConActividades() {
		return tFacturaConActividades;
	}

	public void settFacturaConActividades(TCarrito tFacturaConActividades) {
		this.tFacturaConActividades = tFacturaConActividades;
	}

}