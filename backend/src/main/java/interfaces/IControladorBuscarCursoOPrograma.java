package interfaces;

import java.util.ArrayList;

import datatype.DtCurso;
import datatype.DtProgFormacion;

public interface IControladorBuscarCursoOPrograma {
	
	public ArrayList<DtCurso> buscarCursos(String nombre);				//devuelve una lista de cursos con 'nombre' en nombre o descripción
	public ArrayList<DtProgFormacion> buscarProgramas(String nombre);		// ídem
	public ArrayList<DtCurso> ordenarCursosAlfabeticamente(ArrayList<DtCurso> cursos);
	public ArrayList<DtCurso> ordenarCursosPorFecha(ArrayList<DtCurso> cursos);
	public ArrayList<DtProgFormacion> ordenarProgramasAlfabeticamente(ArrayList<DtProgFormacion> programas);
	public ArrayList<DtProgFormacion> ordenarProgramasPorFecha(ArrayList<DtProgFormacion> programas);
	
}
