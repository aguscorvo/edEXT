package logica;

import java.util.ArrayList;
import java.util.List;

import datatype.DtEdicion;
import interfaces.IControladorConsultaEdicion;

public class ControladorConsultaEdicion implements IControladorConsultaEdicion{
		
	
	private DtEdicion datosEdicion;
	
	
	public List<String> ingresarInstituto(String instituto){
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		Instituto auxInst = mi.getInstituto(instituto);
		
		List<Curso> auxCursos = auxInst.getCursos();
		List<String> nombreCursos = new ArrayList<String>();
		
		for(Curso c: auxCursos) 
			nombreCursos.add(c.getNombre());
		
	
		return nombreCursos;
		
		
	};
	
	
	public List<String> ingresarCurso(String curso){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		
		List<Edicion> auxEdicion = auxCurso.getEdiciones();
		List<String> nombreEdiciones = new ArrayList<String>();
		
		for(Edicion e: auxEdicion)
			nombreEdiciones.add(e.getNombre());
		
		return nombreEdiciones;
		
	};
	
	public DtEdicion ingresarEdicion(String edicion) {
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(edicion);
		DtEdicion auxDT = new DtEdicion(auxEdicion.getNombre(), auxEdicion.getFechaI(), auxEdicion.getFechaF(), auxEdicion.getCupo(), auxEdicion.getFechaPub());
		
		this.datosEdicion = auxDT;
		return auxDT;
		
		
	};
	
	public String[] getInstitutos(){
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Instituto> institutos = mi.getInstitutos();
		String [] arrInstitutos = new String [institutos.size()];
		
		int i=0;
		
		for(Instituto ins: institutos) {
			
			arrInstitutos[i] = ins.getNombre();
			i++;
		}
		return arrInstitutos;
		
		
	}
	
	public String[] getCursos(String instituto){
		

		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		Instituto auxInst = mi.getInstituto(instituto);
		List<Curso> auxCursos = auxInst.getCursos();
		String [] arrCursos = new String [auxCursos.size()];
		
		int i=0;
		
		for(Curso c: auxCursos) {
			
			arrCursos[i] = c.getNombre();
			i++;
		}
		
		return arrCursos;
		
		
		
	}
	
	public String[] getEdiciones(String curso){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		List<Edicion> ediciones = auxCurso.getEdiciones();
		String [] arrEdiciones = new String [ediciones.size()];
		
		int i=0;
		
		for(Edicion e: ediciones) {
			
			arrEdiciones[i] = e.getNombre();
			i++;
		}
		
		return arrEdiciones;
		
	}
	
	
	public List<String> obtenerDatosEdicion (DtEdicion Edicion){
		
		List<String>
		
	}
	
	
	
	
	



	
	

}
