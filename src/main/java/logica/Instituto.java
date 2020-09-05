package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instituto {
	@Id
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<Curso>();

	
	public Instituto() {
		super();
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

	public List<String> getCursosString(){
		List<String> aux = new ArrayList<String>();
		for (Curso c: cursos) {
			aux.add(c.getNombre());			
		}
		return aux;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
