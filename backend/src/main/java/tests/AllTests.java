package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  ControladorSeguirUsuariosTest.class,ControladorAgregarCursoAPFTest.class, ControladorInscripcionAProgramaTest.class, 
	ControladorAltaProgFormacionTest.class,ControladorSeleccionarEstudiantesTest.class, ControladorListarResultadosInscripcionesTest.class, 
	ControladorAltaCursoTest.class, ControladorModificarDatosUsuarioTest.class, ControladorAltaInstitutoTest.class, 
	ControladorAltaCategoriaTest.class, ControladorConsultarProgFormacionTest.class, ControladorAltaUsuarioTest.class, 
	ControladorIniciarSesionTest.class, ControladorAltaEdicionTest.class, ControladorBuscarCursoOProgramaTest.class})
public class AllTests {

}
