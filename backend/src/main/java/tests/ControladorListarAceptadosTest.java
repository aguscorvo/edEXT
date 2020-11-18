package tests;

import static org.junit.Assert.assertArrayEquals;
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
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteEdicionVigenteException;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorInscripcionAEdicion;
import interfaces.IControladorListarAceptados;
import interfaces.IControladorSeleccionarEstudiantes;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorListarAceptadosTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorListarAceptados iCon = f.getIControladorListarAceptados();
	public static IControladorAltaInstituto iConAltaInstituto = f.getIControladorAltaInstituto();
	public static IControladorAltaUsuario iConAltaUsuario = f.getIControladorAltaUsuario();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion iConAltaEdicion = f.getIControladorAltaEdicion();
	public static IControladorInscripcionAEdicion iConInsAEdicion = f.getIControladorInscripcionAEdicion();
	public static IControladorSeleccionarEstudiantes iConSelEstudiantes = f.getIControladorSeleccionarEstudiantes();
	
	@BeforeClass
	public static void inicializarTest() throws InstitutoRepetidaException, UsuarioRepetidoException, NoExisteInstitutoException, 
	CursoRepetidoException, NoExisteCursoException, EdicionRepetidaException, NoExisteEdicionVigenteException, 
	NoEsProfesorDeEdicionVigenteException {
		iConAltaInstituto.ingresarInstituto("instituto123124");
		iConAltaInstituto.confirmarAltaInstituto();
		
		Date fecha = new Date();
		String fechaI = "15/11/2020";
		String fechaF = "01/01/2021";
		String fechaV= "01/01/2001";
		String fechaV2= "10/01/2001";
		Date fechaVieja = funcionesAux.convertirADate(fechaV);
		Date fechaVieja2 = funcionesAux.convertirADate(fechaV2);
		Date fechaInicio = funcionesAux.convertirADate(fechaI);
		Date fechaFin = funcionesAux.convertirADate(fechaF);

		DtDocente auxDocente = new DtDocente ("docenteEnEdicion", "nombre", "apellido", "correo1231231", fecha, "d", "instituto123124");
		iConAltaUsuario.ingresarDtUsuario(auxDocente);
		iConAltaUsuario.confirmarAltaUsuario();
		DtDocente auxDocente2 = new DtDocente ("docenteSinEdicion", "nombre", "apellido", "correo12312311", fecha, "d", "instituto123124");
		iConAltaUsuario.ingresarDtUsuario(auxDocente2);
		iConAltaUsuario.confirmarAltaUsuario();
		DtEstudiante auxEstudiante = new DtEstudiante ("estudiante1231231", "nombre", "apellido", "correo1211", fecha, "e");
		iConAltaUsuario.ingresarDtUsuario(auxEstudiante);
		iConAltaUsuario.confirmarAltaUsuario();
		
		List<String> listaVacia = new ArrayList<String>();
		DtCurso auxCurso = new DtCurso ("nombreCurso123123", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto123124", auxCurso);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso2 = new DtCurso ("cursoSinEdicion", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto123124", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso3 = new DtCurso ("cursoEdicionVieja", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto123124", auxCurso3);
		iConAltaCurso.confirmarAltaCurso();
		
		iConAltaEdicion.ingresarInstituto("instituto123124");
		iConAltaEdicion.seleccionarCurso("nombreCurso123123");
		List<String> docentes = new ArrayList<String>();
		docentes.add("docenteEnEdicion");
		DtEdicionExp auxEdicion = new DtEdicionExp ("edicion12312312", fechaInicio, fechaFin, 1, fecha, docentes);//
		iConAltaEdicion.ingresarDtEdicion(auxEdicion);
		iConAltaEdicion.confirmarAltaEdicion();	
		iConAltaEdicion.seleccionarCurso("cursoEdicionVieja");
		DtEdicionExp auxEdicion2 = new DtEdicionExp ("edicionFechaVieja", fechaVieja, fechaVieja2, 1, fecha, docentes);//
		iConAltaEdicion.ingresarDtEdicion(auxEdicion2);
		iConAltaEdicion.confirmarAltaEdicion();
		
		iConInsAEdicion.ingresarCurso("nombreCurso123123");
		iConInsAEdicion.ingresarEstudiante("estudiante1231231", fecha);
		iConInsAEdicion.confirmarInscripcionAEdicion();
		
		iConSelEstudiantes.ingresarCurso("nombreCurso123123", "docenteEnEdicion");
		String [] estudiantes = {"estudiante1231231"};
		iConSelEstudiantes.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.ACEPTADO, "edicion12312312");		
		
	}
	
	@Test
	public void getInstitutos() {
		String [] institutos = iCon.getInstitutos();
		Boolean test=false;
		for (String i: institutos) {
			if (i.equals("instituto123124"))
				test=true;
		}
		assertTrue(test);
	}
	
	@Test
	public void ingresarInstituto() {
		String [] cursos = iCon.ingresarInstituto("instituto123124");
		String [] cursosTest = {"nombreCurso123123", "cursoSinEdicion", "cursoEdicionVieja"};
		assertArrayEquals(cursosTest, cursos);		
	}
	
	@Test
	public void getEstudiantesAceptadosNotNull() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		iCon.ingresarCurso("nombreCurso123123", "docenteEnEdicion");
		String estudiantes = iCon.getEstudiantesAceptados();
		assertNotNull(estudiantes);
	}
	
	@Test 
	public void obtenerDatosBasicosEdNotNull() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		iCon.ingresarCurso("nombreCurso123123", "docenteEnEdicion");
		String datos = iCon.obtenerDatosBasicosEd();
		assertNotNull(datos);
	}
	
	@Test (expected= NoExisteEdicionVigenteException.class)
	public void ingresarCursoERROREdicion() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		iCon.ingresarCurso("cursoSinEdicion", "docenteEnEdicion");
	}
	
	@Test (expected= NoExisteEdicionVigenteException.class)
	public void ingresarCursoERROREdicionVieja() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		iCon.ingresarCurso("cursoEdicionVieja", "docenteEnEdicion");
	}
	/*@Test (expected=NoEsProfesorDeEdicionVigenteException.class)
	public void ingresarCursoERRORDocente() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		iCon.ingresarCurso("nombreCurso123123", "docenteSinEdicion");

	}*/
	
	

}
