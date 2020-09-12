package logica;

import datatype.DtProgFormacion;
import excepciones.ProgramaRepetidoException;
import interfaces.IControladorAltaProgFormacion;

public class ControladorAltaProgFormacion implements IControladorAltaProgFormacion {
	
	private DtProgFormacion programa;
	
	
	
	public void ingresarProgFormacion(DtProgFormacion programa) throws ProgramaRepetidoException {
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		if(mpf.existeProgFormacion(programa.getNombre())) 
			throw new ProgramaRepetidoException("Ya existe un programa con nombre '" + programa.getNombre() + "' registrado en el sistema.\n");
		else {
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
