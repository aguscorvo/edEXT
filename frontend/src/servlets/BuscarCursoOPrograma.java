package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BuscarCursoOPrograma")
public class BuscarCursoOPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BuscarCursoOPrograma() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombreCurso1= request.getParameter("nombreCurso1");
		String nombreCurso2= request.getParameter("nombreCurso2");
		String nombrePrograma1= request.getParameter("nombrePrograma1");
		String nombrePrograma2= request.getParameter("nombrePrograma2");

		//HttpSession session = request.getSession();

		if (!nombreCurso1.equals(null)||!nombreCurso2.equals(null)) {
		
			if (!nombreCurso1.equals(null)) {
				System.out.println(nombreCurso1);
				//session.setAttribute("nombreCurso", nombreCurso1);
				request.setAttribute("curso", nombreCurso1);
			}else if (!nombreCurso2.equals(null)) {
				System.out.println(nombreCurso2);
				//session.setAttribute("nombreCurso", nombreCurso2);
				request.setAttribute("curso", nombreCurso2);
			}
			
			RequestDispatcher rd;
			
			rd = request.getRequestDispatcher("/buscarCurso.jsp");
			rd.forward(request, response);
			
			
		}else if(!nombrePrograma1.equals(null) || !nombrePrograma2.equals(null)) {
			if (!nombrePrograma1.equals(null)) {
				System.out.println(nombrePrograma1);
				//session.setAttribute("nombrePrograma", nombrePrograma1);

			}else if (!nombrePrograma2.equals(null)) {
				System.out.println(nombrePrograma2);
				//session.setAttribute("nombrePrograma", nombrePrograma2);
			}
		}
		
	
	}

}
