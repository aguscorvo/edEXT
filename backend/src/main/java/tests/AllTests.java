package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  ControladorSeguirUsuariosTest.class, ControladorSeleccionarEstudiantesTest.class, 
				ControladorListarResultadosInscripcionesTest.class, ControladorAltaCursoTest.class})
public class AllTests {

}
