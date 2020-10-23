package interfaces;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;

public interface IControladorAltaUsuario {
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException;
	public void ingresarDtUsuarioFrontEnd(DtUsuario usuario) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail;
	public void confirmarAltaUsuario() throws NoExisteInstitutoException;
	public void cancelarAltaUsuario();
	public String[] getInstitutos();
}
