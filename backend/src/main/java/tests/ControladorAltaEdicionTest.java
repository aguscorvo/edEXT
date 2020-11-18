package tests;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtCurso;
import datatype.DtDocente;
import datatype.DtEdicionExp;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorEdicion;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControladorAltaEdicionTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaEdicion icae = f.getIControladorAltaEdicion();
	public IControladorAltaInstituto icai = f.getIControladorAltaInstituto();
	public IControladorAltaUsuario icau = f.getIControladorAltaUsuario();
	public IControladorAltaCurso icac = f.getIControladorAltaCurso();
	
	@Test
	public void Test_1_operacionExisteInstitutoOK() throws InstitutoRepetidaException    {		
		
		Boolean ok = false;
		icai.ingresarInstituto("InstitutoAE");
		icai.confirmarAltaInstituto();
		if (icae.existeInstituto("InstitutoAE")) {
			ok = true;
		}
		assertTrue(ok);
	}

	@Test
	public void Test_2_getDocentesOK() throws InstitutoRepetidaException, UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail,
											  NoExisteInstitutoException    {		
		
		Boolean esta = false;

		Date fecha = new Date();
		DtDocente nuevoDoc = new DtDocente("DocenteAE", "nombreAE", "apellidoAE", "correoAE", fecha, "passAE", "InstitutoAE");
		icau.ingresarDtDocenteFrontEnd(nuevoDoc);
		icau.confirmarAltaUsuario();
		
		String [] docentes = icae.getDocentes();
		
		for (int i =0; i<docentes.length; i++) {
			if (docentes[i].equals("DocenteAE")) {
				esta = true;
			}
		}
		assertTrue(esta);
	}
	
	@Test
	public void Test_3_getCursosOK() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Boolean esta = false;
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoAE", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		icac.ingresarCurso("InstitutoAE", curso);
		icac.confirmarAltaCurso();
		
		Instituto inst = icae.getInstituto("InstitutoAE");
		String [] cursos = icae.getCursos(inst);
	
		for (int i =0; i<cursos.length; i++) {
			if (cursos[i].equals("CursoAE")) {
				esta = true;
			}
		}
		assertTrue(esta);
	}
	
	@Test
	public void Test_4_getInstitutosOK()  {		
		
		Boolean esta = false;
		
		String [] institutos = icae.getInstitutos();
	
		for (int i =0; i<institutos.length; i++) {
			if (institutos[i].equals("InstitutoAE")) {
				esta = true;
			}
		}
		assertTrue(esta);
	}
	
	@Test
	public void Test_5_getCursosNuevaOK() {		
		
		Boolean esta = false;
		
		String [] cursos = icae.getCursosNueva("InstitutoAE");
	
		for (int i =0; i<cursos.length; i++) {
			if (cursos[i].equals("CursoAE")) {
				esta = true;
			}
		}
		assertTrue(esta);
	}
	
	@Test(expected = NoExisteInstitutoException.class)
	public void Test_6_ingresarInstitutoException() throws NoExisteInstitutoException {		
		icae.ingresarInstituto("elInstitutoQueNoExisteNiExistiraJamas");
		
	}
	
	@Test(expected = NoExisteCursoException.class)
	public void Test_7_seleccionarCursoException() throws NoExisteInstitutoException, NoExisteCursoException {		
		icae.ingresarInstituto("InstitutoAE");
		icae.seleccionarCurso("CursoQueNoExisteNiExistiraJamas");
		
	}
	
	@Test
	public void Test_8_confirmarAltaEdicionOK() throws NoExisteInstitutoException, NoExisteCursoException, EdicionRepetidaException {		
		
		icae.ingresarInstituto("InstitutoAE");
		icae.seleccionarCurso("CursoAE");
		
		Date fecha = new Date();
		List<String> docentes = new ArrayList<String>();
		docentes.add("DocenteAE");
		DtEdicionExp edicion = new DtEdicionExp("EdicionAE", fecha, fecha, 40, fecha, docentes);
		
		icae.ingresarDtEdicion(edicion);
		icae.confirmarAltaEdicion();
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion nueva = me.getEdicion("EdicionAE");
		assertNotNull(nueva);
		
	}
	
	@Test (expected = EdicionRepetidaException.class)
	public void Test_9a_confirmarAltaEdicionRepetida() throws NoExisteInstitutoException, NoExisteCursoException, EdicionRepetidaException {		
		
		icae.ingresarInstituto("InstitutoAE");
		icae.seleccionarCurso("CursoAE");
		
		Date fecha = new Date();
		List<String> docentes = new ArrayList<String>();
		docentes.add("DocenteAE");
		DtEdicionExp edicion = new DtEdicionExp("EdicionAE", fecha, fecha, 40, fecha, docentes);
		
		icae.ingresarDtEdicion(edicion);
		
	}
	
	@Test
	public void Test_9b_cancelarAltaEdicionOK() throws NoExisteInstitutoException, NoExisteCursoException, EdicionRepetidaException {		
		
		icae.ingresarInstituto("InstitutoAE");
		icae.seleccionarCurso("CursoAE");
		
		Date fecha = new Date();
		List<String> docentes = new ArrayList<String>();
		docentes.add("DocenteAE");
		DtEdicionExp edicion = new DtEdicionExp("EdicionAEPrueba", fecha, fecha, 40, fecha, docentes);
		
		icae.ingresarDtEdicion(edicion);
		icae.cancelarAltaEdicion();
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion nueva = me.getEdicion("EdicionAEPrueba");
		assertNull(nueva);
		
	}
}
	
	
	

