package interfaces;

import datatype.DtProgFormacion;
import datatype.DtUsuario;
import excepciones.ProgramaRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;

public interface IControladorAltaProgFormacion {
	public void ingresarProgFormacion(DtProgFormacion programa) throws ProgramaRepetidoException;
	public void confirmarAltaPrograma();
	public void cancelarAltaPrograma();
}
