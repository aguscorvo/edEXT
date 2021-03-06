package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
import logica.ManejadorEdicion;
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
		iConAltaInstituto.ingresarInstituto("instituto144");
		iConAltaInstituto.confirmarAltaInstituto();		
		
		//se crean categorias
		iConAltaCategoria.ingresarCategoria("categoria7u46");
		iConAltaCategoria.ingresarCategoria("categoriaSinCursos");			
		
		//se crean dos cursos
		List<String> categorias = new ArrayList<String>();
		List<String> previas1 = new ArrayList<String>();
		categorias.add("categoria7u46");
		Date fecha = new Date();
		DtCurso auxCurso = new DtCurso ("curso75754", "cursoDescTest", 0, 0, 0, fecha, "cursoUrlTest", previas1, categorias);
		iConAltaCurso.ingresarCurso("instituto144", auxCurso);
		iConAltaCurso.confirmarAltaCurso();	
		
		List<String> previas2 = new ArrayList<String>();
		DtCurso auxCurso2 = new DtCurso ("curso_2", "curso2DescTest", 0, 0, 0, fecha, "curso2UrlTest", previas2, categorias);
		iConAltaCurso.ingresarCurso("instituto144", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		
		//se crea un docente634
		Date fechaNac = new Date();
		DtDocente auxDocente = new DtDocente("docente634","Pepito","Rodriguez","d312@gmail.com",fechaNac,"d","instituto144");
		iConAltaUs.ingresarDtUsuario(auxDocente);
		iConAltaUs.confirmarAltaUsuario();
		
		
		//se crean ediciones
		iConAltaEd.ingresarInstituto("instituto144");
		iConAltaEd.seleccionarCurso("curso75754");
		Date fechaEd = new Date();
		List<String> docentes = new ArrayList<String>();
		docentes.add("docente634");
		DtEdicionExp auxDt1 = new DtEdicionExp("edicion1_12132",fechaEd,fechaEd,1,fechaEd,docentes);
		iConAltaEd.ingresarDtEdicion(auxDt1);
		iConAltaEd.confirmarAltaEdicion();
		
		iConAltaEd.ingresarInstituto("instituto144");
		iConAltaEd.seleccionarCurso("curso_2");
		DtEdicionExp auxDt2 = new DtEdicionExp("edicion2_12132",fechaEd,fechaEd,1,fechaEd,docentes);
		iConAltaEd.ingresarDtEdicion(auxDt2);
		iConAltaEd.confirmarAltaEdicion();

	}
	
	@Test
	public void test_1_ingresarInstituto() {
		List<String> cursos = iConConEd.ingresarInstituto("instituto144");
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
			if(ins.getNombre().equals("instituto144")) {
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
		List<String> nomEdiciones = iConConEd.ingresarCurso("curso75754");
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
			if(c.getNombre().equals("curso75754")) {
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
		
		DtEdicion aux = iConConEd.ingresarEdicion("edicion1_12132");
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
		 
		 String[] cursos = iConConEd.getCursos("instituto144");
		 ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		 List<Instituto> institutosManejador = mi.getInstitutos();
		 String[] arrCursosDeInstitutoManejador = null;
		 int i = 0;
		 for(Instituto ins: institutosManejador){
			 if(ins.getNombre().equals("instituto144")) {
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
		String[] cursos = iConConEd.getCursosPorCategoria("categoria7u46");
		String [] cursosOK = {"curso75754", "curso_2"};
		assertArrayEquals(cursosOK,cursos);		
	}
	
	@Test
	public void test_8_getEdiciones() {
		
		String[] ediciones = iConConEd.getEdiciones("curso75754");
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador = mc.getCursos();
		String[] arrEdicionesCurso = null;
		
		int i=0;
		for(Curso c: cursosManejador) {
			if(c.getNombre().equals("curso75754")) {
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
	public void test_9_getDocentesAsignados() {
		String docentes = iConConEd.getDocentesAsignados("edicion1_12132");
		Boolean test=false;
		if(docentes.contains("Pepito")) {
			test=true;
		}
		assertTrue(test);
	}
	
	@Test
	public void test_10_obtenerDatosBasicosEd() {		
		String datos = iConConEd.obtenerDatosBasicosEd("edicion1_12132");
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion edicionTest = mE.getEdicion("edicion1_12132");
		Boolean test=false;
		if(datos.contains(edicionTest.getNombreEd()) && datos.contains(funcionesAux.convertirAString(edicionTest.getFechaI())) &&
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaF())) && datos.contains(Integer.toString(edicionTest.getCupo())) && 
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaPub())) ){
			test=true;
		}		
		assertTrue(test);
	}
	
	@Test
	public void test_11_getDatosEdicion() {
		DtEdicion edicion = iConConEd.ingresarEdicion("edicion1_12132");
		edicion.setCupo(777);
		iConConEd.setDatosEdicion(edicion);
		DtEdicion edicionATestear = iConConEd.getDatosEdicion();
		assertEquals(777, edicionATestear.getCupo());	
	}
	
	@Test
	public void test_12_getCursosPorCategoriaVacio() {
		String[] cursos = iConConEd.getCursosPorCategoria("categoriaSinCursos");
		String [] cursosOK = {""};
		assertArrayEquals(cursosOK,cursos);		
	}
	
	
	
	
		
	
}
