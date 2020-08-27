package interfaces;
import java.util.List;

import datatype.DtUsuario;

public interface IControladorModificarDatosUsuario {
	public List<String> getUsuarios();
	public DtUsuario seleccionarUsuario(String nick);
	public void modificarDatosUsuario(DtUsuario datos);
}
