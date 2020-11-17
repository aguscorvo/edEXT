package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  ControladorAgregarCursoAPFTest.class, ControladorAltaProgFormacionTest.class, ControladorSeguirUsuariosTest.class, 
	ControladorSeleccionarEstudiantesTest.class, ControladorListarResultadosInscripcionesTest.class, ControladorAltaCursoTest.class,
	ControladorModificarDatosUsuarioTest.class, ControladorAltaInstitutoTest.class,	ControladorAltaCategoriaTest.class, 
	ControladorConsultarProgFormacionTest.class, ControladorAltaUsuarioTest.class, ControladorIniciarSesionTest.class })
public class AllTests {

}
