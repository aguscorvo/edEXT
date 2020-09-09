package logica;

import java.lang.reflect.Array;
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
		String [] arrCursosVacio = {""};
		if(mi.existeInstituto(instituto)) {
			Instituto auxInst = mi.getInstituto(instituto);
			List<String> auxCursos = auxInst.getCursosString();
			String [] arrCursos = new String [auxCursos.size()];
			
			int i=0;
			
			for(String c: auxCursos) {
				
				arrCursos[i] = c;
				i++;
			}
			
			return arrCursos;
		}
		
		return arrCursosVacio;
		
	}
	
	public String[] getEdiciones(String curso){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		if(mc.existeCurso(curso)) {
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
		
		String[] arrEdicionesVacio =  {""};
		return arrEdicionesVacio;
	}
	
	
	public String obtenerDatosEdicion(DtEdicion edicion) {
		String fechaI = funcionesAux.convertirAString(edicion.getFechaI());
		String fechaF = funcionesAux.convertirAString(edicion.getFechaF());
		String fechaP = funcionesAux.convertirAString(edicion.getFechaPub());
		String cupo = String.valueOf(edicion.getCupo());
		
		String auxDatos = "Nombre: " + edicion.getNombre() + "\n\nFecha inicio: " + fechaI + "\n\nFecha fin: " + fechaF + "\n\nCupo: " + cupo + "\n\nFecha de publicación: " + fechaP;
		return auxDatos;
		
	}


	public DtEdicion getDatosEdicion() {
		return datosEdicion;
	}


	public void setDatosEdicion(DtEdicion datosEdicion) {
		this.datosEdicion = datosEdicion;
	}
	
	
	
	
	
	



	
	

}
