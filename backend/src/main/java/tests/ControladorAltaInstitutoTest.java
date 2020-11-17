package tests;


import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excepciones.InstitutoRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import logica.Instituto;
import logica.ManejadorInstituto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControladorAltaInstitutoTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaInstituto iCon = f.getIControladorAltaInstituto();
	
	@Test
	public void Test_1_ingresarYConfirmarInstitutoOK() throws InstitutoRepetidaException  {		
		iCon.ingresarInstituto("institutoTest");	
		iCon.confirmarAltaInstituto();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto aux = mI.getInstituto("institutoTest");
		assertNotNull(aux);
	}

	@Test(expected = InstitutoRepetidaException.class)
	public void Test_2_ingresarYConfirmarInstitutoERROR() throws InstitutoRepetidaException{		
			iCon.ingresarInstituto("institutoTest");
			iCon.confirmarAltaInstituto();
		
	}
	
	
	
	/*	
	@AfterClass
	public void cerrarConexionBD() {
		
	}*/
}
