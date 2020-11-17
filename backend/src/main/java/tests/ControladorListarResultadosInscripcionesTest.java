package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
import interfaces.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorListarResultadosInscripcionesTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorListarResultadosInscripciones icl = f.getIControladorListarResultadosInscripciones();
	public static IControladorSeleccionarEstudiantes ics = f.getIControladorSeleccionarEstudiantes();
	public static IControladorAltaInstituto icai = f.getIControladorAltaInstituto();
	public static IControladorAltaCurso icac = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion icae = f.getIControladorAltaEdicion();
	public static IControladorAltaUsuario icau = f.getIControladorAltaUsuario();
	public static IControladorInscripcionAEdicion iciae = f.getIControladorInscripcionAEdicion();
	
	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, NoExisteInstitutoException, CursoRepetidoException, 
											NoExisteCursoException, UsuarioRepetidoException, EdicionRepetidaException, 
											NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException  {
		icai.ingresarInstituto("Robots2");
		icai.confirmarAltaInstituto();
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CocinaDos", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		icac.ingresarCurso("Robots2", curso);
		icac.confirmarAltaCurso();
		DtDocente aux_d = new DtDocente("patyta", "Patricia", "Macha", "p@m", fecha, "p", "Robots2");
		icau.ingresarDtUsuario(aux_d);
		icau.confirmarAltaUsuario();
		List <String> docentes = new ArrayList<String>();
		docentes.add("paty");
		DtEdicionExp edicion = new DtEdicionExp("CocinaDos20", fecha, fecha, 1, fecha, docentes);
		icae.seleccionarCurso("CocinaDos");
		icae.ingresarDtEdicion(edicion);
		icae.confirmarAltaEdicion();
		DtEstudiante aux_u = new DtEstudiante("luquitas", "Lucas", "Guerra", "l@g", fecha, "l");
		icau.ingresarDtUsuario(aux_u);
		icau.confirmarAltaUsuario();
		ics.ingresarCurso("CocinaDos", "docente");
		iciae.ingresarCurso("CocinaDos");
		iciae.ingresarEstudiante("luquitas", fecha);
		iciae.confirmarInscripcionAEdicion();
		
	}
	
	@Test
	public void Test_1a_PendientesOK() {
		String pendientes = icl.inscripcionesPendientes("luquitas");
		assertNotEquals("", pendientes);
		
	}
	
	@Test
	public void Test_1b_RechazadasOK() {
		String rechazadas = icl.inscripcionesRechazadas("luquitas");
		assertEquals("", rechazadas);
		
	}
	
	@Test
	public void Test_1c_AceptadasOK() {
		String aceptadas = icl.inscripcionesAceptadas("luquitas");
		assertEquals("", aceptadas);
		
	}
	
	@Test
	public void Test_2a_PendientesOK() {
		
		String [] estudiantes = ics.getEstudiantes();
		ics.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.RECHAZADO, "CocinaDos20");
		
		String pendientes = icl.inscripcionesPendientes("luquitas");
		assertEquals("", pendientes);
		
	}
	
	@Test
	public void Test_2b_RechazadasOK() {
		String rechazadas = icl.inscripcionesRechazadas("luquitas");
		assertNotEquals("", rechazadas);
		
	}
	
	@Test
	public void Test_2c_AceptadasOK() {
		String aceptadas = icl.inscripcionesAceptadas("luquitas");
		assertEquals("", aceptadas);
		
	}
	
	@Test
	public void Test_3a_PendientesOK() throws NoExisteEdicionVigenteException {
	
		Date fecha = new Date();
		iciae.ingresarCurso("CocinaDos");
		iciae.ingresarEstudiante("luquitas", fecha);
		iciae.confirmarInscripcionAEdicion();
		String [] estudiantes = ics.getEstudiantes();
		ics.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.ACEPTADO, "CocinaDos20");
		
		String pendientes = icl.inscripcionesPendientes("luquitas");
		assertEquals("", pendientes);
		
	}
	
	@Test
	public void Test_3b_RechazadasOK() {
		String rechazadas = icl.inscripcionesRechazadas("luquitas");
		assertEquals("", rechazadas);
		
	}
	
	@Test
	public void Test_3c_AceptadasOK() {
		String aceptadas = icl.inscripcionesAceptadas("luquitas");
		assertNotEquals("", aceptadas);
		
	}
	
}
