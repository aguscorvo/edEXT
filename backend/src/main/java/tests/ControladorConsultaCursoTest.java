package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtCurso;
import datatype.DtCursoExp;
import datatype.DtDocente;
import datatype.DtEdicion;
import datatype.DtEdicionExp;
import datatype.DtProgFormacion;
import datatype.DtProgFormacionExp;
import excepciones.CategoriaRepetidaException;
import excepciones.CursoEnPFRepetidoException;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaCategoria;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaCurso;
import interfaces.IControladorConsultaProgFormacion;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorConsultaCursoTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorConsultaProgFormacion iCon = f.getIControladorConsultaProgFormacion();
	public static IControladorAltaInstituto iConAltaInstituto =f.getIControladorAltaInstituto();
	public static IControladorAltaCategoria iConAltaCategoria = f.getIControladorAltaCategoria();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaProgFormacion iConAltaPrograma =f.getIControladorAltaProgFormacion();
	public static IControladorAgregarCursoAPF iConAgregarCursoAPF = f.getIControladorAgregarCursoAPF();
	public static IControladorAltaEdicion iConAltaEd = f.getIControladorAltaEdicion();
	public static IControladorAltaUsuario iConAltaUs = f.getIControladorAltaUsuario();
	public static IControladorConsultaCurso iConConCur = f.getIControladorConsultaCurso();
	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, CategoriaRepetidaException, NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException, ProgramaRepetidoException, CursoEnPFRepetidoException, EdicionRepetidaException, UsuarioRepetidoException {
		
		//se crea instituto				
		iConAltaInstituto.ingresarInstituto("institutoNombreTest");
		iConAltaInstituto.confirmarAltaInstituto();		
		
		//se crea categoria
		iConAltaCategoria.ingresarCategoria("categoriaTest");	
		
		//se crean dos cursos
		List<String> categorias = new ArrayList<String>();
		List<String> previas1 = new ArrayList<String>();
		categorias.add("categoriaTest");
		Date fecha = new Date();
		DtCurso auxCurso = new DtCurso ("cursoNombreTest", "cursoDescTest", 0, 0, 0, fecha, "cursoUrlTest", previas1, categorias);
		iConAltaCurso.ingresarCurso("institutoNombreTest", auxCurso);
		iConAltaCurso.confirmarAltaCurso();	
		
		List<String> previas2 = new ArrayList<String>();
		DtCurso auxCurso2 = new DtCurso ("curso2NombreTest", "curso2DescTest", 0, 0, 0, fecha, "curso2UrlTest", previas2, categorias);
		iConAltaCurso.ingresarCurso("institutoNombreTest", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		
		//se crea un docente
		Date fechaNac = new Date();
		DtDocente auxDocente = new DtDocente("docente","Pepito","Rodriguez","d@gmail.com",fechaNac,"d","institutoNombreTest");
		iConAltaUs.ingresarDtUsuario(auxDocente);
		iConAltaUs.confirmarAltaUsuario();
		
		
		//se crean ediciones
		iConAltaEd.ingresarInstituto("institutoNombreTest");
		iConAltaEd.seleccionarCurso("cursoNombreTest");
		Date fechaEd = new Date();
		List<String> docentes = new ArrayList<String>();
		docentes.add("docente");
		DtEdicionExp auxDt1 = new DtEdicionExp("edicion1CursoNombreTest",fechaEd,fechaEd,1,fechaEd,docentes);
		iConAltaEd.ingresarDtEdicion(auxDt1);
		iConAltaEd.confirmarAltaEdicion();
		
		iConAltaEd.ingresarInstituto("institutoNombreTest");
		iConAltaEd.seleccionarCurso("curso2NombreTest");
		DtEdicionExp auxDt2 = new DtEdicionExp("edicion2CursoNombreTest",fechaEd,fechaEd,1,fechaEd,docentes);
		iConAltaEd.ingresarDtEdicion(auxDt2);
		iConAltaEd.confirmarAltaEdicion();

		//se crean programas
		DtProgFormacion pf1 = new DtProgFormacion ("prog1Nombre", "prog1Desc", fecha, fecha, fecha);
		DtProgFormacion pf2 = new DtProgFormacion ("prog2Nombre", "prog2Desc", fecha, fecha, fecha);
		iConAltaPrograma.ingresarProgFormacion(pf1);
		iConAltaPrograma.confirmarAltaPrograma();
		iConAltaPrograma.ingresarProgFormacion(pf2);
		iConAltaPrograma.confirmarAltaPrograma();		
		
		//se agregan cursos a programas
		iConAgregarCursoAPF.seleccionarPrograma("prog1Nombre");
		iConAgregarCursoAPF.seleccionarCurso("cursoNombreTest");
		iConAgregarCursoAPF.seleccionarPrograma("prog1Nombre");
		iConAgregarCursoAPF.seleccionarCurso("curso2NombreTest");
		iConAgregarCursoAPF.seleccionarPrograma("prog2Nombre");
		iConAgregarCursoAPF.seleccionarCurso("curso2NombreTest");	
	}

	@Test
	public void test_1_getProgramasDeFormacion() throws ProgramaRepetidoException {
		String [] institutos = iConConCur.getInstitutos();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Instituto> institutosManejador = mi.getInstitutos();
		String[] arrInstitutosManejador = new String [institutosManejador.size()];
		int i=0;
		for (Instituto in: institutosManejador) {
			arrInstitutosManejador[i]=in.getNombre();
			i++;
		}
		assertArrayEquals(arrInstitutosManejador, institutos);
		
	}

	@Test
	public void test_2_getCursosPorCategoria() {
		String[] cursos = iConConCur.getCursosPorCategoria("categoriaTest");
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] CursosPorCategoriaManejador = new String[cursosManejador.size()];
		int i = 0;
		for(Curso c: cursosManejador) {
			List<Categoria> categorias = c.getCategorias();
			for(Categoria cat: categorias) {
				if(cat.getNombreCategoria().equals("categoriaTest")) {
					CursosPorCategoriaManejador[i] = c.getNombre();
					i++;
				}
			}
		}
		assertArrayEquals(CursosPorCategoriaManejador,cursos);
		
	}
	
	@Test
	public void test_3_getCategoriasGlobal(){
		String[] categorias = iConConCur.getCategoriasGlobal();
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		List<Categoria> categoriasManejador = mc.getCategorias();
		String[] arrCategoriasManejador = new String[categoriasManejador.size()];
		int i = 0;
		for(Categoria cat: categoriasManejador) {
			arrCategoriasManejador[i] = cat.getNombreCategoria();
			i++;
		}
		
		assertArrayEquals(arrCategoriasManejador,categorias);
	}
	
	 @Test
	 public void test_4_ingresarInstituto() {
		 String[] cursos = iConConCur.ingresarInstituto("institutoNombreTest");
		 ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		 List<Instituto> institutosManejador = mi.getInstitutos();
		 String[] arrCursosDeInstitutoManejador = null;
		 int i = 0;
		 for(Instituto ins: institutosManejador){
			 if(ins.getNombre().equals("institutoNombreTest")) {
				 List<Curso> cursosInstituto = ins.getCursos();
				 arrCursosDeInstitutoManejador = new String[cursosInstituto.size()];

				 for(Curso c: cursosInstituto) {
					 arrCursosDeInstitutoManejador[i] = c.getNombre();
					 i++;
					 
				 }
			 }
		 }
		 
		 assertArrayEquals(arrCursosDeInstitutoManejador,cursos);
	 }
	 
	 @Test
	 public void test_5_seleccionarCurso() {
		 
		 DtCursoExp auxDt = iConConCur.seleccionarCurso("cursoNombreTest");
		 String datosCurso = iConConCur.obtenerDatosCurso(auxDt);
		 
		 Boolean test = false; 
		 if(datosCurso.contains(auxDt.getNombre()) && datosCurso.contains(auxDt.getDesc()) 
				 && datosCurso.contains(Integer.toString(auxDt.getDuracion())) 
				 && datosCurso.contains(Integer.toString(auxDt.getCantHoras())) 
				 && datosCurso.contains(Integer.toString(auxDt.getCreditos())) 
				 && datosCurso.contains(funcionesAux.convertirAString(auxDt.getFechaR())) 
				 && datosCurso.contains(auxDt.getUrl()) 
				 && datosCurso.contains((CharSequence) auxDt.getPrevias()) 
				 && datosCurso.contains((CharSequence) auxDt.getCategorias())
				 && datosCurso.contains((CharSequence) auxDt.getEdiciones())
				 && datosCurso.contains((CharSequence) auxDt.getEdiciones())
				 && datosCurso.contains((CharSequence) auxDt.getProgramas())) {
			 test = true;
		 }else test = false;
		 
		 assertTrue(test);
		 
	}
	
	@Test
	public void test_6_seleccionarEdicion() {
		
		DtEdicion aux = iConConCur.seleccionarEdicion("edicion1CursoNombreTest");
		String datosEdicion = iConConCur.obtenerDatosEdicion(aux);
		
		Boolean test = false; 
		if(datosEdicion.contains(aux.getNombre()) && datosEdicion.contains(funcionesAux.convertirAString(aux.getFechaI())) 
				&& datosEdicion.contains(funcionesAux.convertirAString(aux.getFechaF())) 
				&& datosEdicion.contains(Integer.toString(aux.getCupo()))
				&& datosEdicion.contains(funcionesAux.convertirAString(aux.getFechaPub()))){
			test = true;
		}else test = false;
		
		assertTrue(test);
		
	}
	
	@Test
	public void test_7_seleccionarProgFormacion() {
		
		DtProgFormacionExp aux = iConConCur.seleccionarProgFormacion("prog1Nombre");
		String datosPF = iConConCur.obtenerDatosPrograma(aux);
		
		Boolean test = false; 
		if(datosPF.contains(aux.getNombre()) && datosPF.contains(aux.getDesc())
				&& datosPF.contains(funcionesAux.convertirAString(aux.getFechaI()))
				&& datosPF.contains(funcionesAux.convertirAString(aux.getFechaF()))
				&& datosPF.contains(funcionesAux.convertirAString(aux.getFechaAlta()))
				&& datosPF.contains((CharSequence) aux.getCursos())) {
			test = true;
		} else test = false;
		
		assertTrue(test);
	}
	
	@Test
	public void test_8_getPrevias() {
		
		String[] previas = iConConCur.getPrevias("cursoNombreTest");
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] arrPreviasCurso = null;
		
		int i=0;
		for(Curso c: cursosManejador) {
			if(c.getNombre().equals("cursoNombreTest")) {
				List<Curso> previasCurso = c.getMisPrevias();
				arrPreviasCurso = new String[previasCurso.size()];

				for(Curso p: previasCurso) {
					arrPreviasCurso[i] = p.getNombre();
					i++;
				}
			}
		}
		assertArrayEquals(arrPreviasCurso, previas);

	}
	
	@Test
	public void test_9_getCategorias() {
		
		String[] categorias = iConConCur.getCategorias("cursoNombreTest");
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] arrCategoriasCurso = null;
		
		int i = 0;
		for(Curso c: cursosManejador) {
			if(c.getNombre().equals("cursoNombreTest")) {
				List<Categoria> catsCurso = c.getCategorias();
				arrCategoriasCurso = new String[catsCurso.size()];
				for(Categoria cat: catsCurso) {
					arrCategoriasCurso[i] = cat.getNombreCategoria();
					i++;
				}
			}
		}
		assertArrayEquals(arrCategoriasCurso, categorias);
	}
	
	@Test
	public void test_10_getEdiciones() {
		
		String[] ediciones = iConConCur.getEdiciones("cursoNombreTest");
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] arrEdicionesCurso = null;
		
		int i=0;
		for(Curso c: cursosManejador) {
			if(c.getNombre().equals("cursoNombreTest")) {
				List<Edicion> edicionesCurso = c.getEdiciones();
				arrEdicionesCurso = new String[edicionesCurso.size()];
				for(Edicion e: edicionesCurso) {
					arrEdicionesCurso[i] = e.getNombreEd();
					i++;
				}
			}
		}
		
		assertArrayEquals(arrEdicionesCurso, ediciones);

		
	}
	
	@Test
	public void test_11_getPFs() {
		
		String[] programas = iConConCur.getPFs("cursoNombreTest");
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] arrProgramasCurso = null;
		
		int i = 0;
		for(Curso c: cursosManejador) {
			if(c.getNombre().equals("cursoNombreTest")) {
				List<ProgFormacion> programasCurso = c.getProgramas();
				arrProgramasCurso = new String[programasCurso.size()];
				for(ProgFormacion pf: programasCurso) {
					arrProgramasCurso[i] = pf.getNombre();
					i++;
				}
			}
		}
		
		assertArrayEquals(arrProgramasCurso, programas);

	}
}
