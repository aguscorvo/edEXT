package interfaces;
import java.util.List;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;

public interface IControladorAltaCurso {
	public void ingresarCurso(String instituto, DtCurso curso) throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException;
	public void confirmarAltaCurso();
	public void cancelarAltaCurso();
	public String [] getCursos();
}
