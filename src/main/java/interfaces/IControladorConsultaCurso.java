package interfaces;
import datatype.*;
import java.util.List;

public interface IControladorConsultaCurso {
	public List<String> ingresarCurso(String curso);
	public DtCursoExp seleccionarCurso(String curso);
	public DtEdicion seleccionarEdicion(String edicion);
	public DtProgFormacionExp seleccionarProgFormacion(String progFormacion);	
	
}
