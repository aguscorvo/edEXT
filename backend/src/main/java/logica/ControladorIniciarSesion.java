package logica;

import java.util.List;

import excepciones.ContraseniaIncorrectaException;
import excepciones.NoExisteUsuarioException;
import datatype.DtUsuarioLogueado;
import interfaces.IControladorIniciarSesion;

public class ControladorIniciarSesion implements IControladorIniciarSesion{
	public DtUsuarioLogueado  iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		String tipo = "";
		String nick = nickOEmail;
		String correo = nickOEmail;
		String  password= contraseña;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		DtUsuarioLogueado usuarioLogueado = null;
		
		if (mU.existeUsuarioNick(nick)) {
			Usuario auxUsuario = mU.getUsuario(nick);
			if (auxUsuario.getPassword().equals(password)) {
				
				if (auxUsuario instanceof Docente) {
					tipo="docente";
				}
				else if(auxUsuario instanceof Estudiante) {
					tipo="estudiante";
				}	
				usuarioLogueado= new DtUsuarioLogueado (auxUsuario.getNick(), tipo, auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getFechaNac(), auxUsuario.getPassword());
			}			
			else {
				throw new ContraseniaIncorrectaException("La contraseña ingresada no es correcta");
			}
		}
		else if (mU.existeUsuarioCorreo(correo)) {
			List<Usuario> usuarios = mU.getUsuarios();
			for (Usuario u: usuarios) {
				if (u.getCorreo().equals(correo)) {
					if (u.getPassword().equals(password)) {	
						
						if (u instanceof Docente) {
							tipo="docente";
						}
						else if(u instanceof Estudiante) {
							tipo="estudiante";
						}	
						usuarioLogueado= new DtUsuarioLogueado (u.getNick(), tipo, u.getNombre(), u.getApellido(), u.getFechaNac(), u.getPassword());

					}
					else {
						throw new ContraseniaIncorrectaException("La contraseña ingresada no es correcta");
					}
				}
			}	
		}
		else if (!mU.existeUsuarioCorreo(correo) && !mU.existeUsuarioNick(nick))
			throw new NoExisteUsuarioException ("No existe un usuario con los datos ingresados en el sistema.\n");
		
		return usuarioLogueado;
	}


}
