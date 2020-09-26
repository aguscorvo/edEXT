package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.NoExisteUsuarioException;
import interfaces.Fabrica;
import interfaces.IControladorIniciarSesion;


@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IniciarSesion() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickOEmail = request.getParameter("nickOEmail");
		String contraseña = request.getParameter("password");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorIniciarSesion iCon = fabrica.getIControladorIniciarSesion();
		String tipo="";
		
		try {
			tipo= iCon.iniciarSesion(nickOEmail, contraseña);
		} catch (NoExisteUsuarioException e) {
			throw new ServletException(e.getMessage());
		}
		
		HttpSession session = request.getSession(true);
		if (tipo.equals("estudiante"))
			session.setAttribute("tipoUsuarioLogueado", "estudiante");
		else if(tipo.equals("docente"))
			session.setAttribute("tipoUsuarioLogueado", "docente");
			
		RequestDispatcher rd;
		request.setAttribute("mensaje", "Sesion iniciada. Usuario tipo: " + tipo);
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
	}

}





	