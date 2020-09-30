package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;


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
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaCurso iCon = f.getIControladorAltaCurso();
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
		ArrayList<String> listaPrevias;
		ArrayList<String> listaCategorias;
		
		
		int i=0;
		if (previas!=null) {
			listaPrevias = new ArrayList(previas.length);
			while (i<previas.length) {
				listaPrevias.add(previas[i]);
				i++;
			}
		}else {
			listaPrevias = new ArrayList();
		}
		
		
		int j=0;
		if (categorias!=null) {
			listaCategorias = new ArrayList(categorias.length);
			while (j<categorias.length) {
				listaCategorias.add(categorias[j]);
				j++;
			}
		}else {
			listaCategorias = new ArrayList();
		}
		
		
		DtCurso dt = new DtCurso(nombre, desc, duracion, cantHoras, creditos, fechaR, url, listaPrevias, listaCategorias);			
		
		try {
			iCon.ingresarCurso(instituto, dt);
			iCon.confirmarAltaCurso();
		}catch (NoExisteInstitutoException neie) {
			throw new ServletException(neie.getMessage());
		}catch(CursoRepetidoException cre) {
			throw new ServletException (cre.getMessage());
		}catch (NoExisteCursoException nece) {
			throw new ServletException(nece.getMessage());
		}
		
		HttpSession session = request.getSession(true);
		
		
		RequestDispatcher rd;
		request.setAttribute("mensaje", "El curso " + nombre + " se ha creado con éxito en el sistema");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
	}

}
