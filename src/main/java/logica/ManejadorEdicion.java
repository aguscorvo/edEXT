package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorEdicion {
	private static ManejadorEdicion instancia = null;
	private List<Edicion> ediciones = new ArrayList<Edicion>();
	
	private ManejadorEdicion(){}
	
	public static ManejadorEdicion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEdicion();
		return instancia;
	}

	public void agregarEdicion(Edicion edicion) {
		ediciones.add(edicion);
	}
	
	public Edicion getEdicion(String nombre) {
		Edicion aretornar = null;
		for(Edicion e: ediciones){
			if (e.getNombre().equals(nombre)) 
				return aretornar=e;				
			
		}
		return aretornar;
	}
	
	public List<Edicion> getEdiciones(){
		List<Edicion> aux = new ArrayList<Edicion>(ediciones);
		return aux;
	}
	public void removerEdicion(Edicion edicion){}
	
	public boolean existeEdicion(String nombre){
		boolean existe = false;
		for(Edicion e: ediciones) {
			if(e.getNombre().equals(nombre)) {
				existe = true;
			}	
		}
		return existe;		
	}
	
		
	
	
}