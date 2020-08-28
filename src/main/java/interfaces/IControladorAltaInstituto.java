package interfaces;

import excepciones.InstitucionRepetidaException;

public interface IControladorAltaInstituto {
	public void ingresarInstituto(String nombre) throws InstitucionRepetidaException;
	public void confirmarAltaInstituto();
	public void cancelarAltaInstituto();
}
