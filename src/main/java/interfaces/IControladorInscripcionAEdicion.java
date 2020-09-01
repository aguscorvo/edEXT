package interfaces;
import java.util.Date;
import java.util.List;


public interface IControladorInscripcionAEdicion {
	public List<String> ingresarInstituto(String instituto);
	public String ingresarCurso(String curso);
	public boolean ingresarEstudiante(String nick, Date fecha);
	public void confirmarInscripcionAEdicion();
	public void cancelarInscripcionAEdicion();

}
