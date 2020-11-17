package tests;


import static org.junit.Assert.assertArrayEquals;
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
public class ControladorSeleccionarEstudiantesTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorSeleccionarEstudiantes ics = f.getIControladorSeleccionarEstudiantes();
	public static IControladorAltaInstituto icai = f.getIControladorAltaInstituto();
	public static IControladorAltaCurso icac = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion icae = f.getIControladorAltaEdicion();
	public static IControladorAltaUsuario icau = f.getIControladorAltaUsuario();
	public static IControladorInscripcionAEdicion iciae = f.getIControladorInscripcionAEdicion();
	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, NoExisteInstitutoException, CursoRepetidoException, 
	NoExisteCursoException, EdicionRepetidaException, UsuarioRepetidoException {
		icai.ingresarInstituto("Robots");
		icai.confirmarAltaInstituto();
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("Cocina", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		icac.ingresarCurso("Robots", curso);
		icac.confirmarAltaCurso();
		DtDocente aux_d = new DtDocente("paty", "Patricia", "Macha", "a@nn", fecha, "p", "Robots");
		icau.ingresarDtUsuario(aux_d);
		icau.confirmarAltaUsuario();
		List <String> docentes = new ArrayList<String>();
		docentes.add("paty");
		DtEdicionExp edicion = new DtEdicionExp("Cocina20", fecha, fecha, 1, fecha, docentes);
		icae.seleccionarCurso("Cocina");
		icae.ingresarDtEdicion(edicion);
		icae.confirmarAltaEdicion();
		DtEstudiante aux_u = new DtEstudiante("luquita", "Lucas", "Guerra", "a@b", fecha, "l");
		icau.ingresarDtUsuario(aux_u);
		icau.confirmarAltaUsuario();
		
	}
	
	@Test
	public void Test_1_InstitutosNoNulo() {
		String [] institutos = ics.getInstitutos();
		assertNotNull(institutos);
	}
	
	@Test
	public void Test_2_CursosOK() {
		String [] cursos = ics.ingresarInstituto("Robots");
		String [] cursosReal= {"Cocina"};
		assertArrayEquals(cursos, cursosReal);

	}
	
	@Test
	public void Test_3_CursosOK() {
		String [] cursos = ics.ingresarInstituto("Robots");
		String [] cursosReal= {"Cocina"};
		assertArrayEquals(cursos, cursosReal);

	}
	
	@Test (expected = NoExisteEdicionVigenteException.class)
	public void Test_4_NotEdicion() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException, NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso cursoB = new DtCurso("Cocina2", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		icac.ingresarCurso("Robots", cursoB);
		icac.confirmarAltaCurso();
		ics.ingresarCurso("Cocina2", "docente");

	}
	

	@Test
	public void Test_5_ConfirmarOK_() throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		String edicion = ics.ingresarCurso("Cocina", "docente");
		iciae.ingresarCurso("Cocina");
		Date fecha = new Date();
		iciae.ingresarEstudiante("luquita", fecha);
		iciae.confirmarInscripcionAEdicion();
		String [] estudiantes = ics.getEstudiantes();
		ics.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.ACEPTADO, edicion);
		Boolean ok = true;
		EstadoInscripcion [] estados = ics.getEstadosSegunEstudiantes(estudiantes);
		for (int i=0; i<estados.length; i++) {
			if (estados[i]!=EstadoInscripcion.ACEPTADO) {
				ok = false;
			}
		}
		assertTrue(ok);
	}
	
	@Test
	public void Test_6_DatosEdNotNull() {
		String datos = ics.obtenerDatosBasicosEd();
		assertNotNull(datos);
	}
	
	@Test
	public void Test_7_NotEsDocente() {
		Boolean es = ics.esDocenteEdicion("docente", "Cocina20");
		assertFalse(es);
	}
	
	@Test
	public void Test_8_EsDocente() {
		Boolean es = ics.esDocenteEdicion("paty", "Cocina20");
		assertTrue(es);
	}
	
	
}
