package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtCurso;
import datatype.DtProgFormacion;
import excepciones.CursoRepetidoException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorBuscarCursoOPrograma;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorBuscarCursoOProgramaTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorBuscarCursoOPrograma icb = f.getIControladorBuscarCursoOPrograma();
	public static IControladorAltaCurso icac = f.getIControladorAltaCurso();
	public static IControladorAltaInstituto icai = f.getIControladorAltaInstituto();
	public static IControladorAltaProgFormacion icap = f.getIControladorAltaProgFormacion();
	
	@BeforeClass
	public static void inicializar() throws InstitutoRepetidaException, NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException, ProgramaRepetidoException {
		
		icai.ingresarInstituto("InstitutoBCOP");
		icai.confirmarAltaInstituto();
		
		//Ingreso un curso
		Date fecha1 = new Date();
		List <String> previas1 = new ArrayList<String>();
		List <String> categorias1 = new ArrayList<String>();
		DtCurso curso = new DtCurso("Labradores", "Perros labradores y cachorritos", 2, 2, 2, fecha1, "http://gg.com", previas1, categorias1);
		icac.ingresarCurso("InstitutoBCOP", curso);
		icac.confirmarAltaCurso();
		
		//Ingreso otro curso
		Date fecha2 = new Date();
		List <String> previas2 = new ArrayList<String>();
		List <String> categorias2 = new ArrayList<String>();
		DtCurso curso2 = new DtCurso("Pequineses", "Perros pequineses y sus amos", 2, 2, 2, fecha2, "http://gg.com", previas2, categorias2);
		icac.ingresarCurso("InstitutoBCOP", curso2);
		icac.confirmarAltaCurso();
		
		//Ingreso un programa
		Date fecha3 = new Date();
		DtProgFormacion programa1 = new DtProgFormacion("Labradores/Pequineses","Labradores, pequineses y mas",fecha3 ,fecha3 ,fecha3);
		icap.ingresarProgFormacion(programa1);
		icap.confirmarAltaPrograma();
		
		//Ingreso otro programa
		Date fecha4 = new Date();
		DtProgFormacion programa2 = new DtProgFormacion("Gatos","Anti-perros",fecha4 ,fecha4 ,fecha4);
		icap.ingresarProgFormacion(programa2);
		icap.confirmarAltaPrograma();
	}
	
	@Test
	public void Test_1a_buscarCursosOK() {
		Boolean todoOK = false;
		ArrayList<DtCurso> cursos = icb.buscarCursos("abra");
		for (DtCurso dt: cursos) {
			if (dt.getNombre().equals("Labradores")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_1b_buscarCursosOK() {
		Boolean todoOK = false;
		ArrayList<DtCurso> cursos = icb.buscarCursos("cacho");
		for (DtCurso dt: cursos) {
			if (dt.getNombre().equals("Labradores")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_1c_buscarCursosOK() {
		Boolean todoOK = false;
		ArrayList<DtCurso> cursos = icb.buscarCursos("pequi");
		for (DtCurso dt: cursos) {
			if (dt.getNombre().equals("Pequineses")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_2a_buscarProgramasOK() {
		Boolean todoOK = false;
		ArrayList<DtProgFormacion> progs = icb.buscarProgramas("ato");
		for (DtProgFormacion dt: progs) {
			if (dt.getNombre().equals("Gatos")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_2b_buscarProgramasOK() {
		Boolean todoOK = false;
		ArrayList<DtProgFormacion> progs = icb.buscarProgramas("mas");
		for (DtProgFormacion dt: progs) {
			if (dt.getNombre().equals("Labradores/Pequineses")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_2c_buscarProgramasOK() {
		Boolean todoOK = false;
		ArrayList<DtProgFormacion> progs = icb.buscarProgramas("pequi");
		for (DtProgFormacion dt: progs) {
			if (dt.getNombre().equals("Labradores/Pequineses")) {
				todoOK = true;
			}
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_3_ordenarCursosAlfOK() {
		Boolean todoOK = true;
		ArrayList<DtCurso> cursos = icb.buscarCursos("Perros");
		icb.ordenarCursosAlfabeticamente(cursos);
		int i=0;
		while (i<cursos.size()-1) {
			if(cursos.get(i).getNombre().compareTo(cursos.get(i+1).getNombre())>0){
				todoOK = false;
			}
			i++;
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_4_ordenarProgAlfOK() {
		Boolean todoOK = true;
		ArrayList<DtProgFormacion> progs = icb.buscarProgramas("a");
		icb.ordenarProgramasAlfabeticamente(progs);
		int i=0;
		while (i<progs.size()-1) {
			if(progs.get(i).getNombre().compareTo(progs.get(i+1).getNombre())>0){
				todoOK = false;
			}
			i++;
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_5_ordenarPorFechaProgOK() {
		Boolean todoOK = true;
		ArrayList<DtProgFormacion> progs = icb.buscarProgramas("");
		icb.ordenarProgramasPorFecha(progs);
		int i=0;
		while (i<progs.size()-1) {
			if(progs.get(i).getFechaAlta().compareTo(progs.get(i+1).getFechaAlta()) < 0){
				todoOK = false;
			}
			i++;
		}
		assertTrue(todoOK);
	}
	
	@Test
	public void Test_5_ordenarPorFechaCursosOK() {
		Boolean todoOK = true;
		ArrayList<DtCurso> cursos = icb.buscarCursos("");
		icb.ordenarCursosPorFecha(cursos);
		int i=0;
		while (i<cursos.size()-1) {
			if(cursos.get(i).getFechaR().compareTo(cursos.get(i+1).getFechaR()) < 0){
				todoOK = false;
			}
			i++;
		}
		assertTrue(todoOK);
	}
	
}
