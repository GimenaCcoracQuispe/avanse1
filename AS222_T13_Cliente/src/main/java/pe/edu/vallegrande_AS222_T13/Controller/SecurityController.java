package pe.edu.vallegrande_AS222_T13.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande_AS222_T13.Model.SellerModel;
import pe.edu.vallegrande_AS222_T13.Service.Impl.SeguridadService;
import pe.edu.vallegrande_AS222_T13.Service.Spec.SeguridadServiceSpec;


@WebServlet({ "/InicioSession", "/CerrarSesion" })
public class SecurityController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/CerrarSesion":
			cerrarSesion(request, response);
			break;

		}
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		String destino = "index.jsp";
		// Forward
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch(path) {
		case "/InicioSession":
			inicioSession(request,response);
			break;
		}
	}
	
	private void inicioSession(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Variables
				String destino, usuario, password;
				SellerModel seller;
				try {
					// Datos
					usuario = request.getParameter("usuario");
					password = request.getParameter("password");
					// Proceso
					SeguridadServiceSpec seguridad = new SeguridadService();
					seller = seguridad.validar(usuario, password);
					if (seller == null) {
						request.setAttribute("error", "Usuario o clave incorrectos");
						destino = "index.jsp";
					} else {
						request.getSession().setAttribute("usuario", seller);
						destino = "main.jsp";
					}
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
					destino = "index.jsp";
				}
		//Forward
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
