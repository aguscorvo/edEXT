package datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtEstudianteExp extends DtEstudiante {
	public List<String> ediciones = new ArrayList<String>();
	public List<String> programas = new ArrayList<String>();
	
	public DtEstudianteExp(String nick, String nombre, String apellido, String correo, Date fechaNac, String password, List<String> ediciones, List<String> programas) {
		super(nick, nombre, apellido, correo, fechaNac, password);
		this.ediciones = ediciones;
		this.programas = programas;
	}

	public List<String> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<String> ediciones) {
		this.ediciones = ediciones;
	}

	public List<String> getProgramas() {
		return programas;
	}

	public void setProgramas(List<String> programas) {
		this.programas = programas;
	}
	
	
	
	

}
