package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import logica.Instituto;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaUsuarioTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorAltaUsuario iCon = f.getIControladorAltaUsuario();
	public static IControladorAltaInstituto iConAltaInstituto = f.getIControladorAltaInstituto();
	public Date fechaTest = new Date();
	
	@BeforeClass
	public static void inicializarTest() throws InstitutoRepetidaException {
		iConAltaInstituto.ingresarInstituto("institutoTest2");
		iConAltaInstituto.confirmarAltaInstituto();
		
	}
	
	@Test
	public void test_1_ingresarDtUsuarioyConfirmarOK() throws UsuarioRepetidoException, NoExisteInstitutoException  {	
		DtDocente aux = new DtDocente("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest", "institutoTest2");
		iCon.ingresarDtUsuario(aux);
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(aux.getNick());
		assertNotNull(u);
	}
	
	@Test
	public void test_2_ingresarDtUsuarioFrontEnd() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, NoExisteInstitutoException {
		DtEstudiante aux = new DtEstudiante("nickTest2", "nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(aux);
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(aux.getNick());
		assertNotNull(u);
	}
	
	@Test
	public void test_3_ingresarDtEstudianteFrontEndyConfirmarOK() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, NoExisteInstitutoException {
		DtEstudiante aux = new DtEstudiante("nickTest3", "nombreTest", "apellidoTest", "correoTest3", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(aux);		
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(aux.getNick());
		assertNotNull(u);		
	}
	
	@Test
	public void test_4_ingresarDtDocenteFrontEndyConfirmarOK() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, NoExisteInstitutoException {
		DtDocente auxDocente = new DtDocente("nickTest4", "nombreTest", "apellidoTest", "correoTest4", fechaTest, "passwordTest", "institutoTest2");
		iCon.ingresarDtDocenteFrontEnd(auxDocente);
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(auxDocente.getNick());
		assertNotNull(u);		
	}	
	
	@Test
	public void test_5_getInstitutos() {
		String [] institutos= iCon.getInstitutos();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> listaInstitutos = mI.getInstitutos();
		String [] arrDelManejador = new String[listaInstitutos.size()];
		int i=0;
		for (Instituto instituto: listaInstitutos) {
			arrDelManejador[i]= instituto.getNombre();
			i++;
		}
		assertArrayEquals("Los arreglos no son iguales", arrDelManejador, institutos);		
	}
	
	@Test
	public void test_6_existeUsuarioNick_true() {
		Boolean existe= iCon.existeUsuarioNick("nickTest2");
		assertTrue(existe);
	}
	
	@Test
	public void test_7_existeUsuarioNick_false() {
		Boolean existe= iCon.existeUsuarioNick("nickInexistente");
		assertFalse(existe);

	}
	
	@Test
	public void test_8_existeUsuarioCorreo_false() {
		Boolean existe= iCon.existeUsuarioCorreo("correoInexistente");
		assertFalse(existe);
		
	}
	
	@Test
	public void test_2_existeUsuarioCorreo_true() throws InterruptedException {
		Boolean existe= iCon.existeUsuarioCorreo("correoTest");
		assertTrue(existe);
	}
	
	
	
	//excepciones	
	
	@Test(expected = UsuarioRepetidoException.class)
	public void test_2_ingresarDtUsuarioERRORNick() throws UsuarioRepetidoException {
		DtUsuario auxUsuarioErrorNick = new DtUsuario ("nickTest","nombreTest", "apellidoTest", "correoTest100", fechaTest, "passwordTest");
		iCon.ingresarDtUsuario(auxUsuarioErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoException.class)
	public void test_5_ingresarDtUsuarioERRORCorreo() throws UsuarioRepetidoException {
		DtUsuario auxUsuarioErrorCorreo = new DtUsuario ("nickTest100","nombreTest", "apellidoTest", "correoTest4", fechaTest, "passwordTest");
		iCon.ingresarDtUsuario(auxUsuarioErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_3_ingresarDtUsuarioFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtUsuario auxUsuarioErrorNick = new DtUsuario ("nickTest2","nombreTest", "apellidoTest", "correoTest100", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(auxUsuarioErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_3_ingresarDtUsuarioFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtUsuario auxUsuarioErrorCorreo= new DtUsuario ("nickTest100","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(auxUsuarioErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_4_ingresarDtEstudianteFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtEstudiante auxEstudianteErrorCorreo = new DtEstudiante ("nickTest100","nombreTest", "apellidoTest", "correoTest3", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(auxEstudianteErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_4_ingresarDtEstudianteFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtEstudiante auxEstudianteErrorNick = new DtEstudiante ("nickTest3","nombreTest", "apellidoTest", "correoTest100", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(auxEstudianteErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_2_ingresarDtDocenteFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtDocente auxDocenteErrorNick = new DtDocente ("nickTest","nombreTest", "apellidoTest", "correoTest100", fechaTest, "passwordTest", "institutoTest2");
		iCon.ingresarDtDocenteFrontEnd(auxDocenteErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_3_ingresarDtDocenteFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtDocente auxDocenteErrorCorreo = new DtDocente ("nickTest100","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest", "institutoTest");
		iCon.ingresarDtDocenteFrontEnd(auxDocenteErrorCorreo);
	}
	
	@Test(expected = NoExisteInstitutoException.class)
	public void test_18_confirmarAltaUsuarioERROR() throws UsuarioRepetidoException, NoExisteInstitutoException {
		DtDocente aux = new DtDocente("nickTest2", "nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest", "institutoTest100");
		iCon.ingresarDtUsuario(aux);
		iCon.confirmarAltaUsuario();
	}	
	
}
