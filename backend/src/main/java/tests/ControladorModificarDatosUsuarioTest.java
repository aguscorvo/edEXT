package tests;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtDocente;
import datatype.DtUsuario;
import excepciones.InstitutoRepetidaException;

import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.*;
import logica.ManejadorCurso;
import logica.ManejadorUsuario;
import logica.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorModificarDatosUsuarioTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorSeleccionarEstudiantes ics = f.getIControladorSeleccionarEstudiantes();
	public static IControladorAltaInstituto icai = f.getIControladorAltaInstituto();
	public static IControladorAltaCurso icac = f.getIControladorAltaCurso();
	public static IControladorAltaEdicion icae = f.getIControladorAltaEdicion();
	public static IControladorAltaUsuario icau = f.getIControladorAltaUsuario();
	public static IControladorInscripcionAEdicion iciae = f.getIControladorInscripcionAEdicion();
	public static IControladorModificarDatosUsuario icmdu = f.getIControladorModificarDatosUsuario();
	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, UsuarioRepetidoException, NoExisteInstitutoException {
		icai.ingresarInstituto("InstitutoMDU");
		icai.confirmarAltaInstituto();
		Date fecha = new Date();
		DtDocente aux_d = new DtDocente("alex", "Alexis", "Kent", "a@k", fecha, "a", "InstitutoMDU");
		icau.ingresarDtUsuario(aux_d);
		icau.confirmarAltaUsuario();
		
	}
	
	@Test
	public void Test_1_getUsuariosOK() {
		
		Boolean esta = false;
		
		String [] usuarios = icmdu.getUsuarios();
		for (int i =0; i<usuarios.length; i++) {
			if (usuarios[i].equals("alex")) {
				esta = true;
			}
		}
		
		assertTrue(esta);
	}
	
	@Test
	public void Test_2_ModificarDatosOK() {
		
		Boolean seCambioOK = false;
		
		DtUsuario viejo = icmdu.seleccionarUsuario("alex");
		DtUsuario nuevo = new DtUsuario(viejo.getNick(), "nombreMDU", "apellidoMDU", viejo.getCorreo(), viejo.getFechaNac(), "passwordMDU");
		icmdu.modificarDatosUsuario(nuevo);
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario modificado = mu.getUsuario(viejo.getNick());
		
		if (modificado.getNombre().equals("nombreMDU") && modificado.getApellido().equals("apellidoMDU") 
				&& modificado.getPassword().equals("passwordMDU")) {
			seCambioOK = true;
		}
		
		assertTrue(seCambioOK);
	}
	
}
	
