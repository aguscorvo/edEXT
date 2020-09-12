package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatype.DtCursoExp;
import datatype.DtProgFormacionExp;
import interfaces.IControladorConsultaProgFormacion;


public class ControladorConsultaProgFormacion implements IControladorConsultaProgFormacion {

	
		public String[] getProgramasDeFormacion() {
			
			ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
			List<ProgFormacion> programas = mpf.getProgFormacion();
			String[] nombreProgramas = new String[programas.size()];
			if(nombreProgramas.length != 0) {
				int i = 0;
				for(ProgFormacion pf: programas)
					nombreProgramas[i] = pf.getNombre();
			}
			
			return nombreProgramas;
			
		};
		
		
		public DtProgFormacionExp seleccionarPrograma(String programa) {
			
			ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
				
			ProgFormacion auxPF = mpf.getProgFormacion(programa);
			String nombre = auxPF.getNombre();
			String desc = auxPF.getDesc();
			Date fechaI = auxPF.getFechaI();
			Date fechaF = auxPF.getFechaF();
			Date fechaAlta = auxPF.getFechaAlta();
			
			
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			List<Curso> cursos = mc.getCursos();
			List<String> nomCursos = new ArrayList<String>();
			List<ProgFormacion> cursosPFs = new ArrayList<ProgFormacion>();
			
			for(Curso c: cursos) {
				cursosPFs = c.getProgramas();
				for(ProgFormacion pf: cursosPFs) {
					if(pf.getNombre().equals(c.getNombre())) {
						nomCursos.add(c.getNombre());
						break;
					}
				}
			}
			
			DtProgFormacionExp auxDT = new DtProgFormacionExp(nombre, desc, fechaI, fechaF, fechaAlta, nomCursos); //lo cree con las fechas aunque no aparezca eso en el diseño porque 
																													//me dio lastima y me pareció al pedo ponerlo en null.
			
			return auxDT;
				
		};
		
		
		
		public DtCursoExp seleccionarCurso(String curso) {
			
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			Curso auxCurso = mc.getCurso(curso);
			
			String nombre = auxCurso.getNombre();
			String desc = auxCurso.getDesc();
			int duracion = auxCurso.getDuracion();
			int cantHoras = auxCurso.getCantHoras();
			int creditos = auxCurso.getCreditos();
			Date fechaR = auxCurso.getFechaR();
			String url = auxCurso.getUrl();
			
			List<Edicion> edicionesCurso = auxCurso.getEdiciones();
			List<ProgFormacion> progsFormacionCurso = auxCurso.getProgramas();
			
			List<String> nomEdiciones = new ArrayList<String>();
			List<String> nomPFs = new ArrayList<String>();
			
			for(Edicion e: edicionesCurso)
				nomEdiciones.add(e.getNombre());
				
			for(ProgFormacion pf: progsFormacionCurso)
				nomPFs.add(pf.getNombre());
				
			
			DtCursoExp auxDT = new DtCursoExp(nombre, desc, duracion, cantHoras, creditos, fechaR, url, null, nomEdiciones, nomPFs);
			
			return auxDT;


		}
		

}
