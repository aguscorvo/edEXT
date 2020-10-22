package logica;

import java.util.ArrayList;
import java.util.List;

import datatype.DtEdicionExp;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.IControladorAltaEdicion;

public class ControladorAltaEdicion implements IControladorAltaEdicion{
	
	private String curso;
	private DtEdicionExp edicion;
	private Instituto inst;
	
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
		auxCurso.agregarEdicion(nuevaEdicion);
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List<String> auxDocentes = new ArrayList<String>(this.edicion.getDocentes()); 
		
		for(String d: auxDocentes) {
			Usuario aux = mu.getUsuario(d);
			if(aux instanceof Docente) {
				((Docente)aux).getEdiciones().add(nuevaEdicion);
			}
			
		}
		
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		me.agregarEdicion(nuevaEdicion);
		
		
	}

	public void cancelarAltaEdicion() {}
	
	
	public boolean existeInstituto(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		inst=mI.getInstituto(nombre);
		return (inst!=null);
			
		
	}

	public Instituto getInstituto(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		inst=mI.getInstituto(nombre);
		return inst;
		
	}
	
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
	
	public String[] getCursos(Instituto nombre) {
		List<Curso> cursos= new ArrayList<Curso>(inst.getCursos());
		String [] arrCursos= new String [cursos.size()];
		int i=0;
		for(Curso c: cursos) {
			arrCursos[i]=c.getNombre();
			i++;
		}
		return arrCursos;
	}
	
	public String [] getDocentes() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mU.getUsuarios();
		List<Docente> docentes = new ArrayList<Docente>();
		for(Usuario d: usuarios) {
			if(d instanceof Docente) {
				docentes.add((Docente) d);
			}
		}		
		String [] arrDocentes = new String[docentes.size()];
		int i=0;
		for(Docente d: docentes) {
			arrDocentes[i]=d.getNick();
			i++;
		}		
		
		return arrDocentes;
		
	}
	
}
