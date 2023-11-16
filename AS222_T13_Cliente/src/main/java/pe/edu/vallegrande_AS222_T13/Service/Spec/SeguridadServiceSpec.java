package pe.edu.vallegrande_AS222_T13.Service.Spec;

import pe.edu.vallegrande_AS222_T13.Model.SellerModel;

public interface SeguridadServiceSpec {
	SellerModel validar(String usuario, String clave);
}
