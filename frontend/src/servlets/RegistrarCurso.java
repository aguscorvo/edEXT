package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.ContraseniaIncorrectaException;
import publicadores.ControladorAltaCursoPublish;
import publicadores.ControladorAltaCursoPublishService;
import publicadores.ControladorAltaCursoPublishServiceLocator;
import publicadores.ControladorIniciarSesionPublish;
import publicadores.ControladorIniciarSesionPublishService;
import publicadores.ControladorIniciarSesionPublishServiceLocator;
import publicadores.CursoRepetidoException;
import publicadores.DtCurso;
import publicadores.DtUsuarioLogueado;
import publicadores.NoExisteCursoException;
import publicadores.NoExisteInstitutoException;
import publicadores.NoExisteUsuarioException;



@WebServlet("/RegistrarCurso")
public class RegistrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarCurso() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String instituto = request.getParameter("instituto");
		String nombre = request.getParameter("nombre");
		String desc = request.getParameter("descripcion");
		int duracion = Integer.valueOf(request.getParameter("duracion"));
		int cantHoras = Integer.valueOf(request.getParameter("cantHoras"));
		int creditos = Integer.valueOf(request.getParameter("creditos"));
		Date fechaR = new Date();
		String url = request.getParameter("url");
		String [] previas = request.getParameterValues("previas");
		String [] categorias = request.getParameterValues("categorias");
			
		
		DtCurso dt = new DtCurso(cantHoras, categorias, creditos, desc,duracion,fechaR,nombre, previas, url);			
		
		try {
			ingresarCurso(instituto, dt);
			confirmarAltaCurso();
			request.setAttribute("mensaje", "El curso " + nombre + " se ha creado con éxito en el sistema");
		}catch (Exception e) {			
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
	}
	
	public void ingresarCurso(String instituto, DtCurso curso) throws ServiceException, NoExisteInstitutoException, NoExisteCursoException, CursoRepetidoException, RemoteException {
		
		ControladorAltaCursoPublishService cps = new ControladorAltaCursoPublishServiceLocator();
		ControladorAltaCursoPublish port = cps.getControladorAltaCursoPublishPort();
		port.ingresarCurso(instituto, curso);

	}
	
	public void confirmarAltaCurso() throws ServiceException, RemoteException{
		
		ControladorAltaCursoPublishService cps = new ControladorAltaCursoPublishServiceLocator();
		ControladorAltaCursoPublish port = cps.getControladorAltaCursoPublishPort();
		port.confirmarAltaCurso();

	}

}
