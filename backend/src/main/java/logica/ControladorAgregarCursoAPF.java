package logica;

import java.util.List;

import javax.persistence.EntityManager;

import excepciones.CursoEnPFRepetidoException;
import interfaces.IControladorAgregarCursoAPF;
import persistencia.Conexion;

public class ControladorAgregarCursoAPF implements IControladorAgregarCursoAPF {
	
	private String programa;
	
	public String[] getProgramas() {
		ManejadorProgFormacion mP = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> auxProgramas = mP.getProgFormacion();
		String [] programas = new String[auxProgramas.size()];
		String [] arrVacio = {""};
		int i=0;
		if(!auxProgramas.isEmpty()) {
			for (ProgFormacion pf: auxProgramas) {
				programas[i]=pf.getNombre();
				i++;
			}
			return programas;
		}
		return arrVacio;
	}
	
	public void seleccionarPrograma(String nombrePF) {
		programa=nombrePF;
			
	}
	
	public String[] getCursos() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		String [] arrVacio = {""};

		if (!mC.getCursos().isEmpty()){
			List<Curso> auxCursos = mC.getCursos();
			String [] cursos = new String[auxCursos.size()];
			int i=0;
			
			for (Curso c: auxCursos) {
				cursos[i]=c.getNombre();
				i++;
			}
			return cursos;
			
		}
		return arrVacio;
	}
	
	
	public void seleccionarCurso(String nombreC) throws CursoEnPFRepetidoException{
		ManejadorCurso mC= ManejadorCurso.getInstancia();
		Curso auxCurso = mC.getCurso(nombreC);
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		ProgFormacion auxPrograma= mPF.getProgFormacion(programa);
		List<ProgFormacion> auxProgramas = auxCurso.getProgramas();
		for (ProgFormacion pf: auxProgramas) {
			if(pf.getNombre().equals(programa))
				throw new CursoEnPFRepetidoException("El curso '" + nombreC + "' ya fue agregado al programa de formación '" +
			programa + "'");

		}
		auxProgramas.add(auxPrograma);
		auxCurso.setProgramas(auxProgramas);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.merge(auxCurso);
		em.getTransaction().commit();

	}

}
