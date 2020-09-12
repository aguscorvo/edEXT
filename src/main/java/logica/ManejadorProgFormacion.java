package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia = null;
	
	private ManejadorProgFormacion(){}
	
	public static ManejadorProgFormacion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}

	public void agregarProgFormacion(ProgFormacion progFormacion) {

		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(progFormacion);
		em.getTransaction().commit();

	}
	
	
	public ProgFormacion getProgFormacion(String nombre) {

		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		ProgFormacion auxPrograma = em.find(ProgFormacion.class, nombre);
		return auxPrograma;
	}
	
	public List<ProgFormacion> getProgFormacion(){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT pf FROM ProgFormacion pf");
		List<ProgFormacion> listaPF = (List<ProgFormacion>) query.getResultList();
		
		ArrayList<ProgFormacion> aRetornar = new ArrayList<>();
		for(ProgFormacion p: listaPF) {
			aRetornar.add(p);
		}
		return aRetornar;
	}
	
	public void removerProgFormacion(ProgFormacion progFormacion){}
	
	public boolean existeProgFormacion(String nombre){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		ProgFormacion auxPF = em.find(ProgFormacion.class, nombre);
		boolean existe = em.contains(auxPF);
		return existe;
	
	}
		
}