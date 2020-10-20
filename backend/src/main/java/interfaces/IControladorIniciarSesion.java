package interfaces;

import datatype.DtUsuarioLogueado;
import excepciones.ContraseniaIncorrectaException;
import excepciones.NoExisteUsuarioException;

public interface IControladorIniciarSesion {
	public DtUsuarioLogueado iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException, ContraseniaIncorrectaException;
}
