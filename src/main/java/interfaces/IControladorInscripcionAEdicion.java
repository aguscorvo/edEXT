package interfaces;
import java.util.Date;
import java.util.List;

import excepciones.NoExisteEdicionVigenteException;


public interface IControladorInscripcionAEdicion {
	public String [] ingresarInstituto(String instituto);
	public String ingresarCurso(String curso) throws NoExisteEdicionVigenteException;
	public void ingresarEstudiante(String nick, Date fecha);
	public void confirmarInscripcionAEdicion();
	public void cancelarInscripcionAEdicion();

}
