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
import datatype.DtDocente;
import datatype.DtEdicion;
import datatype.DtEdicionExp;
import excepciones.CategoriaRepetidaException;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
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
import interfaces.IControladorConsultaEdicion;
import interfaces.IControladorConsultaProgFormacion;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorInstituto;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorConsultaEdicionTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorConsultaProgFormacion iCon = f.getIControladorConsultaProgFormacion();
	public static IControladorAltaInstituto iConAltaInstituto =f.getIControladorAltaInstituto();
	public static IControladorAltaCategoria iConAltaCategoria = f.getIControladorAltaCategoria();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaProgFormacion iConAltaPrograma =f.getIControladorAltaProgFormacion();
	public static IControladorAgregarCursoAPF iConAgregarCursoAPF = f.getIControladorAgregarCursoAPF();
	public static IControladorAltaEdicion iConAltaEd = f.getIControladorAltaEdicion();
	public static IControladorAltaUsuario iConAltaUs = f.getIControladorAltaUsuario();
	public static IControladorConsultaEdicion iConConEd = f.getIControladorConsultaEdicion();

	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, CategoriaRepetidaException, NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException, UsuarioRepetidoException, EdicionRepetidaException {
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

	}
	
	@Test
	public void test_1_ingresarInstituto() {
		List<String> cursos = iConConEd.ingresarInstituto("institutoNombreTest");
		String[] arrCursos = new String[cursos.size()];
		int j = 0;
		for(String s: cursos) {
			arrCursos[j] = s;
			j++;
		}
			
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Instituto> institutosManejador = mi.getInstitutos();
		String[] arrCursosInstituto = null;
		
		int i = 0;
		for(Instituto ins: institutosManejador) {
			if(ins.getNombre().equals("institutoNombreTest")) {
				List<Curso> cursosInst = ins.getCursos();
				arrCursosInstituto = new String[cursosInst.size()];
				for(Curso c: cursosInst) {
					arrCursosInstituto[i] = c.getNombre();
					i++;
				}
			}
			
		}
		
		assertArrayEquals(arrCursosInstituto,arrCursos);
		
		
	}
	
	@Test
	public void test_2_ingresarCurso() {
		List<String> nomEdiciones = iConConEd.ingresarCurso("cursoNombreTest");
		String[] arrNomEdiciones = new String[nomEdiciones.size()];
		int j = 0;
		for(String e: nomEdiciones) {
			arrNomEdiciones[j] = e;
			j++;
		}
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String [] arrEdicionesCurso = null;
		
		int i = 0;
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
		assertArrayEquals(arrEdicionesCurso, arrNomEdiciones);

		
	}
	
	@Test
	public void test_3_ingresarEdicion() {
		
		DtEdicion aux = iConConEd.ingresarEdicion("edicion1CursoNombreTest");
		String datos = iConConEd.obtenerDatosEdicion(aux);
		
		Boolean test = false; 
		 if(datos.contains(aux.getNombre()) && datos.contains(funcionesAux.convertirAString(aux.getFechaI())) 
				 && datos.contains(funcionesAux.convertirAString(aux.getFechaF())) 
				 && datos.contains(Integer.toString(aux.getCupo())) 
				 && datos.contains(funcionesAux.convertirAString(aux.getFechaPub()))) {
			 test = true;
		 }else test = false;
		 
		 assertTrue(test);

		
	}
	
	@Test
	public void test_4_getInstitutos() {
		
		String[] institutos = iConConEd.getInstitutos();
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Instituto> institutosManejador = mi.getInstitutos();
		String[] arrInstitutosManejador = new String[institutosManejador.size()];
		
		int i = 0;
		for(Instituto ins: institutosManejador) {
			arrInstitutosManejador[i] = ins.getNombre();
			i++;
		}
		
		assertArrayEquals(arrInstitutosManejador,institutos);
	}
	
	
	@Test
	public void test_5_getCategoriasGlobal(){
		String[] categorias = iConConEd.getCategoriasGlobal();
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
	public void test_6_getCursos() {
		 
		 String[] cursos = iConConEd.getCursos("institutoNombreTest");
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
	public void test_7_getCursosPorCategoria() {
		String[] cursos = iConConEd.getCursosPorCategoria("categoriaTest");
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
	public void test_8_getEdiciones() {
		
		String[] ediciones = iConConEd.getEdiciones("cursoNombreTest");
		
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
	
	
	
	
	
		
	
}
