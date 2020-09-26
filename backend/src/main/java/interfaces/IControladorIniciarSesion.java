package interfaces;

import excepciones.NoExisteUsuarioException;

public interface IControladorIniciarSesion {
	public String iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException;
}
