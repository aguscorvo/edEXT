package logica;

import java.util.ArrayList;
import java.util.List;

import datatype.DtCurso;
import datatype.DtEdicion;
import datatype.DtEdicionExp;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.IControladorAltaEdicion;

public class ControladorAltaEdicion implements IControladorAltaEdicion{
	
	private String instituto;
	private String curso;
	private DtEdicionExp edicion;
	
	public List<String> ingresarInstituto(String instituto) throws NoExisteInstitutoException{
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		if(!mi.existeInstituto(instituto))
			throw new NoExisteInstitutoException("El instituto '" + instituto + "' no se encuentra registrado en el sistema.");
		
		Instituto auxInst = mi.getInstituto(instituto);
		List<Curso> cursosInst = auxInst.getCursos();
		List<String> auxCursos = new ArrayList<String>();
		
		for(Curso c: cursosInst){
			auxCursos.add(c.getNombre());
		}
		
		this.instituto = instituto;
		return auxCursos;
		
	}
	
	public void seleccionarCurso(String curso) throws NoExisteCursoException {
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		if(!mc.existeCurso(curso))
			throw new NoExisteCursoException("El curso '" + curso + "' no se encuentra registrado en el sistema.");
		this.curso = curso;
		
	}
	
	public void ingresarDtEdicion(DtEdicionExp edicion) throws EdicionRepetidaException{
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		if(me.existeEdicion(edicion.getNombre()))
			throw new EdicionRepetidaException("La edicion '" + edicion.getNombre() +"' ya se encuentra registrada en el sistema.");
		
		this.edicion = edicion;
		
	}
	
	public void confirmarAltaEdicion() {
		
		Edicion nuevaEdicion = new Edicion(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(), edicion.getCupo(), edicion.getFechaPub());
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(this.curso);
		auxCurso.getEdiciones().add(nuevaEdicion);
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List<String> auxDocentes = new ArrayList<String>(this.edicion.getDocentes()); 
		
		for(String d: auxDocentes) {
			Usuario aux = mu.getUsuario(d);
			if(aux instanceof Docente)
				((Docente)aux).getEdiciones().add(nuevaEdicion);
			
		}
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		me.getEdiciones().add(nuevaEdicion);
		
		
	}

	public void cancelarAltaEdicion() {}
	
	}
