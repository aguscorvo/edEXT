package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import excepciones.CursoEnPFRepetidoException;
import excepciones.CursoRepetidoException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import logica.Curso;
import logica.ManejadorCurso;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAgregarCursoAPFTest {

	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorAgregarCursoAPF iConCursoAPF = f.getIControladorAgregarCursoAPF();
	public static IControladorAltaCurso iConAltaCur = f.getIControladorAltaCurso();
	public static IControladorAltaProgFormacion iConAltaProg = f.getIControladorAltaProgFormacion();
	public static IControladorAltaInstituto iConAltaInst = f.getIControladorAltaInstituto();
	
	@BeforeClass
	public static void inicializar() throws ProgramaRepetidoException, InstitutoRepetidaException, NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException {
		
		//hardcodeo un PF con nombre "programaPrueba"
		Date fecha1 = new Date();
		DtProgFormacion programa = new DtProgFormacion("programaPrueba","es una prueba",fecha1,fecha1,fecha1);
		iConAltaProg.ingresarProgFormacion(programa);
		iConAltaProg.confirmarAltaPrograma();
		
		//hardcodeo un instituto
		iConAltaInst.ingresarInstituto("institutoPrueba");
		iConAltaInst.confirmarAltaInstituto();
		
		//hardcodeo un Curso con nombre "cursoPrueba"
		Date fecha2 = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("cursoPrueba","prueba",1,1,1,fecha2,"http://hola.com",previas, categorias);
		iConAltaCur.ingresarCurso("institutoPrueba", curso);
		iConAltaCur.confirmarAltaCurso();
		
		
		
	}
	
	@Test
	public void Test_1_ProgramasNotNull() throws ProgramaRepetidoException {
		String[] programasBase = iConCursoAPF.getProgramas();
		String[] programas = {"programaPrueba"};
		assertArrayEquals(programasBase, programas);
		
	}
	
	@Test
	public void Test_2_cursosNotNull() {
		String[] cursosBase = iConCursoAPF.getCursos();
		String[] cursos = {"cursoPrueba"};
		assertArrayEquals(cursosBase, cursos);
	}
	
	@Test
	public void Test_3_seleccionarCursoOK() throws CursoEnPFRepetidoException {
		
		iConCursoAPF.seleccionarPrograma("programaPrueba");
		iConCursoAPF.seleccionarCurso("cursoPrueba");
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso aux = mc.getCurso("cursoPrueba");
		List<ProgFormacion> progs = aux.getProgramas();
		Boolean esta = false;
		for(ProgFormacion pf: progs) {
			if(pf.getNombre().equals("programaPrueba"))
				esta = true;
		}
		assertTrue(esta);
	}
	
	@Test(expected = CursoEnPFRepetidoException.class)
	public void Test_4_seleccionarCursoERROR() throws CursoEnPFRepetidoException {
		iConCursoAPF.seleccionarPrograma("programaPrueba");
		iConCursoAPF.seleccionarCurso("cursoPrueba");
		
	}
	

	
}
