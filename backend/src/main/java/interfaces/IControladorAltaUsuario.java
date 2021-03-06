package interfaces;
import datatype.DtDocente;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;
import datatype.DtEstudiante;

public interface IControladorAltaUsuario {
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException;
	public void ingresarDtUsuarioFrontEnd(DtUsuario usuario) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail;
	public void ingresarDtEstudianteFrontEnd(DtEstudiante estudiante) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail;
	public void ingresarDtDocenteFrontEnd(DtDocente estudiante) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail;
	public void confirmarAltaUsuario() throws NoExisteInstitutoException;
	public void cancelarAltaUsuario();
	public String[] getInstitutos();
	public boolean existeUsuarioNick(String nick);
	public boolean existeUsuarioCorreo(String correo);
}
