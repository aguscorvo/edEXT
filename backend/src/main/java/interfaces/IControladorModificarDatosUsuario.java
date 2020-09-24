package interfaces;

import datatype.DtUsuario;

public interface IControladorModificarDatosUsuario {
	public String [] getUsuarios();
	public DtUsuario seleccionarUsuario(String nick);
	public void modificarDatosUsuario(DtUsuario datos);
}
