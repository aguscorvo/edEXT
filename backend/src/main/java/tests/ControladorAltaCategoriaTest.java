package tests;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excepciones.CategoriaRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaCategoriaTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaCategoria iCon = f.getIControladorAltaCategoria();
	
	
	
	@Test
	public void Test_1_ingresarCategoriaOK() throws CategoriaRepetidaException   {		
		System.out.println("ingresar categoria OK");

		iCon.ingresarCategoria("Categoria");	
	}

	@Test(expected = CategoriaRepetidaException.class)
	public void Test_2_ingresarCategoriaERROR() throws CategoriaRepetidaException {		

			iCon.ingresarCategoria("Categoria");

	}
	
	

}
