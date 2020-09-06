package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia = null;
	//private List<Instituto> institutos = new ArrayList<Instituto>();
	
	private ManejadorInstituto(){}
	
	public static ManejadorInstituto getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}

	public void agregarInstituto(Instituto instituto) {
		//institutos.add(instituto);

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
		/*Instituto aretornar=null;
		for(Instituto i: institutos){
			if (i.getNombre().equals(nombre))
				aretornar=i;
		}
		return aretornar;*/
	}
	
	public List<Instituto> getInstitutos(){
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Query query = em.createQuery("SELECT i FROM Instituto i");
		List<Instituto> listaInst = (List<Instituto>) query.getResultList();
		
		ArrayList<Instituto> aRetornar = new ArrayList<>();
		for(Instituto i: listaInst) {
			aRetornar.add(i);
		}
		return aRetornar;
		//return institutos;
	}
	public void removerInstituto(Instituto instituto){}
	
	public boolean existeInstituto(String nombre){
		/*boolean existe=false;
		for(Instituto i: institutos){
			if(i.getNombre().equals(nombre))
				existe=true;
		}
		return existe;*/
		
		Conexion c = Conexion.getInstancia();
		EntityManager em= c.getEntityManager();
		
		Instituto auxInstituto = em.find(Instituto.class, nombre);
		boolean existe = em.contains(auxInstituto);
		return existe;
		
	}
			
		
	
}