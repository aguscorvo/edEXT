package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	
	private ManejadorCurso(){}
	
	public static ManejadorCurso getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCurso();
		return instancia;
	}

	public void agregarCurso(Curso curso) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}
	
	public Curso getCurso(String nombre) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Curso auxCurso = em.find(Curso.class, nombre);
		return auxCurso;
	}
	
	public List<Curso> getCursos(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Curso c");
		List<Curso> listaCurs = (List<Curso>) query.getResultList();
		
		ArrayList<Curso> aRetornar = new ArrayList<>();
		for(Curso cu: listaCurs) {
			aRetornar.add(cu);
		}
		return aRetornar;
		
	}
	
	
	public void removerCurso(Curso curso){}

	public boolean existeCurso(String nombre){
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Curso auxCur = em.find(Curso.class, nombre);
		boolean existe = em.contains(auxCur);
		return existe;
		
	}
}
