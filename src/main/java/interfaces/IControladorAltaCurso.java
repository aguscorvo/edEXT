package interfaces;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.PreviaRepetidaException;

public interface IControladorAltaCurso {
	public void ingresarCurso(String instituto, DtCurso curso) throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException;
	public void confirmarAltaCurso() throws PreviaRepetidaException;
	public void cancelarAltaCurso();
	public String [] getCursos();
}
