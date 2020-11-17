package tests;


import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excepciones.CategoriaRepetidaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;
import logica.Categoria;
import logica.ManejadorCategoria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaCategoriaTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaCategoria iCon = f.getIControladorAltaCategoria();
	
	
	
	@Test
	public void Test_1_ingresarCategoriaOK() throws CategoriaRepetidaException   {		
		iCon.ingresarCategoria("Categoria");
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria aux= mC.getCategoria("Categoria");
		assertNotNull(aux);
	}

	@Test(expected = CategoriaRepetidaException.class)
	public void Test_2_ingresarCategoriaERROR() throws CategoriaRepetidaException {	
			iCon.ingresarCategoria("Categoria");
	}
	
	

}
