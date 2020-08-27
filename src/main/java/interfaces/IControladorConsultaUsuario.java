package interfaces;

import datatype.*;

import java.util.List;
 
public interface IControladorConsultaUsuario {
	public List<String> getUsuarios();
	public DtUsuario seleccionarUsuario(String nick);
	public DtCursoExp seleccionarCurso(String nombre);
	public DtEdicionExp seleccionarEdicion(String nombre);
	public DtProgFormacionExp seleccionarPrograma(String nombre);
}
