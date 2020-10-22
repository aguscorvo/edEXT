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
			nombreEdiciones.add(e.getNombreEd());
		
		return nombreEdiciones;
		
	};
	
	public DtEdicion ingresarEdicion(String edicion) {
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(edicion);
		DtEdicion auxDT = new DtEdicion(auxEdicion.getNombreEd(), auxEdicion.getFechaI(), auxEdicion.getFechaF(), auxEdicion.getCupo(), auxEdicion.getFechaPub());
		
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
	
	public String[] getCursosPorCategoria(String categoria) {
		String [] arrVacio = {""};
		ManejadorCategoria mca = ManejadorCategoria.getInstancia();
		ManejadorCurso mcu = ManejadorCurso.getInstancia();
		Categoria cat = mca.getCategoria(categoria);
		List<Curso> cursosAux = mcu.getCursos();
		List<Curso> cursos = new ArrayList<Curso>();
		
		if (!cursosAux.isEmpty()) {
			for (Curso c: cursosAux) {
				List <Categoria> cats = c.getCategorias();
				if (cats.contains(cat)) {
					cursos.add(c);
				}
			}
			if (!cursos.isEmpty()) {
				String[] losCur = new String [cursos.size()];
				int i = 0;
				for(Curso c: cursos) {
					losCur[i]=c.getNombre();
					i++;
				}
				return losCur;
			}
			else return arrVacio;
		}
		else return arrVacio;
	}
	
	
	public String[] getEdiciones(String curso){
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		if(mc.existeCurso(curso)) {
			Curso auxCurso = mc.getCurso(curso);
			List<Edicion> ediciones = auxCurso.getEdiciones();
			String [] arrEdiciones = new String [ediciones.size()];
			
			int i=0;
			
			for(Edicion e: ediciones) {
				
				arrEdiciones[i] = e.getNombreEd();
				i++;
			}
			return arrEdiciones;

		}
		
		String[] arrEdicionesVacio =  {""};
		return arrEdicionesVacio;
	}
	
	public String getDocentesAsignados(String edicion) {
		
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		List<Usuario> usuarios = mu.getUsuarios();
		List<String> docentesNom = new ArrayList<String>();
		List<String> docentesAp = new ArrayList<String>();
		
		if(me.existeEdicion(edicion)) {
			Edicion auxEd = me.getEdicion(edicion);
			for (Usuario u: usuarios) {
				if (u instanceof Docente) {
					boolean estaAsoc = false;
					List<Edicion> ediciones = ((Docente) u).getEdiciones();
					for (Edicion e: ediciones) {
						if (e.getNombreEd().equals(edicion)) 
							estaAsoc = true;
					}
					if (estaAsoc) {
						docentesNom.add(((Docente) u).getNombre());
						docentesAp.add(((Docente)u).getApellido());
					}
				}
			}

		}
		int cantElem = docentesNom.size();
		int cont = 0;
		String cadenaDoc = "";
		while (!docentesNom.isEmpty() && !docentesAp.isEmpty() && cont<cantElem) {
			cadenaDoc = cadenaDoc + docentesNom.get(cont) + " " + docentesAp.get(cont) + "<br>";
			cont++;
		}
		
		return cadenaDoc;
	}
	
	public String obtenerDatosBasicosEd(String edicion) {
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion e = me.getEdicion(edicion);
	
		String fechaI = funcionesAux.convertirAString(e.getFechaI());
		String fechaF = funcionesAux.convertirAString(e.getFechaF());
		String fechaP = funcionesAux.convertirAString(e.getFechaPub());
		String cupo = String.valueOf(e.getCupo());
		
		String auxDatos = "Nombre: " + e.getNombreEd() + "<br><br>Fecha inicio:" + fechaI + "<br>Fecha fin: " + fechaF + "<br><br>Cupo: " + cupo + "<br><br>Fecha de publicación: <br>" + fechaP;
		return auxDatos;
		
	}

	public String obtenerDatosEdicion(DtEdicion edicion) {
		String fechaI = funcionesAux.convertirAString(edicion.getFechaI());
		String fechaF = funcionesAux.convertirAString(edicion.getFechaF());
		String fechaP = funcionesAux.convertirAString(edicion.getFechaPub());
		String cupo = String.valueOf(edicion.getCupo());
		
		String auxDatos = "Nombre: " + edicion.getNombre() + "<br><br>Fecha inicio: " + fechaI + "<br>Fecha fin: " + fechaF + "<br><br>Cupo: " + cupo + "<br><br>Fecha de publicación: " + fechaP;
		return auxDatos;
		
	}

	public DtEdicion getDatosEdicion() {
		return datosEdicion;
	}


	public void setDatosEdicion(DtEdicion datosEdicion) {
		this.datosEdicion = datosEdicion;
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
