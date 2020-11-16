package tests;

import java.util.Date;

import org.junit.Before;
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
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaUsuarioTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaUsuario iCon = f.getIControladorAltaUsuario();
	public DtUsuario auxUsuario;
	public DtDocente auxDocente;
	public Date fechaTest = new Date();
	
	
	@Test
	public void test_1_ingresarDtUsuarioOK() throws UsuarioRepetidoException  {	
		DtUsuario aux = new DtUsuario("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtUsuario(aux);
	}
	
	@Test
	public void test_2_ingresarDtUsuarioFrontEndOK() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail {
		auxUsuario = new DtUsuario("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(auxUsuario);
	}
	
	@Test
	public void test_2_ingresarDtEstudianteFrontEndOK() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail {
		DtEstudiante aux = new DtEstudiante("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(aux);
	}
	
	@Test
	public void test_3_ingresarDtDocenteFrontEndOK() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail {
		auxDocente = new DtDocente("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest", "institutoTest");
		iCon.ingresarDtDocenteFrontEnd(auxDocente);
	}
	
	@Test
	public void test_4_confirmarAltaUsuarioOK_Docente() throws NoExisteInstitutoException, UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, UsuarioRepetidoException, InstitutoRepetidaException {
		IControladorAltaInstituto icon = f.getIControladorAltaInstituto();
		icon.ingresarInstituto("institutoTest");
		icon.confirmarAltaInstituto();
		DtDocente aux = new DtDocente("nickTest", "nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest", "institutoTest");
		iCon.ingresarDtUsuario(aux);
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(aux.getNick());
	}
	
	@Test
	public void test_4_confirmarAltaUsuarioOK_Estudiante() throws UsuarioRepetidoException, NoExisteInstitutoException{		
		DtEstudiante aux = new DtEstudiante("nickTestEst", "nombreTestEst", "apellidoTestEst", "correoTestEst", fechaTest, "passwordTestEst");
		iCon.ingresarDtUsuario(aux);
		iCon.confirmarAltaUsuario();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.getUsuario(aux.getNick());
	}
	
	@Test
	public void test_6_getInstitutos() {
		String [] institutos= iCon.getInstitutos();
		
	}
	
	@Test
	public void test_7_existeUsuarioNick_true() {
		iCon.existeUsuarioNick("nickTestEst");
	}
	
	@Test
	public void test_7_existeUsuarioNick_false() {
		iCon.existeUsuarioNick("nickUsuarioInexistente");
	}
	
	@Test
	public void test_7_existeUsuarioCorreo_false() {
		iCon.existeUsuarioCorreo("correoInexistente");
	}
	
	@Test
	public void test_7_existeUsuarioCorreo_true() {
		iCon.existeUsuarioCorreo("correoTest");
	}
	
	
	
	//excepciones	
	
	@Test(expected = UsuarioRepetidoException.class)
	public void test_5_ingresarDtUsuarioERRORNick() throws UsuarioRepetidoException {
		DtUsuario auxUsuarioErrorNick = new DtUsuario ("nickTest","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest");
		iCon.ingresarDtUsuario(auxUsuarioErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoException.class)
	public void test_5_ingresarDtUsuarioERRORCorreo() throws UsuarioRepetidoException {
		DtUsuario auxUsuarioErrorCorreo = new DtUsuario ("nickTest2","nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtUsuario(auxUsuarioErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_5_ingresarDtUsuarioFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtUsuario auxUsuarioErrorNick = new DtUsuario ("nickTest","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(auxUsuarioErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_5_ingresarDtUsuarioFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtUsuario auxUsuarioErrorCorreo= new DtUsuario ("nickTest2","nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtUsuarioFrontEnd(auxUsuarioErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_5_ingresarDtEstudianteFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtEstudiante auxEstudianteErrorCorreo = new DtEstudiante ("nickTest2","nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(auxEstudianteErrorCorreo);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_5_ingresarDtEstudianteFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtEstudiante auxEstudianteErrorNick = new DtEstudiante ("nickTest","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest");
		iCon.ingresarDtEstudianteFrontEnd(auxEstudianteErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionNick.class)
	public void test_5_ingresarDtDocenteFrontEndERRORNick() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtDocente auxDocenteErrorNick = new DtDocente ("nickTest","nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest", "institutoTest");
		iCon.ingresarDtDocenteFrontEnd(auxDocenteErrorNick);
	}
	
	@Test(expected = UsuarioRepetidoExceptionMail.class)
	public void test_5_ingresarDtDocenteFrontEndERRORCorreo() throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		DtDocente auxDocenteErrorCorreo = new DtDocente ("nickTest1","nombreTest", "apellidoTest", "correoTest", fechaTest, "passwordTest", "institutoTest");
		iCon.ingresarDtDocenteFrontEnd(auxDocenteErrorCorreo);
	}
	
	@Test(expected = NoExisteInstitutoException.class)
	public void test_5_confirmarAltaUsuarioERROR() throws UsuarioRepetidoException, NoExisteInstitutoException {
		DtDocente aux = new DtDocente("nickTest2", "nombreTest", "apellidoTest", "correoTest2", fechaTest, "passwordTest", "institutoTest2");
		iCon.ingresarDtUsuario(aux);
		iCon.confirmarAltaUsuario();
	}	
	
}
