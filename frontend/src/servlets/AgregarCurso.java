package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import excepciones.CursoEnPFRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;



@WebServlet("/AgregarCurso")
public class AgregarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AgregarCurso() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String programa = request.getParameter("programa");
		String curso = request.getParameter("curso");
		
		Fabrica f = Fabrica.getInstancia();
		IControladorAgregarCursoAPF iCon = f.getIControladorAgregarCursoAPF();
		
		RequestDispatcher rd;
		
		iCon.seleccionarPrograma(programa);
		try {
			iCon.seleccionarCurso(curso);
			request.setAttribute("mensaje", "Se agregó '" + curso + "' al programa de formación ' " + programa + "' con éxito.");
		} catch (CursoEnPFRepetidoException e) {
			request.setAttribute("mensaje", "Error al procesar.\nEl curso '" + curso + "' ya pertenece al programa de formación ' " + programa + "'.");
			e.printStackTrace();
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}

}
