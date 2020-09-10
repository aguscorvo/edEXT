package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia = null;
	private List<ProgFormacion> progsFormacion = new ArrayList<ProgFormacion>();
	
	private ManejadorProgFormacion(){}
	
	public static ManejadorProgFormacion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}

	public void agregarProgFormacion(ProgFormacion progFormacion) {
		progsFormacion.add(progFormacion);
	}
	
	public ProgFormacion getProgFormacion(String nombre) {
		ProgFormacion aretornar=null;
		for(ProgFormacion pf: progsFormacion){
			if (pf.getNombre().equals(nombre))
				return aretornar=pf;
		}
		return aretornar;
	}
	
	public List<ProgFormacion> getProgFormacion(){
		return progsFormacion;
	}
	
	
	public void removerProgFormacion(ProgFormacion progFormacion){}
	
	public boolean existeProgFormacion(String nombre){
		
		for(ProgFormacion pf: progsFormacion)
			if(pf.getNombre().equals(nombre))
					return true;
			
		return false;
	}
}