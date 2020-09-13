package interfaces;
import datatype.DtUsuario;
import excepciones.CorreoRepetidoException;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorAltaUsuario {
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException, CorreoRepetidoException;
	public void confirmarAltaUsuario() throws NoExisteInstitutoException;
	public void cancelarAltaUsuario();
}
