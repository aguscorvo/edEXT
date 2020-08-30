package interfaces;
import datatype.DtUsuario;
import excepciones.UsuarioRepetidoException;

public interface IControladorAltaUsuario {
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException;
	public void confirmarAltaUsuario();
	public void cancelarAltaUsuario();
}
