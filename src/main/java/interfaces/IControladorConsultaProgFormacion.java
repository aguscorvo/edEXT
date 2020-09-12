package interfaces;
import datatype.DtProgFormacionExp;

import java.util.List;

import datatype.DtCursoExp;

public interface IControladorConsultaProgFormacion {
	
	public String[] getProgramasDeFormacion();
	
	public DtProgFormacionExp seleccionarPrograma(String programa);
	
	public DtCursoExp seleccionarCurso(String curso);
	
	public String [] getCursos(DtProgFormacionExp dtProg);

	public String obtenerDatosPrograma(DtProgFormacionExp programa);
	
	public String obtenerDatosCurso(DtCursoExp curso);
	
	
}
