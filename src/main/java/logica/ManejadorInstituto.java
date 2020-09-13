package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia = null;
	
	private ManejadorInstituto(){}
	
	public static ManejadorInstituto getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}

	public void agregarInstituto(Instituto instituto) {

		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(instituto);
		em.getTransaction().commit();
	}
	
	public Instituto getInstituto(String nombre) {
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Instituto auxInstituto = em.find(Instituto.class, nombre);
		return auxInstituto;
		
	}
	
	public List<Instituto> getInstitutos(){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT i FROM Instituto i");
		@SuppressWarnings("unchecked")
		List<Instituto> listaInst = (List<Instituto>) query.getResultList();
		
		ArrayList<Instituto> aRetornar = new ArrayList<>();
		for(Instituto i: listaInst) {
			aRetornar.add(i);
		}
		return aRetornar;
		
	}
	public void removerInstituto(Instituto instituto){}
	
	public boolean existeInstituto(String nombre){
				
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Instituto auxInstituto = em.find(Instituto.class, nombre);
		boolean existe = em.contains(auxInstituto);
		return existe;
		
	}
			
		
	
}