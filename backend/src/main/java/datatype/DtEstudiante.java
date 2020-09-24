package datatype;

import java.util.Date;

public class DtEstudiante extends DtUsuario {
	
	public DtEstudiante() {
		super();
	}
	public DtEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac, String password) {
		super(nick, nombre, apellido, correo, fechaNac, password);
	}	
	
	
	
	
}
