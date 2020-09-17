package interfaces;

import excepciones.CategoriaRepetidaException;

public interface IControladorAltaCategoria {
	public void ingresarCategoria(String nombre) throws CategoriaRepetidaException;

}
