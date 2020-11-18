package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
import datatype.DtEdicionExp;
import datatype.DtEstudiante;
import datatype.EstadoInscripcion;
import excepciones.CategoriaRepetidaException;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteEdicionVigenteException;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorInscripcionAEdicion;
import interfaces.IControladorInscripcionAPrograma;
import interfaces.IControladorSeleccionarEstudiantes;
import logica.Edicion;
import logica.ManejadorEdicion;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorInscripcionAEdicionTest {
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorInscripcionAEdicion iCon = f.getIControladorInscripcionAEdicion();
	public static IControladorAltaInstituto iConAltaInstituto = f.getIControladorAltaInstituto();
	public static IControladorAltaCategoria iConAltaCategoria = f.getIControladorAltaCategoria();
	public static IControladorAltaUsuario iConAltaUsuario = f.getIControladorAltaUsuario();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion iConAltaEdicion = f.getIControladorAltaEdicion();
	public static IControladorSeleccionarEstudiantes iConSelEstudiante = f.getIControladorSeleccionarEstudiantes();
	public static IControladorInscripcionAPrograma iConInsPrograma = f.getIControladorInscripcionAPrograma();
	
	@BeforeClass
	public static void inicializarTest() throws InstitutoRepetidaException, CategoriaRepetidaException, UsuarioRepetidoException, 
	NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException, EdicionRepetidaException {
		//creo instituto
		iConAltaInstituto.ingresarInstituto("instituto78978");
		iConAltaInstituto.confirmarAltaInstituto();
		//creo categoria
		iConAltaCategoria.ingresarCategoria("categoria12312");
		iConAltaCategoria.ingresarCategoria("categoria123122");
		//creo usuarios docente y estudiantes
		Date fecha = new Date();
		DtEstudiante auxEstudiante = new DtEstudiante ("estudiante465", "nombre", "apellido", "correo546", fecha, "contrasenia");
		iConAltaUsuario.ingresarDtUsuario(auxEstudiante);
		iConAltaUsuario.confirmarAltaUsuario();
		DtEstudiante auxEstudiante2 = new DtEstudiante ("estudiante451", "nombre", "apellido", "correo5453", fecha, "contrasenia");
		iConAltaUsuario.ingresarDtUsuario(auxEstudiante2);
		iConAltaUsuario.confirmarAltaUsuario();
		DtDocente auxDocente = new DtDocente ("docente4557", "nombre", "apellido", "correo4457", fecha, "contrasenia", "instituto78978");
		iConAltaUsuario.ingresarDtUsuario(auxDocente);
		iConAltaUsuario.confirmarAltaUsuario();
		//creo cursos
		List<String> previas = new ArrayList<String>();
		List<String> categorias = new ArrayList<String>();
		categorias.add("categoria12312");
		DtCurso auxCurso1 = new DtCurso ("curso1_asdas", "desc", 1, 1, 1, fecha, "url", previas, categorias);
		iConAltaCurso.ingresarCurso("instituto78978", auxCurso1);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso2 = new DtCurso ("curso2_asda", "desc", 1, 1, 1, fecha, "url", previas, categorias);
		iConAltaCurso.ingresarCurso("instituto78978", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso3 = new DtCurso ("curso3_asd", "desc", 1, 1, 1, fecha, "url", previas, categorias);//sin edicion
		iConAltaCurso.ingresarCurso("instituto78978", auxCurso3);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso4 = new DtCurso ("curso4_asd", "desc", 1, 1, 1, fecha, "url", previas, categorias);
		iConAltaCurso.ingresarCurso("instituto78978", auxCurso4);
		iConAltaCurso.confirmarAltaCurso();
		//creo dos ediciones	
		String fechaV= "01/01/2001";
		String fechaV2= "10/01/2001";
		Date fechaVieja = funcionesAux.convertirADate(fechaV);
		Date fechaVieja2 = funcionesAux.convertirADate(fechaV2);
		String fechaI = "15/11/2020";
		String fechaF = "01/01/2021";
		Date fechaInicio = funcionesAux.convertirADate(fechaI);
		Date fechaFin = funcionesAux.convertirADate(fechaF);
		iConAltaEdicion.seleccionarCurso("curso1_asdas");
		List<String> docentes = new ArrayList<String>();
		docentes.add("docente4557");
		DtEdicionExp auxEdicion1 = new DtEdicionExp ("edicion1_1231212", fechaInicio, fechaFin, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion1);
		iConAltaEdicion.confirmarAltaEdicion();
		iConAltaEdicion.seleccionarCurso("curso2_asda");
		DtEdicionExp auxEdicion2 = new DtEdicionExp ("edicion2_123125151", fechaVieja, fechaVieja2, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion2);
		iConAltaEdicion.confirmarAltaEdicion();
		iConAltaEdicion.seleccionarCurso("curso4_asd");
		DtEdicionExp auxEdicion4 = new DtEdicionExp ("edicion4_123125151", fechaInicio, fechaFin, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion4);
		iConAltaEdicion.confirmarAltaEdicion();		
	}
	
	@Test
	public void test_01_ingresarInstituto() {
		String [] cursos = iCon.ingresarInstituto("instituto78978");
		String [] cursosOK = {"curso1_asdas", "curso2_asda", "curso3_asd", "curso4_asd"};
		assertArrayEquals(cursosOK, cursos);
	}
	
	@Test
	public void test_02_getCategoriasGlobal() {
		String [] categorias =iCon.getCategoriasGlobal();
		String [] categoriasOK = {"categoria12312", "categoria123122"};
		assertArrayEquals(categoriasOK, categorias);		
	}
	
	@Test
	public void test_03_getCursosPorCategoria() {
		String [] cursosPorCategoria = iCon.getCursosPorCategoria("categoria12312");
		String [] cursosOk = {"curso1_asdas", "curso2_asda", "curso3_asd", "curso4_asd"};
		assertArrayEquals(cursosOk, cursosPorCategoria);
	}
	
	@Test
	public void test_04_getCursosPorCategoriaVacia() {
		String [] cursosPorCategoria = iCon.getCursosPorCategoria("categoria123122");
		String [] cursosOk = {""};
		assertArrayEquals(cursosOk, cursosPorCategoria);
	}
	
	@Test
	public void test_05_ingresarCursoOK() throws NoExisteEdicionVigenteException {
		String edicion = iCon.ingresarCurso("curso1_asdas");
		String edicionOK = "edicion1_1231212";
		assertEquals(edicionOK, edicion);
	}
	
	@Test (expected = NoExisteEdicionVigenteException.class)
	public void test_06_ingresarCursoERRORSinEdicion() throws NoExisteEdicionVigenteException {
		String edicion = iCon.ingresarCurso("curso3_asd");		
	}
	
	@Test (expected = NoExisteEdicionVigenteException.class)
	public void test_07_ingresarCursoERROREdicionNoVigente() throws NoExisteEdicionVigenteException {
		String edicion = iCon.ingresarCurso("curso2_asda");		
	}
	
	@Test
	public void test_08_obtenerDatosBasicosEd() throws NoExisteEdicionVigenteException {
		String edicion = iCon.ingresarCurso("curso1_asdas");
		String datos = iCon.obtenerDatosBasicosEd();
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion edicionTest = mE.getEdicion(edicion);
		Boolean test=false;
		if(datos.contains(edicionTest.getNombreEd()) && datos.contains(funcionesAux.convertirAString(edicionTest.getFechaI())) &&
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaF())) && datos.contains(Integer.toString(edicionTest.getCupo())) && 
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaPub())) ){
			test=true;
		}		
		assertTrue(test);
	}
	
	@Test
	public void test_09_tieneInscripcionFalse() throws NoExisteEdicionVigenteException {
		Date fecha = new Date();
		iCon.ingresarCurso("curso1_asdas");
		iCon.ingresarEstudiante("estudiante465", fecha);
		Boolean tiene = iCon.tieneInscripcion();
		assertFalse(tiene);
	}
	
	@Test
	public void test_10_confirmarInscripcionAEdicionPrimeraVez() throws NoExisteEdicionVigenteException {
		Date fecha = new Date();
		iCon.ingresarCurso("curso1_asdas");
		iCon.ingresarEstudiante("estudiante465", fecha);
		iCon.confirmarInscripcionAEdicion();		
		Boolean tiene = iCon.tieneInscripcion();
		assertTrue(tiene);
	}
	
	@Test
	public void test_11_chequearEstudianteEdicion() throws NoExisteEdicionVigenteException {
		Date fecha = new Date();
		iCon.ingresarCurso("curso1_asdas");
		iCon.ingresarEstudiante("estudiante465", fecha);
		EstadoInscripcion e= iCon.chequearEstudianteEdicion();
		EstadoInscripcion eOK = EstadoInscripcion.INSCRIPTO;
		assertEquals(eOK, e);
	}
		
	@Test
	public void test_12_tieneInscripcionTrue() throws NoExisteEdicionVigenteException {
		Date fecha = new Date();
		iCon.ingresarCurso("curso1_asdas");
		iCon.ingresarEstudiante("estudiante465", fecha);
		Boolean tiene = iCon.tieneInscripcion();
		assertTrue(tiene);
	}
	
	@Test 
	public void test_13_confirmarInscripcionAEdicionDespuesDeRechazado() throws NoExisteEdicionVigenteException, 
	NoEsProfesorDeEdicionVigenteException { // precondicion el test 10 tiene que haber dado OK
		//inscribo a estudiante465 a edicion4_123125151
		Date fecha = new Date();
		iCon.ingresarCurso("curso4_asd");
		iCon.ingresarEstudiante("estudiante465", fecha);
		iCon.confirmarInscripcionAEdicion();		
		//rechazo la inscripcion
		String[] estudiantes = {"estudiante465"};	
		iConSelEstudiante.ingresarCurso("curso4_asd", "docente4557");
		iConSelEstudiante.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.RECHAZADO, "edicion4_123125151");
		//el estudiante estudiante465 se vuelve a inscribir
		iCon.ingresarCurso("curso4_asd");
		iCon.ingresarEstudiante("estudiante465", fecha);
		iCon.confirmarInscripcionAEdicion();
		Boolean tiene = iCon.tieneInscripcion();
		assertTrue(tiene);		
	}
	
	@Test
	public void test_14_getInstitutosNotNull() {
		String [] institutos = iCon.getInstitutos();
		assertNotNull(institutos);		
	}
	
	@Test
	public void test_15_getCursos() {
		String [] cursos = iCon.getCursos("instituto78978");
		
		Boolean curso1=false;
		Boolean curso2=false;
		Boolean curso3=false;
		Boolean curso4=false;
		
		for (String c : cursos) {
			if (c.equals("curso1_asdas"))
				curso1=true;
			else if(c.equals("curso2_asda"))
				curso2=true;
			else if(c.equals("curso3_asd"))
				curso3=true;
			else if(c.equals("curso4_asd"))
				curso4=true;
		}
		Boolean test=false;
		if (curso1 && curso2 && curso3 && curso4)
			test=true;
		
		assertTrue(test);
	}
	
	@Test
	public void test_16_getEstudiantesNoInscriptos() {
		String [] estudiantes =iCon.getEstudiantes("edicion2_123125151");
		String [] estudiantesOK = {"estudiante465", "estudiante451"};
		assertArrayEquals(estudiantesOK, estudiantes);
	}
	
	@Test
	public void test_17_getEstudiantesInscriptos() {		
		String [] estudiantes =iCon.getEstudiantes("edicion4_123125151");
		String [] estudiantesOK = {"estudiante451",};
		assertArrayEquals(estudiantesOK, estudiantes);
	}
	

}
