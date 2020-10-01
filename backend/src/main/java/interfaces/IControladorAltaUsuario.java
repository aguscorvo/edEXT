package interfaces;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorAltaUsuario {
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException;
	public void confirmarAltaUsuario() throws NoExisteInstitutoException;
	public void cancelarAltaUsuario();
	public String[] getInstitutos();
}
