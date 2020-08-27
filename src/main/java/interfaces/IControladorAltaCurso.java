package interfaces;
import datatype.DtCurso;

public interface IControladorAltaCurso {
	public boolean ingresarCurso(String instituto, DtCurso curso);
	public void confirmarAltaCurso();
	public void cancelarAltaCurso();
}
