package interfaces;
import java.util.List;

import datatype.DtFecha;

public interface IControladorInscripcionAEdicion {
	public List<String> ingresarInstituto(String instituto);
	public String ingresarCurso(String curso);
	public boolean ingresarEstudiante(String nick, DtFecha fecha);
	public void confirmarInscripcionAEdicion();
	public void cancelarInscripcionAEdicion();

}
