package pe.edu.vallegrande_AS222_T13.Prueba;

import pe.edu.vallegrande_AS222_T13.Model.SellerModel;
import pe.edu.vallegrande_AS222_T13.Service.Impl.SeguridadService;
import pe.edu.vallegrande_AS222_T13.Service.Spec.SeguridadServiceSpec;

public class PruebaLogin {
	public static void main(String[] args) {
		try {
			// Datos de consulta
			String usuario = "eaguero";
			String password = "cazador";
			// Proceso
			SeguridadServiceSpec service = new SeguridadService();
			SellerModel bean = service.validar(usuario, password);
			String reporte = "Datos incorrectos.";
			if(bean != null) {
				reporte = "Datos correctos. Hola " + bean.getName() + ".";
			}
			// Reporte
			System.out.println(reporte);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
