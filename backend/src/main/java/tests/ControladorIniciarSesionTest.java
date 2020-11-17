package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtEstudiante;
import excepciones.ContraseniaIncorrectaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteInstitutoException;
import excepciones.NoExisteUsuarioException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorIniciarSesion;
import logica.ManejadorUsuario;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorIniciarSesionTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorAltaUsuario iConAltaUsu = f.getIControladorAltaUsuario();
	public static IControladorIniciarSesion iConIni = f.getIControladorIniciarSesion();


	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, UsuarioRepetidoException, NoExisteInstitutoException {
		
		//harcodeo un usuario 
		Date fecha = new Date();
		DtEstudiante usuario = new DtEstudiante("joako","Joaquin","Perez","j@gmail.com",fecha,"j");
		iConAltaUsu.ingresarDtUsuario(usuario);
		iConAltaUsu.confirmarAltaUsuario();
		

		
	}
	
	@Test
	public void Test_1_IniciarSesionNickOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Boolean existe = mu.existeUsuarioNick("joako");
		assertTrue(existe);
		Usuario aux = mu.getUsuario("joako");
		String pass = aux.getPassword();
		assertEquals("j", pass);
		iConIni.iniciarSesion("joako", "j");
		
	}
	
	@Test
	public void Test_2_IniciarSesionCorreoOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Boolean existe = mu.existeUsuarioCorreo("j@gmail.com");
		assertTrue(existe);
		Usuario aux = mu.getUsuario("joako");
		String pass = aux.getPassword();
		assertEquals("j",pass);
		iConIni.iniciarSesion("j@gmail.com","j");

		
	}
	
	@Test(expected = NoExisteUsuarioException.class)
	public void Test_3_IniciarSesionERRORUno() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		iConIni.iniciarSesion("pepito", "contrasenia");
		
	}
	
	@Test(expected = ContraseniaIncorrectaException.class)
	public void Test_4_IniciarSesionERRORDos() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		iConIni.iniciarSesion("joako","contrasenia");
	}
	
	
	
	
}
