package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import interfaces.Fabrica;
import interfaces.IControladorSeguirUsuarios;



@WebServlet("/SeguirUsuario")
public class SeguirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SeguirUsuario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioASeguir = request.getParameter("usuario");
		
		HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("nick");
		
		Fabrica f = Fabrica.getInstancia();
		IControladorSeguirUsuarios iCon = f.getIcontroladorSeguirUsuarios();
		
		RequestDispatcher rd;
		
		iCon.seguirUsuario(usuario, usuarioASeguir);
		request.setAttribute("mensaje", "Hecho!\nEstás siguiendo al usuario '" + usuarioASeguir + "'.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}

}
