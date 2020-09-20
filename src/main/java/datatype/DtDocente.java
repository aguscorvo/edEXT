package datatype;

import java.util.Date;


public class DtDocente extends DtUsuario{
	private String instituto;
	
	public DtDocente() {
		super();
	}
		
	public DtDocente(String nick, String nombre, String apellido, String correo, Date fechaNac, String password, String instituto) {
		super(nick, nombre, apellido, correo, fechaNac, password);
		this.instituto = instituto;
	}	

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	
	

	
	
	
	
}
