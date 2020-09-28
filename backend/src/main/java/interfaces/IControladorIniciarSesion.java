package interfaces;

import excepciones.ContraseniaIncorrectaException;
import excepciones.NoExisteUsuarioException;

public interface IControladorIniciarSesion {
	public String iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException, ContraseniaIncorrectaException;
}
