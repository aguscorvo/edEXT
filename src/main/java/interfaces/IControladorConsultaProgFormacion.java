package interfaces;
import datatype.DtProgFormacionExp;

import java.util.List;

import datatype.DtCursoExp;

public interface IControladorConsultaProgFormacion {
	
	public String[] getProgramasDeFormacion();
	
	public DtProgFormacionExp seleccionarPrograma(String programa);
	
	public DtCursoExp seleccionarCurso(String curso);

}
