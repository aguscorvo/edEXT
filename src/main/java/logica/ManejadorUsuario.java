package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	//private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		//usuarios.add(usuario);
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario getUsuario(String nick) {
		/*Usuario aretornar=null;
		for(Usuario u: usuarios){
			if (u.getNick().equals(nick))
				aretornar=u;
		}
		return aretornar;*/
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		Usuario auxUsuario = em.find(Usuario.class, nick);
		return auxUsuario;
	}
	
	public List<Usuario> getUsuarios(){
		/*List <Usuario> aux = new ArrayList<Usuario>(usuarios);
		return aux;*/
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT pf FROM Usuario pf");
		List<Usuario> listaUsu = (List<Usuario>) query.getResultList();
		
		ArrayList<Usuario> aRetornar = new ArrayList<>();
		for(Usuario p: listaUsu) {
			aRetornar.add(p);
		}
		return aRetornar;
	}
	public void removerUsuario(Usuario usuario){}
	
	public boolean existeUsuarioNick(String nick){
		/*boolean existe = false;
		for (Usuario u: usuarios) {
			if(u.getNick().equals(nick)) {
				existe= true;
			}	
		}
		return existe;*/
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Usuario auxU= em.find(Usuario.class, nick);
		boolean existe = em.contains(auxU);
		return existe;
	}
	
	
	public boolean existeUsuarioCorreo(String correo) {
		/*boolean existe = false;
		for (Usuario u: usuarios) {
			if(u.getCorreo().equals(correo)) {
				existe= true;
			}	
		}
		return existe;*/
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Usuario auxU= em.find(Usuario.class, correo);
		boolean existe = em.contains(auxU);
		return existe;
	}
}