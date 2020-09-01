package datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtCursoExp extends DtCurso {
	private List<String> ediciones = new ArrayList<String>();
	private List<String> programas = new ArrayList<String>();
	
	public DtCursoExp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtCursoExp(String nombre, String desc, String duracion, DtTime cantHoras, int creditos, Date fechaR,
			String url, List<String> previas) {
		super(nombre, desc, duracion, cantHoras, creditos, fechaR, url, previas);
		// TODO Auto-generated constructor stub
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
