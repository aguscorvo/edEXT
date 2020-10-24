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


import interfaces.IControladorInscripcionAPrograma;



@WebServlet("/InscripcionPrograma")
public class InscripcionPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InscripcionPrograma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("nick");
		
		String programa = request.getParameter("programa");
		
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorInscripcionAPrograma iCon = fabrica.getIControladorInscripcionAPrograma();
		
		boolean inscribir = iCon.confirmarInscripcion(nick, programa);
		
 		RequestDispatcher rd;
		
		if (inscribir) {
			request.setAttribute("mensaje", "Tu inscripción al programa '" + programa + "' se ha efectuado con éxito.");
		}
		else {
			request.setAttribute("mensaje", "Error al procesar.\nYa te has inscripto con anterioridad al programa '" + programa + "'.");
				
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}
