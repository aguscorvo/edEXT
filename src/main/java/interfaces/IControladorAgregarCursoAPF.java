package interfaces;

import java.util.List;

import excepciones.CursoEnPFRepetidoException;

public interface IControladorAgregarCursoAPF {
	public String[] getProgramas();
	public void seleccionarPrograma(String nombrePF);
	public String [] getCursos();
	public void seleccionarCurso(String nombreC) throws CursoEnPFRepetidoException;
}
