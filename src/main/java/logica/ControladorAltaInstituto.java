package logica;

import java.util.ArrayList;
import java.util.List;

import excepciones.InstitutoRepetidaException;
import interfaces.IControladorAltaInstituto;

public class ControladorAltaInstituto implements IControladorAltaInstituto {
	private String instituto;
	
	
	public ControladorAltaInstituto() {
		super();
	}
	
	@Override
	public void ingresarInstituto(String nombre) throws InstitutoRepetidaException{
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		if(mi.existeInstituto(nombre))
			throw new InstitutoRepetidaException("El instituto '" + nombre +"' ya se encuentra registrado en el sistema.\n");
		instituto=nombre;	
	}
	
	@Override
	public void confirmarAltaInstituto() {
		List<Curso> cursos = new ArrayList<>();
		Instituto i= new Instituto(instituto, cursos);
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		mi.agregarInstituto(i);
	}
	
	@Override
	public void cancelarAltaInstituto() {}
	
}
