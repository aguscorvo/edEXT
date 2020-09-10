package logica;

import datatype.DtProgFormacion;
import interfaces.IControladorAltaProgFormacion;

public class ControladorAltaProgFormacion implements IControladorAltaProgFormacion {
	
	private DtProgFormacion programa;
	
	
	
	public void ingresarProgFormacion(DtProgFormacion programa) {
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		if(mpf.existeProgFormacion(programa.getNombre())) {
			ProgFormacion auxPrograma = mpf.getProgFormacion(programa.getNombre());
			this.programa = programa;
		
		}
		
		
	}
	
	public void confirmarAltaPrograma() {
		
		ProgFormacion auxPF = new ProgFormacion(programa.getNombre(), programa.getDesc(), programa.getFechaI(), programa.getFechaF(), programa.getFechaAlta());
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		mpf.agregarProgFormacion(auxPF);
		
	}
	
	
	public void cancelarAltaPrograma() {}


}
