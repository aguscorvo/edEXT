package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatype.DtCursoExp;
import datatype.DtEdicion;
import datatype.DtProgFormacionExp;
import interfaces.IControladorConsultaCurso;

public class ControladorConsultaCurso implements IControladorConsultaCurso{
	
	
	public String[] ingresarInstituto(String instituto){
		
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
	/*
	public String[] getCursosPorCategoria(String categoria) {
		
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		String [] arrCursosVacio = {""};
		if(mc.existeCategoria(categoria)) {
			String [] arrVacio = {""};
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			List<Curso> cursosAux = mc.getCursos();
			List<Categoria> categorias = new ArrayList<Categoria>();
			
			if (!cursosAux.isEmpty()) {
				for (Curso c: cursosAux) {
					List <Categoria> cats = c.getCategorias();
					
					if (cats.contains(pf)) {
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
	*/
	public DtCursoExp seleccionarCurso(String curso){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		
		String nombre = auxCurso.getNombre();
		String desc = auxCurso.getDescripcion();
		int duracion = auxCurso.getDuracion();
		int cantHoras = auxCurso.getCantHoras();
		int creditos = auxCurso.getCreditos();
		Date fechaR = auxCurso.getFechaR();
		String url = auxCurso.getUrl();
		
		List<Edicion> ediciones = auxCurso.getEdiciones();
		List<ProgFormacion> PFs = auxCurso.getProgramas();
		
		List<String> auxEdiciones = new ArrayList<String>();
		List<String> auxPFs = new ArrayList<String>();
		
		for(Edicion e: ediciones)
			auxEdiciones.add(e.getNombreEd());
		
		for(ProgFormacion pf: PFs)
			auxPFs.add(pf.getNombre());
		
		DtCursoExp auxDT = new DtCursoExp(nombre, desc, duracion, cantHoras, creditos, fechaR, url, null, null, auxEdiciones, auxPFs);
		
		return auxDT;
		
		
	}
	
	
	public DtEdicion seleccionarEdicion(String edicion){
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(edicion);
		
		String nombre = auxEdicion.getNombreEd();
		Date fechaI = auxEdicion.getFechaI();
		Date fechaF = auxEdicion.getFechaF();
		int cupo = auxEdicion.getCupo();
		Date fechaPub = auxEdicion.getFechaPub();
		
		DtEdicion auxDT = new DtEdicion(nombre,fechaI,fechaF,cupo,fechaPub);
		
		return auxDT;
		
		
		
		
	}
	
	public DtProgFormacionExp seleccionarProgFormacion(String progFormacion){
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion auxPF = mpf.getProgFormacion(progFormacion);
		
		String nombre = auxPF.getNombre();
		String desc = auxPF.getDescPF();
		Date fechaI = auxPF.getFechaI();
		Date fechaF = auxPF.getFechaF();
		Date fechaAlta = auxPF.getFechaAlta();
		
		List<String> nomCursos = new ArrayList<String>();
		List<Curso> cursos = new ArrayList<Curso>();
		List<ProgFormacion> cursosPFs = new ArrayList<ProgFormacion>();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		cursos = mc.getCursos();
		
		
		for(Curso c: cursos) {
			
			cursosPFs = c.getProgramas();
			
			for(ProgFormacion pf: cursosPFs) {
				
				if(pf.getNombre().equals(nombre)) {
					nomCursos.add(c.getNombre());
					break;
				}	
					
			}
			
		}
		
		DtProgFormacionExp auxDT = new DtProgFormacionExp(nombre, desc, fechaI, fechaF, fechaAlta, nomCursos);
		
		return auxDT;
		
		
		
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
	
	public String[] getEdiciones (String curso) {
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		String[] arrVacio = {""};
		if(mc.existeCurso(curso)) {
			Curso auxCurso = mc.getCurso(curso);
			List<Edicion> edicionesCurso = auxCurso.getEdiciones();
			String [] nomEdiciones = new String[edicionesCurso.size()];
			int i = 0;
			for(Edicion e: edicionesCurso) { 
				nomEdiciones[i] = e.getNombreEd();
				i++;
			}
			
			return nomEdiciones;
		}
		
		return arrVacio;
		
	}
	
	public String [] getPrevias (String curso) {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso auxCurso =mC.getCurso(curso);
		String [] arrVacio={""};
		List<Curso> auxCursos = new ArrayList<Curso>(auxCurso.getMisPrevias());
		
		if (!auxCursos.isEmpty()) {
			String [] previas = new String [auxCursos.size()];
			int i=0;
			for (Curso p: auxCursos) {
				previas[i]=p.getNombre();
				i++;
			}
			return previas;
		}
		return arrVacio;
	}
	
	
	public String[] getPFs (String curso) {
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		String[] arrVacio = {""};
		if(mc.existeCurso(curso)){
			Curso auxCurso = mc.getCurso(curso);
			List<ProgFormacion> progsFormacion = auxCurso.getProgramas();
			String [] nomProgramas = new String[progsFormacion.size()];
			int i = 0;
			for(ProgFormacion pf: progsFormacion) { 
				nomProgramas[i] = pf.getNombre();
				i++;
			}
			
			return nomProgramas;
		}
		
		return arrVacio;
		
	}
	
	
	public String obtenerDatosEdicion(DtEdicion edicion) {
		String fechaI = funcionesAux.convertirAString(edicion.getFechaI());
		String fechaF = funcionesAux.convertirAString(edicion.getFechaF());
		String fechaP = funcionesAux.convertirAString(edicion.getFechaPub());
		String cupo = String.valueOf(edicion.getCupo());
		
		String auxDatos = "Nombre: " + edicion.getNombre() + "\n\nFecha inicio: " + fechaI + "\n\nFecha fin: " + fechaF + "\n\nCupo: " + cupo + "\n\nFecha de publicación: " + fechaP;
		return auxDatos;
		
	}
	
	public String obtenerDatosCurso(DtCursoExp curso) {
		String fechaR = funcionesAux.convertirAString(curso.getFechaR());
		String duracion = String.valueOf(curso.getDuracion());
		String cantHoras = String.valueOf(curso.getCantHoras());
		String creditos = String.valueOf(curso.getCreditos());

		String auxDatos = "Nombre: " + curso.getNombre() + "\n\nDescripción: " + curso.getDesc() + "\n\nDuración: " + duracion + "\n\nCantidad de horas: " + cantHoras + "\n\nCréditos: " + creditos + 
				"\n\nFecha de registro: " + fechaR + "\n\nURL: " + curso.getUrl(); 
		return auxDatos;
		
	}
	
	public String obtenerDatosPrograma(DtProgFormacionExp programa) {
		
		String fechaI = funcionesAux.convertirAString(programa.getFechaI());
		String fechaF = funcionesAux.convertirAString(programa.getFechaF());
		String fechaAlta = funcionesAux.convertirAString(programa.getFechaAlta());
		
		
		String auxDatos = "Nombre: " + programa.getNombre() + "\n\nDescripción: " + programa.getDesc() + "\n\nFecha de inicio: " + fechaI + "\n\nFecha de finalización: " + fechaF + 
				"\n\nFecha de alta: " + fechaAlta;
		
		return auxDatos;

	}


	public String[] getCategorias(String curso) {
		List<Categoria> categorias;
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		categorias = auxCurso.getCategorias(); 
		String[] cat_ret = new String [categorias.size()];
		int i=0;
		for (Categoria c: categorias) {
			cat_ret[i]= c.getNombreCategoria();
			i++;
		}
		return cat_ret;
	}
	
	public String[] getCategoriasGlobal() {
		
		List<Categoria> categorias;
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		categorias = mc.getCategorias();
		String[] cat_ret = new String [categorias.size()];
		int i=0;
		for (Categoria c: categorias) {
			cat_ret[i]= c.getNombreCategoria();
			i++;
		}
		return cat_ret;

		
	}

	
	
	





	
	
}
