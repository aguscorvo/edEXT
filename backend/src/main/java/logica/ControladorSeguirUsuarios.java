package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.IControladorSeguirUsuarios;
import persistencia.Conexion;

public class ControladorSeguirUsuarios implements IControladorSeguirUsuarios {
	
		public String [] getUsuariosNoSeguidos (String usuario) {
			
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			List<Usuario> usuariosNoSeguidos = new ArrayList<Usuario>();
			List<Usuario> usuariosSeguidos = u.getUsuariosSeguidos();
			List<Usuario> usuarios = mu.getUsuarios();
			
			for (Usuario aux: usuarios) {
				if (!usuariosSeguidos.contains(aux))
					if (aux != u)
						usuariosNoSeguidos.add(aux);
			}
			
			String[] usu_ret = new String [usuariosNoSeguidos.size()];
			int i=0;
			for (Usuario aux: usuariosNoSeguidos) {
				usu_ret[i]= aux.getNick();
				i++;
			}
			return usu_ret;
		}
		

		public String [] getUsuariosSeguidos (String usuario) {
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			List<Usuario> usuariosSeguidos = u.getUsuariosSeguidos();
			
			String[] usu_ret = new String [usuariosSeguidos.size()];
			int i=0;
			for (Usuario aux: usuariosSeguidos) {
				usu_ret[i]= aux.getNick();
				i++;
			}
			return usu_ret;
		}
		
		
		public String getCadenaUsuariosSeguidos (String usuario) {
			
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			List<Usuario> usuariosSeguidos = u.getUsuariosSeguidos();
			
			int cantElem = usuariosSeguidos.size();
			int cont = 0;
			String cadena = "";
			while (!usuariosSeguidos.isEmpty() && cont<cantElem) {
				cadena = cadena + "@" + usuariosSeguidos.get(cont).getNick() + " (" +  usuariosSeguidos.get(cont).getNombre() + " " + usuariosSeguidos.get(cont).getApellido() + ")<br><br>";
				cont++;
			}
			
			return cadena;
			
		}
		
		
		public String getCadenaUsuariosSeguidores (String usuario) {
			
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			List<Usuario> usuarios = mu.getUsuarios();
			List<Usuario> usuariosSeguidores = new ArrayList<Usuario>();
 			
			for (Usuario aux: usuarios) {
				List<Usuario> usuariosSeguidos = aux.getUsuariosSeguidos();
				if (usuariosSeguidos.contains(u)) {
					usuariosSeguidores.add(aux);
				}
			}
			
			int cantElem = usuariosSeguidores.size();
			int cont = 0;
			String cadena = "";
			while (!usuariosSeguidores.isEmpty() && cont<cantElem) {
				cadena = cadena + "@" + usuariosSeguidores.get(cont).getNick() + " (" +  usuariosSeguidores.get(cont).getNombre() + " " + usuariosSeguidores.get(cont).getApellido() + ")<br><br>";
				cont++;
			}
			
			return cadena;}
		
		
		public void seguirUsuario (String usuario, String usuarioASeguir) {
			
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			Usuario uS = mu.getUsuario(usuarioASeguir);
			
			List <Usuario> seguidos= u.getUsuariosSeguidos();
			seguidos.add(uS);
			u.setUsuariosSeguidos(seguidos);
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			
		}
		
		
		public void noSeguirUsuario (String usuario, String usuarioNoSeguir) {
			
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario u = mu.getUsuario(usuario);
			Usuario uN = mu.getUsuario(usuarioNoSeguir);
			
			List <Usuario> seguidos= u.getUsuariosSeguidos();
			seguidos.remove(uN);
			u.setUsuariosSeguidos(seguidos);
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		}

}

