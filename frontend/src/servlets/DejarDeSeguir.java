
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



@WebServlet("/DejarDeSeguir")
public class DejarDeSeguir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DejarDeSeguir() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioNoSeguir = request.getParameter("usuario");
		
		HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("nick");
		
		Fabrica f = Fabrica.getInstancia();
		IControladorSeguirUsuarios iCon = f.getIcontroladorSeguirUsuarios();
		
		RequestDispatcher rd;
		
		iCon.noSeguirUsuario(usuario, usuarioNoSeguir);
		request.setAttribute("mensaje", "Hecho!\nDejaste de seguir al usuario '" + usuarioNoSeguir + "'.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}

}
