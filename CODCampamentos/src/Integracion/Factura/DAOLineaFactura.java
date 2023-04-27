/**
 * 
 */
package Integracion.Factura;

import Negocio.Factura.TGenera;
import java.util.Set;

public interface DAOLineaFactura {

	public Integer generar(TGenera tgenera);
	public Integer desgenerar(Integer idFactura, Integer idActividad);
	public Integer modificarGenera(TGenera tgenera);
	public TGenera mostrarGenera(Integer idActividad, Integer idFactura);
	public Set<TGenera> mostrarAllGenera();
	public TGenera mostrarGeneraPorActividad(Integer idActividad);
	public TGenera mostrarGeneraPorFactura(Integer idFactura);
}