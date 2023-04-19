package Presentacion.FactoriaPresentacion;


import Presentacion.Material.VistaMaterialGeneral;

public class FactoriaVistaMaterialImp implements FactoriaVistaMaterial {

	@Override
	public VistaMaterialGeneral getVista_VistaMaterialGeneral() {
		
		return new VistaMaterialGeneral();
	}

}
