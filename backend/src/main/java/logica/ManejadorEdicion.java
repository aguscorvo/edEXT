package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorEdicion {
	private static ManejadorEdicion instancia = null;
	
	private ManejadorEdicion(){}
	
	public static ManejadorEdicion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEdicion();
		return instancia;
	}

	public void agregarEdicion(Edicion edicion) {
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(edicion);
		em.getTransaction().commit();
	}
	
	public Edicion getEdicion(String nombre) {

		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		Edicion auxEdicion = em.find(Edicion.class, nombre);
		return auxEdicion;
		
	}
	
	public List<Edicion> getEdiciones(){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT e FROM Edicion i");
		@SuppressWarnings("unchecked")
		List<Edicion> listaEds = (List<Edicion>) query.getResultList();
		
		ArrayList<Edicion> aRetornar = new ArrayList<>();
		for(Edicion e: listaEds) {
			aRetornar.add(e);
		}
		return aRetornar;
	}
	
	
	public boolean existeEdicion(String nombre){
				
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Edicion auxEd = em.find(Edicion.class, nombre);
		boolean existe = em.contains(auxEd);
		return existe;


	}
	
		
	
	
}