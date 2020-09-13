package interfaces;


import excepciones.CursoEnPFRepetidoException;

public interface IControladorAgregarCursoAPF {
	public String[] getProgramas();
	public void seleccionarPrograma(String nombrePF);
	public String [] getCursos();
	public void seleccionarCurso(String nombreC) throws CursoEnPFRepetidoException;
}
