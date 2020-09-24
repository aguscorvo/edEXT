package logica;

import excepciones.CategoriaRepetidaException;
import interfaces.IControladorAltaCategoria;

public class ControladorAltaCategoria implements IControladorAltaCategoria{

	public ControladorAltaCategoria() {
		super();
		
	}
	
	public void ingresarCategoria(String nombre) throws CategoriaRepetidaException{
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		if (mc.existeCategoria(nombre)) 
			throw new CategoriaRepetidaException ("La categoría '" + nombre + "' ya se encuentra registrada en el sistema.\n");
		Categoria nuevaCategoria = new Categoria (nombre);
		mc.agregarCategoria(nuevaCategoria);
	}


}
