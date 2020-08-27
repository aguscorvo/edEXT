package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia = null;
	private List<Instituto> institutos = new ArrayList<>();
	
	private ManejadorInstituto(){}
	
	public static ManejadorInstituto getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}

	public void agregarInstituto(Instituto instituto) {
		institutos.add(instituto);
	}
	
	public Instituto getInstituto(String nombre) {
		Instituto aretornar=null;
		for(Instituto i: institutos){
			if (i.getNombre() == nombre)
				aretornar=i;
		}
		return aretornar;
	}
	
	public List<Institutos> getInstitutos(){}
	public void removerInstituto(Instituto instituto){}
	public boolean existeInstituto(String nombre){}
}