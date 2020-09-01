package interfaces;

import excepciones.InstitutoRepetidaException;

public interface IControladorAltaInstituto {
	public void ingresarInstituto(String nombre) throws InstitutoRepetidaException;
	public void confirmarAltaInstituto();
	public void cancelarAltaInstituto();
}
