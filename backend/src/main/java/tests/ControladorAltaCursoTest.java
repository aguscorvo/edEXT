package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtCurso;
import excepciones.CategoriaRepetidaException;
import excepciones.CursoRepetidoException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.*;
import logica.Curso;
import logica.ManejadorCurso;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAltaCursoTest {
	
	public Fabrica f = Fabrica.getInstancia();
	public IControladorAltaCategoria iConCa = f.getIControladorAltaCategoria();
	public IControladorAltaInstituto iConI = f.getIControladorAltaInstituto();
	public IControladorAltaCurso iConCu = f.getIControladorAltaCurso();

	
	
	
	@Test
	public void Test_1_getCategoriasOK() throws CategoriaRepetidaException   {		
		
		Boolean esta = false;
		iConCa.ingresarCategoria("CategoriaACT");
		String [] cats = iConCu.getCategorias();
		for (int i =0; i<cats.length; i++) {
			if (cats[i].equals("CategoriaACT")) {
				esta = true;
			}
		}
		assertTrue(esta);
		
	}

	@Test
	public void Test_2_getInstitutosOK() throws InstitutoRepetidaException  {		
		
		Boolean esta = false;
		iConI.ingresarInstituto("InstitutoACT");
		iConI.confirmarAltaInstituto();
		String [] insts = iConCu.getInstitutos();
		for (int i =0; i<insts.length; i++) {
			if (insts[i].equals("InstitutoACT")) {
				esta = true;
			}
		}
		assertTrue(esta);
		
	}

	@Test
	public void Test_3_confirmarAltaCursoOK() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		categorias.add("CategoriaACT");
		DtCurso curso = new DtCurso("CursoACT", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoACT", curso);
		iConCu.confirmarAltaCurso();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso nuevo = mc.getCurso("CursoACT");
		assertNotNull(nuevo);
		
	}
	
	@Test (expected = CursoRepetidoException.class)
	public void Test_4_confirmarAltaCursoRepetido() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoACT", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoACT", curso);
		
	}
	
	@Test
	public void Test_5_getCursosOK()  {		
		
		Boolean esta = false;
		
		String [] cursos = iConCu.getCursos();
		for (int i =0; i<cursos.length; i++) {
			if (cursos[i].equals("CursoACT")) {
				esta = true;
			}
		}
		
		assertTrue(esta);
	}

	@Test (expected = NoExisteCursoException.class)
	public void Test_3_confirmarCurso_PreviaInexistente() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		previas.add("PreviaQueNoExisteNiExistiraJamas");
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoACTPrueba", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoACT", curso);
		
	}
	
	@Test (expected = NoExisteInstitutoException.class)
	public void Test_6_confirmarCurso_InstitutoNoExiste() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoACTPrueba", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoQueNoExisteNiExistiraJamas", curso);
		
	}
	
	@Test
	public void Test_7_confirmarCurso_ConPreviaOK() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		previas.add("CursoACT");
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoACTPrueba", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoACT", curso);
		iConCu.confirmarAltaCurso();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso nuevo = mc.getCurso("CursoACTPrueba");
		assertNotNull(nuevo);
	}
	
	@Test
	public void Test_8_cancelarOK() throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException  {		
		
		Date fecha = new Date();
		List <String> previas = new ArrayList<String>();
		List <String> categorias = new ArrayList<String>();
		DtCurso curso = new DtCurso("CursoACTPruebaCancelar", "A", 2, 2, 2, fecha, "http://gg.com", previas, categorias);
		iConCu.ingresarCurso("InstitutoACT", curso);
		iConCu.cancelarAltaCurso();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso nuevo = mc.getCurso("CursoACTPruebaCancelar");
		assertNull(nuevo);
	}
	
}
