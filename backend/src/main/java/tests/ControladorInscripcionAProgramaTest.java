package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtEstudiante;
import datatype.DtProgFormacion;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorInscripcionAPrograma;
import logica.Estudiante;
import logica.InscripcionPF;
import logica.ManejadorProgFormacion;
import logica.ManejadorUsuario;
import logica.ProgFormacion;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorInscripcionAProgramaTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorInscripcionAPrograma iCon = f.getIControladorInscripcionAPrograma();
	public static IControladorAltaUsuario iConAltaUsuario = f.getIControladorAltaUsuario();
	public static IControladorAltaProgFormacion iConAltaPrograma = f.getIControladorAltaProgFormacion();
	
	@BeforeClass
	public static void inicializarTest() throws UsuarioRepetidoException, NoExisteInstitutoException, ProgramaRepetidoException {
		Date fecha= new Date();
		DtEstudiante aux = new DtEstudiante ("est", "nombre", "apellido", "correo123", fecha, "e");
		iConAltaUsuario.ingresarDtUsuario(aux);
		iConAltaUsuario.confirmarAltaUsuario();
		
		DtProgFormacion auxPF = new DtProgFormacion ("nombrePF", "desc", fecha, fecha, fecha);
		iConAltaPrograma.ingresarProgFormacion(auxPF);
		iConAltaPrograma.confirmarAltaPrograma();				
	}
	
	@Test
	public void getProgramas() {
		String [] programas = iCon.getProgramas();
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> listProgramasManejador = mPF.getProgFormacion();
		String [] programasManejador = new String[listProgramasManejador.size()];
		int i=0;
		for (ProgFormacion pf: listProgramasManejador) {
			programasManejador[i]= pf.getNombre();
			i++;
		}		
		assertArrayEquals(programasManejador, programas);
	}
	
	@Test
	public void confirmarInscripcionTrue() {
		Boolean test= iCon.confirmarInscripcion("est", "nombrePF");
		assertTrue(test);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mU.getUsuario("est");
		if (auxUsuario instanceof Estudiante) {
			Estudiante auxEstudiante = ((Estudiante) auxUsuario);
			ManejadorProgFormacion me = ManejadorProgFormacion.getInstancia();
			ProgFormacion prog = me.getProgFormacion("nombrePF");
			InscripcionPF inscripcion = auxEstudiante.getInscPF("nombrePF");
			assertNotNull(inscripcion);
		}		
	}
	
	
	

}
