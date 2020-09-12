package logica;

import java.util.ArrayList;
import java.util.List;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.IControladorAltaCurso;

public class ControladorAltaCurso implements IControladorAltaCurso {
	private DtCurso curso;
	private String instituto;
	
	public void ingresarCurso(String instituto, DtCurso curso) throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException {
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		if (!mi.existeInstituto(instituto)) 
			throw new NoExisteInstitutoException("El instituto con nombre '" + instituto + "' no se encuentra registrado en el sistema.");
		this.instituto = instituto;
		
		if(mc.existeCurso(curso.getNombre()))
			throw new CursoRepetidoException("El curso con nombre '" + curso.getNombre() + "' ya se encuentra registrado en el sistema.");
		this.curso = curso;
		
		for(String p: curso.getPrevias()) {
			if(!mc.existeCurso(p))
				throw new NoExisteCursoException("La previa con nombre '" + p + "' no se escuentra registrada en el sistema.");
			
		}
		
};
	
	
	public void confirmarAltaCurso(){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Curso> auxPrevias = new ArrayList<Curso>();
		for(String p: this.curso.getPrevias()){
			Curso auxCurso = mc.getCurso(p);
			auxPrevias.add(auxCurso);
			
		}
		
		List<Edicion> auxEdiciones = new ArrayList<Edicion>();
		List<ProgFormacion> auxProgramas = new ArrayList<ProgFormacion>();
		Curso nuevo = new Curso(this.curso.getNombre(),this.curso.getDesc(),this.curso.getDuracion(),this.curso.getCantHoras(),this.curso.getCreditos(),this.curso.getFechaR(),this.curso.getUrl(), auxPrevias, auxEdiciones, auxProgramas);

		Instituto auxInstituto = mi.getInstituto(this.instituto);
		List<Curso> auxCursos = auxInstituto.getCursos();
		auxCursos.add(nuevo);
		auxInstituto.setCursos(auxCursos);
		
		mc.agregarCurso(nuevo);
	
	};
			
	
	
	public void cancelarAltaCurso() {};
	
	public String[] getCursos() {
		List<Curso> cursos;
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		cursos = mC.getCursos();
		String[] cursos_ret = new String[cursos.size()];
        int i=0;
        for(Curso c:cursos) {
        	cursos_ret[i]=c.getNombre();
        	i++;
        }
        return cursos_ret;
	}
	
	
		
		
	
	
}
