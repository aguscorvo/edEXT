package interfaces;

public interface IControladorListarResultadosInscripciones {
	public String inscripcionesPendientes (String estudiante);
	public String inscripcionesRechazadas (String estudiante);
	public String inscripcionesAceptadas (String estudiante);

}
