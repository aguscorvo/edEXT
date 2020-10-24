package logica;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import interfaces.IControladorInscripcionAPrograma;
import persistencia.Conexion;

public class ControladorInscripcionAPrograma implements IControladorInscripcionAPrograma{

	
	public String[] getProgramas() {
	
		ManejadorProgFormacion mi = ManejadorProgFormacion.getInstancia();		
		List<ProgFormacion> programas = mi.getProgFormacion();
		String [] arrProgramas = new String [programas.size()];
		
		int i=0;		
		for(ProgFormacion p: programas) {
			arrProgramas[i] = p.getNombre();
			i++;
		}
		return arrProgramas;	
		
	}
	
	public boolean confirmarInscripcion(String nick, String programa) {
		
		boolean seInscribe = false;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mu.getUsuario(nick);
		if (auxUsuario instanceof Estudiante) {
			Estudiante auxEstudiante = ((Estudiante) auxUsuario);
			ManejadorProgFormacion me = ManejadorProgFormacion.getInstancia();
			ProgFormacion prog = me.getProgFormacion(programa);
			InscripcionPF inscripcion = auxEstudiante.getInscPF(programa);
			if (inscripcion == null){
				seInscribe = true;
				Date fecha = new Date();
				inscripcion = new InscripcionPF(fecha, prog);
				List<InscripcionPF> auxInscripciones = auxEstudiante.getInscripcionesPF();
				auxInscripciones.add(inscripcion);
				auxEstudiante.setInscripcionesPF(auxInscripciones);
				
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				em.persist(inscripcion);
				em.getTransaction().commit();
			}
		}
		return seInscribe;
	}
		
}
