package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;


@WebServlet("/ConsultarCurso")
public class ConsultarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ConsultarCurso() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String institutoOCategoria = request.getParameter("institutosCategorias").trim();
		String tipo = request.getParameter("tipo").trim();
		//System.out.println(tipo);
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaCurso iCon = fabrica.getIControladorConsultaCurso();
		String [] cursos= null;
				
		if (tipo.equals("instituto"))
		cursos = iCon.ingresarInstituto(institutoOCategoria);
		else if(tipo.equals("categoria"))
			cursos = iCon.getCursosPorCategoria(institutoOCategoria);
			
		/*for(int i=0; i<cursos.length; i++) {
			System.out.println("curso: " + cursos[i]);
		}*/
		
		
		String prueba= "Instituto o categoria seleccionado: "+ institutoOCategoria;
		response.setContentType("text/plain");
		response.getWriter().write(prueba);
		
		request.setAttribute("cursosAMostrar", cursos);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultarCurso.jsp");
        dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
