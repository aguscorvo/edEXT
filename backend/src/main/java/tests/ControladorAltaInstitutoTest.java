package tests;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excepciones.InstitutoRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControladorAltaInstitutoTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaInstituto iCon = f.getIControladorAltaInstituto();
	
	@Test
	public void Test_1_ingresarInstitutoOK() throws InstitutoRepetidaException  {		
		iCon.ingresarInstituto("institutoTest");	
		iCon.confirmarAltaInstituto();
	}

	@Test(expected = InstitutoRepetidaException.class)
	public void Test_2_ingresarInstitutoERROR() throws InstitutoRepetidaException{		
			iCon.ingresarInstituto("institutoTest");
			iCon.confirmarAltaInstituto();
		
	}
	
	
	
	/*	
	@AfterClass
	public void cerrarConexionBD() {
		
	}*/
}
