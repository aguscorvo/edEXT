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
		
		
		
		if (previas!=null) {
			int i=0;
			listaPrevias = new ArrayList<String>();
			while (i<previas.length) {
				listaPrevias.add(previas[i]);
				i++;
			}
		}else {
			listaPrevias = new ArrayList<String>();
		}
		
		
		if (categorias!=null) {
			int j=0;
			listaCategorias = new ArrayList<String>();
			while (j<categorias.length) {
				listaCategorias.add(categorias[j]);
				j++;
			}
		}else {
			listaCategorias = new ArrayList<String>();
		}
		
		
		DtCurso dt = new DtCurso(nombre, desc, duracion, cantHoras, creditos, fechaR, url, listaPrevias, listaCategorias);			
		
		try {
			iCon.ingresarCurso(instituto, dt);
			iCon.confirmarAltaCurso();
			request.setAttribute("mensaje", "El curso " + nombre + " se ha creado con éxito en el sistema");
		}catch (NoExisteInstitutoException neie) {
			request.setAttribute("mensaje", "El instituto " + "'" + instituto + "'" + " no se encuentra registrado en el sistema.\nIntente nuevamente.");
		}catch(CursoRepetidoException cre) {
			request.setAttribute("mensaje", "El curso " + "'" + nombre + "'" + " ya se encuentra registrado en el sistema.\nIntente nuevamente.");
		}catch (NoExisteCursoException nece) {
			request.setAttribute("mensaje", "El curso " + "'" + nombre + "'" + " no se encuentra registrado en el sistema.\nIntente nuevamente.");
		}	
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
	}

}
