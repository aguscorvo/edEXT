package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia = null;
	private List<ProgFormacion> progFormaciones = new ArrayList<>();
	
	private ManejadorProgFormacion(){}
	
	public static ManejadorProgFormacion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorProgFormacion();
		return instancia;
	}

	public void agregarProgFormacion(ProgFormacion progFormacion) {
		progFormaciones.add(progFormacion);
	}
	
	public ProgFormacion getProgFormacion(String nombre) {
		ProgFormacion aretornar=null;
		for(ProgFormacion pf: progFormaciones){
			if (pf.getNombre() == nombre)
				aretornar=pf;
		}
		return aretornar;
	}
	
	public List<ProgFormacion> getProgFormacion(){}
	public void removerProgFormacion(ProgFormacion progFormacion){}
	public boolean existeProgFormacion(String nombre){}
}