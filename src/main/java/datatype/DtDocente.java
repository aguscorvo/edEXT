package datatype;

import java.util.Date;
import java.util.List;

import logica.Edicion;

public class DtDocente extends DtUsuario{
	private String instituto;
	
	public DtDocente() {
		super();
	}
		
	public DtDocente(String nick, String nombre, String apellido, String correo, Date fechaNac, String instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
	}	

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	
	

	
	
	
	
}
