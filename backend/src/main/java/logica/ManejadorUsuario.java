package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario getUsuario(String nick) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		Usuario auxUsuario = em.find(Usuario.class, nick);
		return auxUsuario;
	}
	
	public Usuario getUsuarioPorCorreo(String correo) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		Query query = em.createQuery("SELECT u FROM Usuario as u WHERE u.correo LIKE: correoIngresado").setParameter("correoIngresado", correo);
		Usuario auxUsuario = (Usuario) query.getSingleResult();		
		return auxUsuario;
	}
	/*
	 * Query query = em.createQuery("SELECT u FROM Usuario as u WHERE u.correo LIKE: correoIngresado").setParameter("correoIngresado", correo);
			@SuppressWarnings("unchecked")
			List <Usuario> resultado = (List<Usuario>) query.getResultList();
	 */
	
	
	
	public List<Usuario> getUsuarios(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT pf FROM Usuario pf");
		@SuppressWarnings("unchecked")
		List<Usuario> listaUsu = (List<Usuario>) query.getResultList();
		
		ArrayList<Usuario> aRetornar = new ArrayList<>();
		for(Usuario p: listaUsu) {
			aRetornar.add(p);
		}
		return aRetornar;
	}
	
	
	public boolean existeUsuarioNick(String nick){

		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Usuario auxU= em.find(Usuario.class, nick);
		boolean existe = em.contains(auxU);
		return existe;
	}
	
	
	public boolean existeUsuarioCorreo(String correo) {
		
		List<Usuario> usuarios = getUsuarios();
		if (!usuarios.isEmpty()) {
			Conexion c = Conexion.getInstancia();
			EntityManager em= c.getEntityManager();
			
			Query query = em.createQuery("SELECT u FROM Usuario as u WHERE u.correo LIKE: correoIngresado").setParameter("correoIngresado", correo);
			@SuppressWarnings("unchecked")
			List <Usuario> resultado = (List<Usuario>) query.getResultList();
			if (resultado.isEmpty())
				return false;
			else return true;
		}
		return false;
		
	}
}