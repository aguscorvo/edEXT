package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import datatype.DtCurso;
import datatype.DtProgFormacion;
import interfaces.IControladorBuscarCursoOPrograma;

public class ControladorBuscarCursoOPrograma implements IControladorBuscarCursoOPrograma {
	
	public ArrayList<DtCurso> buscarCursos(String nombre){
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursos = mc.getCursos();
		ArrayList<DtCurso> cursosConNombre= new ArrayList<DtCurso>();	
		
				
		for(Curso c: cursos) {
			
			if (nombre.equals("")||nombre.equals(null)) {
				DtCurso cursoConNombre = new DtCurso(c.getNombre(), c.getDescripcion(), c.getDuracion(), c.getCantHoras(), c.getCreditos(), 
						c.getFechaR(), c.getUrl(), null, null);
				cursosConNombre.add(cursoConNombre);
			}
			else if (c.getNombre().contains(nombre)|| c.getDescripcion().contains(nombre)) {
				DtCurso cursoConNombre = new DtCurso(c.getNombre(), c.getDescripcion(), c.getDuracion(), c.getCantHoras(), c.getCreditos(), 
						c.getFechaR(), c.getUrl(), null, null);
				cursosConNombre.add(cursoConNombre);
			}
		}
		
		return cursosConNombre;
		
	}	
	
	public ArrayList<DtProgFormacion> buscarProgramas(String nombre){
		ManejadorProgFormacion mpf= ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> programas = mpf.getProgFormacion();
		ArrayList<DtProgFormacion> programasConNombre = new ArrayList<DtProgFormacion>();
		
		for (ProgFormacion pf: programas) {
			if (nombre.equals("")||nombre.equals(null)) {
				DtProgFormacion programaConNombre = new DtProgFormacion (pf.getNombre(), pf.getDescPF(), pf.getFechaI(), pf.getFechaF(), 
						pf.getFechaAlta());
				programasConNombre.add(programaConNombre);
			}			
			else if (pf.getNombre().contains(nombre)|| pf.getDescPF().contains(nombre)) {
				DtProgFormacion programaConNombre = new DtProgFormacion (pf.getNombre(), pf.getDescPF(), pf.getFechaI(), pf.getFechaF(), 
						pf.getFechaAlta());
				programasConNombre.add(programaConNombre);
			}
		}
		return programasConNombre;
		
	}	
	
	public ArrayList<DtCurso> ordenarCursosAlfabeticamente(ArrayList<DtCurso> cursos){
		
		class SortByName implements Comparator<DtCurso>{
			public int compare(DtCurso a, DtCurso b) {
				return a.getNombre().compareTo(b.getNombre());
			}
		}
		
		Collections.sort(cursos, new SortByName());
		return cursos;
	}
	
	public ArrayList<DtCurso> ordenarCursosPorFecha(ArrayList<DtCurso> cursos){
		
		class SortByDate implements Comparator<DtCurso>{
			public int compare(DtCurso a, DtCurso b) {
				return b.getFechaR().compareTo(a.getFechaR());
			}
		}
		
		Collections.sort(cursos, new SortByDate());
		return cursos;
	}
	
	public ArrayList<DtProgFormacion> ordenarProgramasAlfabeticamente(ArrayList<DtProgFormacion> programas){
		class SortByName implements Comparator<DtProgFormacion>{
			public int compare(DtProgFormacion a, DtProgFormacion b) {
				return a.getNombre().compareTo(b.getNombre());
			}
		}
		
		Collections.sort(programas, new SortByName());
		return programas;
	}
	
	public ArrayList<DtProgFormacion> ordenarProgramasPorFecha(ArrayList<DtProgFormacion> programas){
		class SortByDate implements Comparator<DtProgFormacion>{
			public int compare(DtProgFormacion a, DtProgFormacion b) {
				return b.getFechaAlta().compareTo(a.getFechaAlta());
			}
		}
		
		Collections.sort(programas, new SortByDate());
		return programas;
	}
	
	
}
