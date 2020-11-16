package tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatype.DtCurso;
import datatype.DtCursoExp;
import datatype.DtProgFormacion;
import datatype.DtProgFormacionExp;
import excepciones.CategoriaRepetidaException;
import excepciones.CursoEnPFRepetidoException;
import excepciones.CursoRepetidoException;
import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaCategoria;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaProgFormacion;
import interfaces.IControladorConsultaProgFormacion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorConsultarProgFormacionTest {
	public Fabrica f = Fabrica.getInstancia();
	public IControladorConsultaProgFormacion iCon = f.getIControladorConsultaProgFormacion();
	public Date fecha = new Date();
	public DtProgFormacionExp auxProgFormacionExp= new DtProgFormacionExp();
	public DtCursoExp auxCursoExp = new DtCursoExp();
	
	@Test
	public void test_1_getProgramasDeFormacion() throws ProgramaRepetidoException {
		IControladorAltaProgFormacion iConAltaPF = f.getIControladorAltaProgFormacion();
		DtProgFormacion aux = new DtProgFormacion("nombreTest", "descTest", fecha, fecha, fecha);
		iConAltaPF.ingresarProgFormacion(aux);
		iConAltaPF.confirmarAltaPrograma();
		String [] programas = iCon.getProgramasDeFormacion();
	}
	
	@Test
	public void test_2_seleccionarPrograma() throws InstitutoRepetidaException, CategoriaRepetidaException, NoExisteInstitutoException, 
	CursoRepetidoException, NoExisteCursoException, CursoEnPFRepetidoException {
		//se crea instituto
		IControladorAltaInstituto iConAltaInstituto =f.getIControladorAltaInstituto();
		iConAltaInstituto.ingresarInstituto("institutoNombreTest");
		iConAltaInstituto.confirmarAltaInstituto();
		
		//se crea categoria
		IControladorAltaCategoria iConAltaCategoria = f.getIControladorAltaCategoria();
		iConAltaCategoria.ingresarCategoria("categoriaTest");

		//se crea curso
		IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
		List<String> categorias = new ArrayList<String>();
		List<String> previas = new ArrayList<String>();
		categorias.add("categoriaTest");
		DtCurso auxCurso = new DtCurso ("cursoNombreTest", "cursoDescTest", 0, 0, 0, fecha, "cursoUrlTest", previas, categorias);
		iConAltaCurso.ingresarCurso("institutoNombreTest", auxCurso);
		iConAltaCurso.confirmarAltaCurso();
		
		//se agrega curso a programa
		IControladorAgregarCursoAPF iConAgregarCursoAPF = f.getIControladorAgregarCursoAPF();
		iConAgregarCursoAPF.seleccionarPrograma("nombreTest");
		iConAgregarCursoAPF.seleccionarCurso("cursoNombreTest");
		
		//se prueba la operacion
		auxProgFormacionExp= iCon.seleccionarPrograma("nombreTest");
	}
	
	@Test
	public void test_3_getCategoriasPrograma(){
		iCon.getCategoriasPrograma("nombreTest");
	}
	
	@Test
	public void test_4_seleccionarCurso() {
		auxCursoExp=iCon.seleccionarCurso("cursoNombreTest");		
	}
	
	@Test 
	public void test_5_getCursos() {
		iCon.getCursos(auxProgFormacionExp);
	}
	
	@Test
	public void test_6_obtenerDatosPrograma() {
		iCon.obtenerDatosPrograma(auxProgFormacionExp);
	}
	
	@Test
	public void test_7_obtenerDatosCurso() {
		iCon.obtenerDatosCurso(auxCursoExp);
	}
	

}
