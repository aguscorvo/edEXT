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
				for(ProgFormacion pf: programas) {
					nombreProgramas[i] = pf.getNombre();
					i++;
				}
			}
			
			return nombreProgramas;
			
		};
		
		
		public DtProgFormacionExp seleccionarPrograma(String programa) {
			
			ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
			ProgFormacion auxPF = mpf.getProgFormacion(programa);
			String nombre = auxPF.getNombre();
			String desc = auxPF.getDescPF();
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
					if(pf.getNombre().equals(programa)) {
						nomCursos.add(c.getNombre());
						break;
					}
				}
			}
			
			DtProgFormacionExp auxDT = new DtProgFormacionExp(nombre, desc, fechaI, fechaF, fechaAlta, nomCursos);  
																													
			return auxDT;
				
		};
		
		public String [] getCursos(DtProgFormacionExp dtProg) {
			String [] arrVacio = {""};
			List<String> auxCursos = dtProg.getCursos();
			if (!dtProg.getCursos().isEmpty()) {
				String [] cursos = new String [dtProg.getCursos().size()];
				int i=0;
				for(String c: auxCursos) {
					cursos[i]=c;
					i++;
				}
				return cursos;
			}
			return arrVacio;
		}
		
		
		
		public DtCursoExp seleccionarCurso(String curso) {
			
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			Curso auxCurso = mc.getCurso(curso);
			
			String nombre = auxCurso.getNombre();
			String desc = auxCurso.getDescripcion();
			int duracion = auxCurso.getDuracion();
			int cantHoras = auxCurso.getCantHoras();
			int creditos = auxCurso.getCreditos();
			Date fechaR = auxCurso.getFechaR();
			String url = auxCurso.getUrl();
			
			List<Edicion> edicionesCurso = auxCurso.getEdiciones();
			List<ProgFormacion> progsFormacionCurso = auxCurso.getProgramas();
			List<Categoria> categorias = auxCurso.getCategorias();
			
			List<String> nomEdiciones = new ArrayList<String>();
			List<String> nomPFs = new ArrayList<String>();
			List<String> nomCat = new ArrayList<String>();
			
			for(Edicion e: edicionesCurso)
				nomEdiciones.add(e.getNombreEd());
				
			for(ProgFormacion pf: progsFormacionCurso)
				nomPFs.add(pf.getNombre());
				
			for(Categoria c: categorias)
				nomCat.add(c.getNombreCategoria());
					
			DtCursoExp auxDT = new DtCursoExp(nombre, desc, duracion, cantHoras, creditos, fechaR, url, null, nomCat, nomEdiciones, nomPFs);
			
			return auxDT;


		}
		
		public String obtenerDatosPrograma(DtProgFormacionExp programa) {
			String nombre = programa.getNombre();
			String desc = programa.getDesc();
			Date auxFechaI = programa.getFechaI();
			Date auxFechaF = programa.getFechaF();
			Date auxFechaAlta = programa.getFechaAlta();
			String fechaI = funcionesAux.convertirAString(auxFechaI);
			String fechaF = funcionesAux.convertirAString(auxFechaF);
			String fechaAlta = funcionesAux.convertirAString(auxFechaAlta);
			String aRetornar = "Nombre: " + nombre + "\n\nDescripción: " + desc + "\n\nFecha de inicio: " + fechaI + "\n\nFecha de finalización: " + fechaF + "\n\n"
					+ "Fecha de alta: " + fechaAlta;
			
			return aRetornar;
			
		}
		
		public String obtenerDatosCurso(DtCursoExp curso) {
			String nombre = curso.getNombre();
			String desc = curso.getDesc();
			int duracion = curso.getDuracion();
			int cantHoras = curso.getCantHoras();
			int creditos = curso.getCreditos();
			Date auxFechaR = curso.getFechaR();
			String fechaR = funcionesAux.convertirAString(auxFechaR);
			String url = curso.getUrl();
			String aRetornar = "Nombre: " + nombre + "\n\nDescripción: " + desc+ "\n\nDuración: " + duracion+ "\n\nCantidad de horas: " + cantHoras + "\n\nCréditos: " 
			+ creditos + "\n\nFecha de registro: " + fechaR+ "\n\nURL: " + url;
			
			return aRetornar;	
			
		}


	
		public String[] getCategoriasPrograma(String programa) {
			String [] arrVacio = {""};
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
			ProgFormacion pf = mp.getProgFormacion(programa);
			List<Curso> cursosAux = mc.getCursos();
			List<Categoria> categorias = new ArrayList<Categoria>();
			
			if (!cursosAux.isEmpty()) {
				for (Curso c: cursosAux) {
					List <ProgFormacion> progs = c.getProgramas();
					if (progs.contains(pf)) {
						List<Categoria> cats = c.getCategorias();
						for (int j = 0; j < cats.size(); ++j) {
							if (!categorias.contains(cats.get(j))){
								categorias.add(cats.get(j));
							}
						}
					}
				}
				if (!categorias.isEmpty()) {
					String[] lasCat = new String [categorias.size()];
					int i = 0;
					for(Categoria c: categorias) {
						lasCat[i]=c.getNombreCategoria();
						i++;
					}
					return lasCat;
				}
				else return arrVacio;
			}
			else return arrVacio;
		}

}
		
		
	