package interfaces;
import datatype.DtUsuario;

public interface IControladorAltaUsuario {
	public boolean ingresarDtUsuario(DtUsuario usuario);
	public void confirmarAltaUsuario();
	public void cancelarAltaUsuario();
}
