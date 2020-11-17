package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuarioLogueado;
import excepciones.ContraseniaIncorrectaException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteInstitutoException;
import excepciones.NoExisteUsuarioException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorIniciarSesion;
import logica.ManejadorUsuario;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorIniciarSesionTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorAltaUsuario iConAltaUsu = f.getIControladorAltaUsuario();
	public static IControladorIniciarSesion iConIni = f.getIControladorIniciarSesion();
	public static IControladorAltaInstituto iConAltaIns = f.getIControladorAltaInstituto();


	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, UsuarioRepetidoException, NoExisteInstitutoException {
		
		iConAltaIns.ingresarInstituto("instituto1");
		iConAltaIns.confirmarAltaInstituto();
		
		Date fecha = new Date();
		DtEstudiante usuario = new DtEstudiante("joako","Joaquin","Perez","j@gmail.com",fecha,"j");
		iConAltaUsu.ingresarDtUsuario(usuario);
		iConAltaUsu.confirmarAltaUsuario();
		
		DtDocente docente = new DtDocente ("docente", "NombreD", "ApellidoD", "correo", fecha, "d", "instituto1");
		iConAltaUsu.ingresarDtUsuario(docente);
		iConAltaUsu.confirmarAltaUsuario();
		
	}
	
	@Test
	public void Test_1_IniciarSesionNickEstudianteOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		DtUsuarioLogueado usuarioLogueado=iConIni.iniciarSesion("joako", "j");
		Boolean test=false;
		if (usuarioLogueado.getNick().equals("joako") && usuarioLogueado.getPassword().equals("j"))
			test=true;
		else test=false;
		
		assertTrue(test);		
		
	}
	
	@Test
	public void Test_2_IniciarSesionNickDocenteOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		DtUsuarioLogueado usuarioLogueado=iConIni.iniciarSesion("docente", "d");
		Boolean test=false;
		if (usuarioLogueado.getNick().equals("docente") && usuarioLogueado.getPassword().equals("d"))
			test=true;
		else test=false;
		
		assertTrue(test);		
		
	}
	
	@Test
	public void Test_2_IniciarSesionCorreoDocenteOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		DtUsuarioLogueado usuarioLogueado= iConIni.iniciarSesion("correo","d");
		Boolean test=false;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aux= mU.getUsuarioPorCorreo("correo");
		
		if (aux.getCorreo().equals("correo") && usuarioLogueado.getPassword().equals("d"))
			test=true;
		else test=false;
		
		assertTrue(test);	
	}
	
	@Test
	public void Test_2_IniciarSesionCorreoEstudianteOK() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		DtUsuarioLogueado usuarioLogueado= iConIni.iniciarSesion("j@gmail.com","j");
		Boolean test=false;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario aux= mU.getUsuarioPorCorreo("j@gmail.com");
		
		if (aux.getCorreo().equals("j@gmail.com") && usuarioLogueado.getPassword().equals("j"))
			test=true;
		else test=false;
		
		assertTrue(test);	
	}
	
	@Test(expected = NoExisteUsuarioException.class)
	public void Test_3_IniciarSesionERRORUno() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		iConIni.iniciarSesion("asd", "contrasenia");
		
	}
	
	@Test(expected = ContraseniaIncorrectaException.class)
	public void Test_4_IniciarSesionERRORDos() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		iConIni.iniciarSesion("joako","contrasenia");
	}
	
	@Test(expected = ContraseniaIncorrectaException.class)
	public void Test_5_IniciarSesionERRORTre() throws NoExisteUsuarioException, ContraseniaIncorrectaException {
		iConIni.iniciarSesion("correo","contrasenia");
	}
	
	
	
	
}
