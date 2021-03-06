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
	
	
	public boolean existeEdicion(String nombre){
				
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Edicion auxEd = em.find(Edicion.class, nombre);
		boolean existe = em.contains(auxEd);
		return existe;


	}
	
		
	
	
}