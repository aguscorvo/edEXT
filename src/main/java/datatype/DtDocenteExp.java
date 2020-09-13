package datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtDocenteExp extends DtDocente {
	private List<String> ediciones = new ArrayList<String>();

	
	public DtDocenteExp(String nick, String nombre, String apellido, String correo, Date fechaNac, String instituto, List<String> ediciones) {
		super(nick, nombre, apellido, correo, fechaNac, instituto);
		this.ediciones=ediciones;
	}


	public List<String> getEdiciones() {
		return ediciones;
	}


	public void setEdiciones(List<String> ediciones) {
		this.ediciones = ediciones;
	}
	
	
	
	

}
