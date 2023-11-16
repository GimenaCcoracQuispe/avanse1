package pe.edu.vallegrande_AS222_T13.Prueba;

import java.util.List;

import pe.edu.vallegrande_AS222_T13.Model.ClienteModel;
import pe.edu.vallegrande_AS222_T13.Service.Impl.CrudClienteService;



public class Prueba03 {
	public static void main(String[] args) {
		
		try {
			// Datos de consulta
			// Datos de consulta
						ClienteModel model = new ClienteModel();
						model.setName("Alice");
						model.setLast_names("");
						model.setNumber_document("");
						// Proceso
						CrudClienteService service = new CrudClienteService();
						List<ClienteModel> lista = service.get(model);
						// Reporte
						System.out.println("LISTADO");
						System.out.println("Registros: " + lista.size());
						for (ClienteModel rec : lista) {
							System.out.println(rec.getId() + " - " + rec.getName() + " - " + rec.getLast_names());
						}
						
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			// TODO: handle exception
		}
		
	}
}
	
