package pe.edu.vallegrande_AS222_T13.Prueba;

import java.sql.SQLException;
import java.util.List;


import pe.edu.vallegrande_AS222_T13.Model.ClienteModel;
import pe.edu.vallegrande_AS222_T13.Service.Impl.CrudClienteService;




public class Prueba02 {
	public static void main(String[] args) {
		try {
			CrudClienteService service = new CrudClienteService();
			List<ClienteModel> lista = service.getAll();
			
			for (ClienteModel rec : lista) {
				System.out.println(rec.getId() + " - " + rec.getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

