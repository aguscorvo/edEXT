package interfaces;

import datatype.DtProgFormacion;
import excepciones.ProgramaRepetidoException;

public interface IControladorAltaProgFormacion {
	public void ingresarProgFormacion(DtProgFormacion programa) throws ProgramaRepetidoException;
	public void confirmarAltaPrograma();
	public void cancelarAltaPrograma();
}
