package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String nombre = request.getParameter("nobmre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("correo");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		//controlar que sea docente
		String instituto = request.getParameter("instituto");
		//chequear cómo hacer lo siguiente
		String radioButtonDocente = (String) request.getParameter("docente");
		String radioButtonEstudiante = (String) request.getParameter("estudiante");
		
		
		
		RequestDispatcher rd;
		request.setAttribute("mensaje", "Usuario registrado.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}
