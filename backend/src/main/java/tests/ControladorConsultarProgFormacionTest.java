package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
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
import logica.Categoria;
import logica.Curso;
import logica.ManejadorCurso;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;
import logica.funcionesAux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorConsultarProgFormacionTest {
	
	public static Fabrica f = Fabrica.getInstancia();
	public static IControladorConsultaProgFormacion iCon = f.getIControladorConsultaProgFormacion();
	public static IControladorAltaInstituto iConAltaInstituto =f.getIControladorAltaInstituto();
	public static IControladorAltaCategoria iConAltaCategoria = f.getIControladorAltaCategoria();
	public static IControladorAltaCurso iConAltaCurso = f.getIControladorAltaCurso();
	public static IControladorAltaProgFormacion iConAltaPrograma =f.getIControladorAltaProgFormacion();
	public static IControladorAgregarCursoAPF iConAgregarCursoAPF = f.getIControladorAgregarCursoAPF();

	@BeforeClass
	public static void inicializarTest() throws InstitutoRepetidaException, CategoriaRepetidaException, NoExisteInstitutoException, 
	CursoRepetidoException, NoExisteCursoException, CursoEnPFRepetidoException, ProgramaRepetidoException {
		//se crea instituto				
		iConAltaInstituto.ingresarInstituto("institutoNombreTest");
		iConAltaInstituto.confirmarAltaInstituto();		
		//se crea categoria
		iConAltaCategoria.ingresarCategoria("categoriaTest");	
		//se crean dos cursos
		List<String> categorias = new ArrayList<String>();
		List<String> previas = new ArrayList<String>();
		categorias.add("categoriaTest");
		Date fecha = new Date();
		DtCurso auxCurso = new DtCurso ("cursoNombreTest", "cursoDescTest", 0, 0, 0, fecha, "cursoUrlTest", previas, categorias);
		iConAltaCurso.ingresarCurso("institutoNombreTest", auxCurso);
		iConAltaCurso.confirmarAltaCurso();	
		List<String> previas2 = new ArrayList<String>();
		previas2.add("cursoNombreTest");
		DtCurso auxCurso2 = new DtCurso ("curso2NombreTest", "curso2DescTest", 0, 0, 0, fecha, "curso2UrlTest", previas2, categorias);
		iConAltaCurso.ingresarCurso("institutoNombreTest", auxCurso2);
		iConAltaCurso.confirmarAltaCurso();
		//se crean programas
		DtProgFormacion pf1 = new DtProgFormacion ("prog1Nombre", "prog1Desc", fecha, fecha, fecha);
		DtProgFormacion pf2 = new DtProgFormacion ("prog2Nombre", "prog2Desc", fecha, fecha, fecha);
		iConAltaPrograma.ingresarProgFormacion(pf1);
		iConAltaPrograma.confirmarAltaPrograma();
		iConAltaPrograma.ingresarProgFormacion(pf2);
		iConAltaPrograma.confirmarAltaPrograma();		
		//se agregan cursos a programas
		iConAgregarCursoAPF.seleccionarPrograma("prog1Nombre");
		iConAgregarCursoAPF.seleccionarCurso("cursoNombreTest");
		iConAgregarCursoAPF.seleccionarPrograma("prog1Nombre");
		iConAgregarCursoAPF.seleccionarCurso("curso2NombreTest");
		iConAgregarCursoAPF.seleccionarPrograma("prog2Nombre");
		iConAgregarCursoAPF.seleccionarCurso("curso2NombreTest");	
		
	}
	
	@Test
	public void test_1_getProgramasDeFormacion() throws ProgramaRepetidoException {
		String [] programas = iCon.getProgramasDeFormacion();
		ManejadorProgFormacion mPF = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> programasManejador = mPF.getProgFormacion();
		String[] arrProgramasManejador = new String [programasManejador.size()];
		int i=0;
		for (ProgFormacion p: programasManejador) {
			arrProgramasManejador[i]=p.getNombre();
			i++;
		}
		assertArrayEquals(arrProgramasManejador, programas);
		
	}
	
	@Test
	public void test_1_getCursos()  {
		DtProgFormacionExp aux = iCon.seleccionarPrograma("prog1Nombre");
		String [] cursos = iCon.getCursos(aux);		
		
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador= new ArrayList<Curso>(mC.getCursos());
		List<String> cursosConPrograma= new ArrayList<String>();
		List<ProgFormacion>programas = new ArrayList<ProgFormacion>();
		Curso curso;
		List<Curso> listCursos = new ArrayList<Curso>();
		for(Curso c: cursosManejador) {
			programas= c.getProgramas();
			for(ProgFormacion pf: programas) {
				if (pf.getNombre().equals("prog1Nombre")) {
					cursosConPrograma.add(c.getNombre());
				}
			}
		}
		String[] arrCursosConPrograma = new String[cursosConPrograma.size()];
		cursosConPrograma.toArray(arrCursosConPrograma);
		
		assertArrayEquals(arrCursosConPrograma, cursos);
		
	}
	
	
	@Test
	public void test_3_getCategoriasPrograma(){
		String [] categorias = iCon.getCategoriasPrograma("prog1Nombre");
		
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		List<Curso> cursosManejador= new ArrayList<Curso>(mC.getCursos());
		List<ProgFormacion>programas = new ArrayList<ProgFormacion>();
		Set<String> listCategoriasPrograma = new HashSet<String>();
		List<Categoria> listCategorias = new ArrayList<Categoria>();

		Curso curso;
		List<Curso> listCursos = new ArrayList<Curso>();
		for(Curso c: cursosManejador) {
			programas= c.getProgramas();
			for(ProgFormacion pf: programas) {
				if (pf.getNombre().equals("prog1Nombre")) {
					listCategorias=c.getCategorias();
					for (Categoria cat: listCategorias) {
						listCategoriasPrograma.add(cat.getNombreCategoria());
					}
				}
			}
		}
		String[] arrCategoriasPrograma = new String[listCategoriasPrograma.size()];
		listCategoriasPrograma.toArray(arrCategoriasPrograma);
		
		assertArrayEquals(arrCategoriasPrograma, categorias);	
		
	}
	
	@Test
	public void test_4_obtenerDatosPrograma() {
		DtProgFormacionExp aux = iCon.seleccionarPrograma("prog1Nombre");
		String datosPrograma = iCon.obtenerDatosPrograma(aux);
		
		Boolean test=false;
		if (datosPrograma.contains(aux.getNombre()) && datosPrograma.contains(aux.getDesc()) && 
				datosPrograma.contains(funcionesAux.convertirAString(aux.getFechaI())) && 
				datosPrograma.contains(funcionesAux.convertirAString(aux.getFechaF())) &&
				datosPrograma.contains(funcionesAux.convertirAString(aux.getFechaAlta()))) {
			test=true;
		}else test=false;
		
		assertTrue(test);		
	}
	
	
	
	@Test
	public void test_5_obtenerDatosCurso() {
		DtCursoExp aux = iCon.seleccionarCurso("curso2NombreTest");
		String datosCurso = iCon.obtenerDatosCurso(aux);
		
		Boolean test=false;
		 
		if (datosCurso.contains(aux.getNombre()) && datosCurso.contains(aux.getDesc()) && datosCurso.contains(Integer.toString(aux.getDuracion())) &&
				datosCurso.contains(Integer.toString(aux.getCantHoras())) && datosCurso.contains(Integer.toString(aux.getCreditos())) &&
				datosCurso.contains(funcionesAux.convertirAString(aux.getFechaR())) && datosCurso.contains(aux.getUrl())) {
			test=true;
		}else test=false;
		
		assertTrue(test);	
		
	}
	

}
