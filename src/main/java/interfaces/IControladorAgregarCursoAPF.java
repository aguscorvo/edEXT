package interfaces;

import java.util.List;

public interface IControladorAgregarCursoAPF {
	public List<String> getProgramas();
	public List<String> seleccionarPrograma(String nombrePF);
	public void seleccionarCurso(String nombreC);
}
