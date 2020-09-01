package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	private List<Curso> cursos = new ArrayList<Curso>();
	
	private ManejadorCurso(){}
	
	public static ManejadorCurso getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCurso();
		return instancia;
	}

	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public Curso getCurso(String nombre) {
		Curso aretornar=null;
		for(Curso c: cursos){
			if (c.getNombre().equals(nombre))
				aretornar=c;
		}
		return aretornar;
	}
	
	public List<Curso> getCursos(){
		List<Curso> aux = new ArrayList<Curso>(cursos);
		return aux;
		
	}
	
	
	public void removerCurso(Curso curso){}
	public boolean existeCurso(String nombre){
		boolean existe = false;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre))
				existe = true;
		}
		return existe;
		
	}
}
