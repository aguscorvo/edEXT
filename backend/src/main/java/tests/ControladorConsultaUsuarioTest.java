package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import datatype.DtEstudiante;
import datatype.DtProgFormacion;
import datatype.DtProgFormacionExp;
import datatype.DtUsuario;
import datatype.EstadoInscripcion;
import excepciones.CursoEnPFRepetidoException;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteEdicionVigenteException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaUsuario;
import interfaces.IControladorInscripcionAEdicion;
import interfaces.IControladorInscripcionAPrograma;
import interfaces.IControladorSeleccionarEstudiantes;
import logica.Edicion;
import logica.ManejadorEdicion;
import logica.ManejadorProgFormacion;
import logica.ManejadorUsuario;
import logica.ProgFormacion;
import logica.Usuario;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorConsultaUsuarioTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorConsultaUsuario iCon = f.getIControladorConsultaUsuario();
	public static IControladorAltaInstituto iConAltaInstituto = f.getIControladorAltaInstituto();
	public static IControladorAltaUsuario iConAltaUsuario = f.getIControladorAltaUsuario();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion iConAltaEdicion = f.getIControladorAltaEdicion();
	public static IControladorAltaProgFormacion iConAltaPrograma = f.getIControladorAltaProgFormacion();
	public static IControladorAgregarCursoAPF iConAgregarCursoAPF = f.getIControladorAgregarCursoAPF();
	public static IControladorInscripcionAEdicion iConInsEdicion = f.getIControladorInscripcionAEdicion();
	public static IControladorSeleccionarEstudiantes iConSelEstudiante = f.getIControladorSeleccionarEstudiantes();
	public static IControladorInscripcionAPrograma iConInsPrograma = f.getIControladorInscripcionAPrograma();
	
	
	@BeforeClass
	public static void inicializarTest() throws InstitutoRepetidaException, UsuarioRepetidoException, NoExisteInstitutoException, 
	CursoRepetidoException, NoExisteCursoException, EdicionRepetidaException, ProgramaRepetidoException, CursoEnPFRepetidoException, 
	NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException {
		//creo instituto
		iConAltaInstituto.ingresarInstituto("instituto456345");
		iConAltaInstituto.confirmarAltaInstituto();
		//creo usuarios docente y estudiantes
		Date fecha = new Date();
		DtEstudiante auxEstudiante = new DtEstudiante ("estudiante46745", "nombre", "apellido", "correo5456", fecha, "contrasenia");
		iConAltaUsuario.ingresarDtUsuario(auxEstudiante);
		iConAltaUsuario.confirmarAltaUsuario();
		DtEstudiante auxEstudiante2 = new DtEstudiante ("estudiante467451", "nombre", "apellido", "correo54567123", fecha, "contrasenia");
		iConAltaUsuario.ingresarDtUsuario(auxEstudiante2);
		iConAltaUsuario.confirmarAltaUsuario();
		DtDocente auxDocente = new DtDocente ("docente457457", "nombre", "apellido", "correo457457", fecha, "contrasenia", "instituto456345");
		iConAltaUsuario.ingresarDtUsuario(auxDocente);
		iConAltaUsuario.confirmarAltaUsuario();
		//creo cursos
		List<String> listaVacia = new ArrayList<String>();
		DtCurso auxCurso1 = new DtCurso ("curso1_asdasd", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto456345", auxCurso1);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso2 = new DtCurso ("curso2_asdas", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto456345", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		DtCurso auxCurso3 = new DtCurso ("curso3_asdasda", "desc", 1, 1, 1, fecha, "url", listaVacia, listaVacia);
		iConAltaCurso.ingresarCurso("instituto456345", auxCurso3);
		iConAltaCurso.confirmarAltaCurso();
		//creo tres ediciones	
		String fechaI = "15/11/2020";
		String fechaF = "01/01/2021";
		Date fechaInicio = funcionesAux.convertirADate(fechaI);
		Date fechaFin = funcionesAux.convertirADate(fechaF);
		iConAltaEdicion.seleccionarCurso("curso1_asdasd");
		List<String> docentes = new ArrayList<String>();
		docentes.add("docente457457");
		DtEdicionExp auxEdicion1 = new DtEdicionExp ("edicion1_12312", fechaInicio, fechaFin, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion1);
		iConAltaEdicion.confirmarAltaEdicion();
		iConAltaEdicion.seleccionarCurso("curso2_asdas");
		DtEdicionExp auxEdicion2 = new DtEdicionExp ("edicion2_12312", fechaInicio, fechaFin, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion2);
		iConAltaEdicion.confirmarAltaEdicion();
		iConAltaEdicion.seleccionarCurso("curso3_asdasda");
		DtEdicionExp auxEdicion3 = new DtEdicionExp ("edicion3_12312", fechaInicio, fechaFin, 1, fecha, docentes);
		iConAltaEdicion.ingresarDtEdicion(auxEdicion3);
		iConAltaEdicion.confirmarAltaEdicion();
		//creo pf
		DtProgFormacion auxPF = new DtProgFormacion ("pf12312", "desc", fecha, fecha, fecha);
		iConAltaPrograma.ingresarProgFormacion(auxPF);
		iConAltaPrograma.confirmarAltaPrograma();
		//agrego curso a programa
		iConAgregarCursoAPF.seleccionarPrograma("pf12312");
		iConAgregarCursoAPF.seleccionarCurso("curso1_asdasd");
		//inscribo estudiante a ediciones
		iConInsEdicion.ingresarCurso("curso1_asdasd");
		iConInsEdicion.ingresarEstudiante("estudiante46745", fecha);
		iConInsEdicion.confirmarInscripcionAEdicion();
		iConInsEdicion.ingresarCurso("curso2_asdas");
		iConInsEdicion.ingresarEstudiante("estudiante46745", fecha);
		iConInsEdicion.confirmarInscripcionAEdicion();
		iConInsEdicion.ingresarCurso("curso3_asdasda");		
		iConInsEdicion.ingresarEstudiante("estudiante46745", fecha);
		iConInsEdicion.confirmarInscripcionAEdicion();
		//seleccionar estudiantes
		String[] estudiantes = {"estudiante46745"};	
		iConSelEstudiante.ingresarCurso("curso1_asdasd", "docente457457");
		iConSelEstudiante.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.ACEPTADO, "edicion1_12312");
		iConSelEstudiante.ingresarCurso("curso2_asdas", "docente457457");
		iConSelEstudiante.confirmarSeleccionarEstudiantes(estudiantes, EstadoInscripcion.RECHAZADO, "edicion2_12312");
		//inscripcion a programa
		iConInsPrograma.confirmarInscripcion("estudiante46745", "pf12312");
		
	}
	
	@Test
	public void getUsuarios() {		
		String [] usuarios = iCon.getUsuarios();		
		Boolean estudiante=false;		
		Boolean estudiante2=false;
		Boolean docente=false;
		for (String u: usuarios) {
			if (u.equals("docente457457")) {
				docente = true;
			}else if(u.equals("estudiante46745")) {
				estudiante=true;
			}else if(u.equals("estudiante467451"))
				estudiante2=true;
			
		}
		Boolean test=false;
		if (estudiante && docente && estudiante2) {
			test=true;
		}
		assertTrue(test);
	}
	
	@Test
	public void seleccionarUsuarioEstudiante() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante46745");
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario =mU.getUsuario("estudiante46745");
		Boolean test=false;
		if(usuario.getNick().equals(usuarioTest.getNick()) && usuario.getNombre().equals(usuarioTest.getNombre()) &&
				usuario.getApellido().equals(usuarioTest.getApellido()) && usuario.getCorreo().equals(usuarioTest.getCorreo()) &&
				usuario.getFechaNac().equals(usuarioTest.getFechaNac()) ){
			test=true;
		}		
		assertTrue(test);
	}
	
	@Test 
	public void seleccionarUsuarioDocente() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("docente457457");
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario =mU.getUsuario("docente457457");
		Boolean test=false;
		if(usuario.getNick().equals(usuarioTest.getNick()) && usuario.getNombre().equals(usuarioTest.getNombre()) &&
				usuario.getApellido().equals(usuarioTest.getApellido()) && usuario.getCorreo().equals(usuarioTest.getCorreo()) &&
				usuario.getFechaNac().equals(usuarioTest.getFechaNac()) ){
			test=true;
		}		
		assertTrue(test);
	}
	
	@Test 
	public void seleccionarEdicion() {
		DtEdicion edicionTest = iCon.seleccionarEdicion("edicion3_12312");
		ManejadorEdicion mE = ManejadorEdicion.getInstancia();
		Edicion edicion = mE.getEdicion("edicion3_12312");
		Boolean test=false;
		if(edicion.getNombreEd().equals(edicionTest.getNombre()) &&	edicion.getFechaI().equals(edicionTest.getFechaI()) &&
				edicion.getFechaF().equals(edicionTest.getFechaF()) && edicion.getCupo()==edicionTest.getCupo() && 
				edicion.getFechaPub().equals(edicionTest.getFechaPub())){
			test=true;
		}		
		assertTrue(test);		
	}
	
	@Test
	public void seleccionarPrograma() {
		DtProgFormacionExp programaTest = iCon.seleccionarPrograma("pf12312");
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		ProgFormacion programa = mPF.getProgFormacion("pf12312");
		Boolean test=false;
		if (programa.getNombre().equals(programaTest.getNombre()) && programa.getDescPF().equals(programaTest.getDesc()) &&
				programa.getFechaI().equals(programaTest.getFechaI()) && programa.getFechaF().equals(programaTest.getFechaF()) &&
				programa.getFechaAlta().equals(programaTest.getFechaAlta()) ) {
			test=true;
		}
		assertTrue(test);		
	}
	
	@Test
	public void obtenerDatosUsuario() {		
		DtUsuario usuarioTest = iCon.seleccionarUsuario("docente457457");//testeada anda ok
		String datos = iCon.obtenerDatosUsuario(usuarioTest);
		Boolean test=false;
		if(datos.contains(usuarioTest.getNick()) && datos.contains(usuarioTest.getNombre()) && datos.contains(usuarioTest.getApellido()) && 
				datos.contains(usuarioTest.getCorreo()) && datos.contains(funcionesAux.convertirAString(usuarioTest.getFechaNac())) ){
			test=true;
		}		
		assertTrue(test);	
	}
	
	@Test
	public void obtenerDatosEdicion() {
		DtEdicion edicionTest = iCon.seleccionarEdicion("edicion3_12312");
		String datos = iCon.obtenerDatosEdicion(edicionTest);
		Boolean test=false;
		if(datos.contains(edicionTest.getNombre()) && datos.contains(funcionesAux.convertirAString(edicionTest.getFechaI())) &&
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaF())) && datos.contains(Integer.toString(edicionTest.getCupo())) && 
				datos.contains(funcionesAux.convertirAString(edicionTest.getFechaPub())) ){
			test=true;
		}		
		assertTrue(test);
	}
	
	@Test
	public void obtenerDatosPrograma() {
		DtProgFormacionExp programaTest = iCon.seleccionarPrograma("pf12312");
		String datos = iCon.obtenerDatosPrograma(programaTest);
		Boolean test=false;
		if (datos.contains(programaTest.getNombre()) && datos.contains(programaTest.getDesc()) &&
				datos.contains(funcionesAux.convertirAString(programaTest.getFechaI())) && 
				datos.contains(funcionesAux.convertirAString(programaTest.getFechaF())) &&
				datos.contains(funcionesAux.convertirAString(programaTest.getFechaAlta())) ) {
			test=true;
		}
		assertTrue(test);
	}
	
	@Test
	public void getEdicionesNoRechazadas() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante46745");
		String [] ediciones = iCon.getEdiciones(usuarioTest);
		String [] edicionesAceptadasOInscripto = {"edicion1_12312", "edicion3_12312"};		
		assertArrayEquals(edicionesAceptadasOInscripto, ediciones);			
	}
	
	@Test
	public void getEdicionesNoRechazadasVacio() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante467451");
		String [] ediciones = iCon.getEdiciones(usuarioTest);
		String [] edicionesAceptadasOInscripto = {""};		
		assertArrayEquals(edicionesAceptadasOInscripto, ediciones);		
	}
	
	@Test
	public void getEdicionesDocentes() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("docente457457");
		String [] ediciones = iCon.getEdiciones(usuarioTest);
		String [] edicionesAsociadas = {"edicion1_12312", "edicion2_12312", "edicion3_12312"};		
		assertArrayEquals(edicionesAsociadas, ediciones);	
	}
	
	@Test
	public void getEdicionesRechazadas() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante46745");
		String [] ediciones = iCon.getEdicionesInscRechazadas(usuarioTest);
		String [] edicionesRechazadas = {"edicion2_12312"};		
		assertArrayEquals(edicionesRechazadas, ediciones);		
	}
	
	@Test
	public void getEdicionesRechazadasVacio() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante467451");
		String [] ediciones = iCon.getEdicionesInscRechazadas(usuarioTest);
		String [] edicionesRechazadas = {""};		
		assertArrayEquals(edicionesRechazadas, ediciones);		
	}
	
	@Test
	public void getProgramas() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante46745");
		String [] programas = iCon.getProgramas(usuarioTest);
		String [] programasAsociados = {"pf12312"};
		assertArrayEquals(programasAsociados, programas);	
	}
	
	@Test
	public void getProgramasVacio() {
		DtUsuario usuarioTest = iCon.seleccionarUsuario("estudiante467451");
		String [] programas = iCon.getProgramas(usuarioTest);
		String [] programasAsociados = {""};
		assertArrayEquals(programasAsociados, programas);	
	}
	
	@Test
	public void tipoUsuarioSeleccionadoDocente() {
		String tipo = iCon.tipoUsuarioSeleccionado("docente457457");
		assertEquals("docente", tipo);
	}
	
	@Test
	public void tipoUsuarioSeleccionadoEstudiante() {
		String tipo = iCon.tipoUsuarioSeleccionado("estudiante46745");
		assertEquals("estudiante", tipo);
	}
	
	@Test
	public void getEstudiantesAceptadosAEdicion() {
		//edicion1 tiene un estudiante aceptado
		String estudiantesAceptados1 = iCon.getEstudiantesAceptadosAEdicion("edicion1_12312");
		String estudiantesAceptadosOk = "nombre apellido";
		Boolean test=false;
		if (estudiantesAceptados1.contains(estudiantesAceptadosOk))
			test=true;
		assertTrue(test);		
		//edicion2 y 3 no tienen estudiantes aceptados
		test=false;
		String estudiantesAceptados2 = iCon.getEstudiantesAceptadosAEdicion("edicion2_12312");
		if (estudiantesAceptados2.contains(estudiantesAceptadosOk))
			test=true;
		assertFalse(test);
		test=false;
		String estudiantesAceptados3 = iCon.getEstudiantesAceptadosAEdicion("edicion3_12312");
		String estudiantesAceptadosOk3 = "estudiante46745";
		if (estudiantesAceptados3.contains(estudiantesAceptadosOk))
			test=true;
		assertFalse(test);
	}
	
	@Test
	public void getProgramasNUEVA() {
		String [] programas = iCon.getProgramasNueva("estudiante46745");
		String [] programasAsociados = {"pf12312"};
		assertArrayEquals(programasAsociados, programas);	
	}	
	
	@Test
	public void getProgramasNUEVAVacio() {
		String [] programas = iCon.getProgramasNueva("estudiante467451");
		String [] programasAsociados = {""};
		assertArrayEquals(programasAsociados, programas);	
	}	
		
	@Test
	public void getEdicionesRechazadasNUEVA() {
		String [] ediciones = iCon.getEdicionesInscRechazadasNueva("estudiante46745");
		String [] edicionesRechazadas = {"edicion2_12312"};		
		assertArrayEquals(edicionesRechazadas, ediciones);		
	}
	
	@Test
	public void getEdicionesRechazadasNUEVAVacio() {
		String [] ediciones = iCon.getEdicionesInscRechazadasNueva("estudiante467451");
		String [] edicionesRechazadas = {""};		
		assertArrayEquals(edicionesRechazadas, ediciones);		
	}
	
	@Test
	public void getEdicionesNUEVAEstudiantes() {
		String [] ediciones = iCon.getEdicionesNueva("estudiante46745");
		String [] edicionesAceptadasOInscripto = {"edicion1_12312", "edicion2_12312", "edicion3_12312"};		
		assertArrayEquals(edicionesAceptadasOInscripto, ediciones);			
	}
	
	@Test
	public void getEdicionesNUEVADocentes() {
		String [] ediciones = iCon.getEdicionesNueva("docente457457");
		String [] edicionesAsociadas = {"edicion1_12312", "edicion2_12312", "edicion3_12312"};		
		assertArrayEquals(edicionesAsociadas, ediciones);	
	}
	

}
