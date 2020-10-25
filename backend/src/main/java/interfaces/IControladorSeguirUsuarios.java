package interfaces;

public interface IControladorSeguirUsuarios {
	
	public String [] getUsuariosNoSeguidos (String usuario);
	public String [] getUsuariosSeguidos (String usuario);
	public String getCadenaUsuariosSeguidos (String usuario);
	public String getCadenaUsuariosSeguidores (String usuario);
	public void seguirUsuario (String usuario, String usuarioASeguir);
	public void noSeguirUsuario (String usuario, String usuarioNoSeguir);
}
