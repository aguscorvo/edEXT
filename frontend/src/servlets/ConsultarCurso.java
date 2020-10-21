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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String institutoOCategoria = request.getParameter("institutosCategorias").trim();
		String tipo = request.getParameter("tipo").trim();		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorConsultaCurso iCon = fabrica.getIControladorConsultaCurso();
		
		//request.setAttribute("cursosAMostrar", cursos);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultarCurso.jsp");
        dispatcher.forward(request, response);
	}

}
