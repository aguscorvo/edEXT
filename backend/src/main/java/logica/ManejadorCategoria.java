package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorCategoria {
	
	private static ManejadorCategoria instancia = null;
	
	private ManejadorCategoria(){}
	
	public static ManejadorCategoria getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCategoria();
		return instancia;
	}

	public void agregarCategoria(Categoria categoria) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}
	
	public Categoria getCategoria(String nombre) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Categoria auxCategoria = em.find(Categoria.class, nombre);
		return auxCategoria;
	}
	
	public List<Categoria> getCategorias(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Categoria c");
		@SuppressWarnings("unchecked")
		List<Categoria> listaCategoria = (List<Categoria>) query.getResultList();
		
		ArrayList<Categoria> aRetornar = new ArrayList<>();
		for(Categoria ca: listaCategoria) {
			aRetornar.add(ca);
		}
		return aRetornar;
		
	}
	
	public boolean existeCategoria(String nombre){
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Categoria auxCat = em.find(Categoria.class, nombre);
		boolean existe = em.contains(auxCat);
		return existe;
		
	}
}

