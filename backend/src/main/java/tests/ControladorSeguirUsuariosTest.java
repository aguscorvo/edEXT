package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorSeguirUsuarios;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorSeguirUsuariosTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorSeguirUsuarios ics = f.getIcontroladorSeguirUsuarios();
	public static IControladorAltaUsuario icau = f.getIControladorAltaUsuario();
	
	
	@BeforeClass
	public static void inicializar() throws UsuarioRepetidoException, NoExisteInstitutoException {
		Date d = new Date();
		DtUsuario usuario1 = new DtEstudiante("jorgito", "Jorge", "Diaz", "jorge@jorgito.com", d, "j");
		DtUsuario usuario2 = new DtEstudiante("pepito", "Francisco", "Gonzalez", "fran@cisco", d, "p");
		icau.ingresarDtUsuario(usuario1);
		icau.confirmarAltaUsuario();
		icau.ingresarDtUsuario(usuario2);
		icau.confirmarAltaUsuario();
	}
	
	@Test
	public void Test_1_SeguidoresNulos() {
		String seguidores = ics.getCadenaUsuariosSeguidores("jorgito");
		assertEquals(seguidores, "");
		
	}
	
	@Test
	public void Test_2_SeguidoresNoNulos() {
		ics.seguirUsuario("pepito", "jorgito");
		String seguidores = ics.getCadenaUsuariosSeguidores("jorgito");
		assertNotEquals(seguidores, "");
		
	}
	
	
	@Test
	public void Test_3_DejarDeSeguir() {
		ics.noSeguirUsuario("pepito", "jorgito");
		String seguidos = ics.getCadenaUsuariosSeguidos("pepito");
		assertEquals(seguidos, "");
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void Test_4_ArrayCorrecto1() {
		ics.seguirUsuario("jorgito", "pepito");
		String [] seguidos = ics.getUsuariosSeguidos("jorgito");
		String [] seguidosReal = {"pepito"};
		assertEquals(seguidos, seguidosReal);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void Test_5_ArrayCorrecto2() {
		String [] noSeguidos = ics.getUsuariosNoSeguidos("jorgito");
		String [] noSeguidosReal = new String[0];
		assertEquals(noSeguidos, noSeguidosReal);
	}
	
	
	@Test
	public void Test_6_ArrayCorrecto3() {
		String [] noSeguidos = ics.getUsuariosNoSeguidos("pepito");
		String [] noSeguidosReal = new String[0];
		assertNotEquals(noSeguidos, noSeguidosReal);
	}
	
	@Test
	public void Test_7_SeguidoresNoNulos_2() {
		String seguidos = ics.getCadenaUsuariosSeguidos("jorgito");
		String seguidosReal = "";
		assertNotEquals(seguidos, seguidosReal);
		
	}
	
}
