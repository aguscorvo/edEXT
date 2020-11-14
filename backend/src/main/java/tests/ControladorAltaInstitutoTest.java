package tests;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.InstitutoRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import logica.Instituto;

public class ControladorAltaInstitutoTest {
	
	public static EntityManagerFactory emf;
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaInstituto iCon = f.getIControladorAltaInstituto();
	private Instituto i;
	
	@BeforeClass
	public static void abrirConexionBD(){
		emf = Persistence.createEntityManagerFactory("joaquin");
		System.out.println("Conexion creada test");
	}
	
	@Before
	public void inicializarTest() throws InstitutoRepetidaException {
		iCon.ingresarInstituto("institutoTest");
		iCon.confirmarAltaInstituto();
	}
			
	@Test(expected = InstitutoRepetidaException.class)
	public void ingresarInstitutoERROR() throws InstitutoRepetidaException{		
		try {
			iCon.ingresarInstituto("institutoTest");
		} catch (InstitutoRepetidaException e) {
			System.out.println("soy la excepcion catcheada");
		}	
	}
	
	@Test
	public void ingresarInstitutoOK() throws InstitutoRepetidaException  {		
		iCon.ingresarInstituto("institutoTest2");	
	}
	
	
	/*	
	@AfterClass
	public void cerrarConexionBD() {
		
	}*/
}
