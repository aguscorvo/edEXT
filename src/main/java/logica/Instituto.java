package logica;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
	private String nombre;
	
	private List<Curso> cursos = new ArrayList<Curso>();

	
	public List<String> obtenerCursos(){}


	public Instituto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Instituto(String nombre, List<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
