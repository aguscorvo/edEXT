package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private List<Usuario> usuarios = new ArrayList<>();
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario getUsuario(String nick) {
		Usuario aretornar=null;
		for(Usuario u: usuarios){
			if (u.getNick() == nick)
				aretornar=u;
		}
		return aretornar;
	}
	
	public List<Usuario> getUsuarios(){}
	public void removerUsuario(Usuario usuario){}
	public boolean existeUsuario(String nick){}
}