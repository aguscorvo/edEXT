package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorEdicion {
	private static ManejadorEdicion instancia = null;
	//private List<Edicion> ediciones = new ArrayList<Edicion>();
	
	private ManejadorEdicion(){}
	
	public static ManejadorEdicion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEdicion();
		return instancia;
	}

	public void agregarEdicion(Edicion edicion) {
		//ediciones.add(edicion);
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(edicion);
		em.getTransaction().commit();
	}
	
	public Edicion getEdicion(String nombre) {
		/*Edicion aretornar=null;
		for(Edicion e: ediciones){
			if (e.getNombre().equals(nombre))
				aretornar=e;
		}
		return aretornar;*/
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		Edicion auxEdicion = em.find(Edicion.class, nombre);
		return auxEdicion;
		
	}
	
	public List<Edicion> getEdiciones(){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT e FROM Edicion i");
		List<Edicion> listaEds = (List<Edicion>) query.getResultList();
		
		ArrayList<Edicion> aRetornar = new ArrayList<>();
		for(Edicion e: listaEds) {
			aRetornar.add(e);
		}
		return aRetornar;
		//return ediciones;
	}
	public void removerEdicion(Edicion edicion){}
	
	public boolean existeEdicion(String nombre){
		/*boolean existe = false;
		for(Edicion e: ediciones) {
			if(e.getNombre().equals(nombre)) {
				existe = true;
			}	
		}
		return existe;*/
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Edicion auxEd = em.find(Edicion.class, nombre);
		boolean existe = em.contains(auxEd);
		return existe;

		
		
	}
}