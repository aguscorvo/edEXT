package interfaces;

import datatype.DtProgFormacion;

public interface IControladorAltaProgFormacion {
	public boolean ingresarProgFormacion(DtProgFormacion programa);
	public void confirmarAltaPrograma();
	public void cancelarAltaPrograma();
}
