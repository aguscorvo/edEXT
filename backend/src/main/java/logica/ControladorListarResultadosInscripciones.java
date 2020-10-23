package logica;

import java.util.List;

import datatype.EstadoInscripcion;
import interfaces.IControladorListarResultadosInscripciones;

public class ControladorListarResultadosInscripciones implements IControladorListarResultadosInscripciones{
	
	public String inscripcionesPendientes (String estudiante){
		
		String cadenaEdi = "";
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(estudiante);
		if (u instanceof Estudiante) {
			List<InscripcionEd> inscripciones = ((Estudiante) u).getInscripcionesEd();
			for (InscripcionEd ie: inscripciones) {
				if (ie.getEstado() == EstadoInscripcion.INSCRIPTO) {
					cadenaEdi = cadenaEdi + ie.getEdicion().getNombreEd() + "<br>";
				}
			}
		}
		return cadenaEdi;
	}
	
	public String inscripcionesRechazadas (String estudiante) {
		String cadenaEdi = "";
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(estudiante);
		if (u instanceof Estudiante) {
			List<InscripcionEd> inscripciones = ((Estudiante) u).getInscripcionesEd();
			for (InscripcionEd ie: inscripciones) {
				if (ie.getEstado() == EstadoInscripcion.RECHAZADO) {
					cadenaEdi = cadenaEdi + ie.getEdicion().getNombreEd() + "<br>";
				}
			}
		}
		return cadenaEdi;
	}
	
	public String inscripcionesAceptadas (String estudiante) {
		String cadenaEdi = "";
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(estudiante);
		if (u instanceof Estudiante) {
			List<InscripcionEd> inscripciones = ((Estudiante) u).getInscripcionesEd();
			for (InscripcionEd ie: inscripciones) {
				if (ie.getEstado() == EstadoInscripcion.ACEPTADO) {
					cadenaEdi = cadenaEdi + ie.getEdicion().getNombreEd() + "<br>";
				}
			}
		}
		return cadenaEdi;
	}

}
