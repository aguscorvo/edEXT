package interfaces;

import datatype.*;

public interface IControladorConsultaUsuario {
	public String[] getUsuarios();
	public DtUsuario seleccionarUsuario(String nick);
	public DtEdicion seleccionarEdicion(String nombre);
	public DtProgFormacionExp seleccionarPrograma(String programa);
	public String obtenerDatosUsuario (DtUsuario usuario);
	public String obtenerDatosEdicion(DtEdicion edicion);
	public String obtenerDatosPrograma(DtProgFormacionExp programa);
	public String [] getEdiciones(DtUsuario usuario);
	public String[] getProgramas(DtUsuario usuario);
}
