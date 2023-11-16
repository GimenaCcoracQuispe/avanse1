package pe.edu.vallegrande_AS222_T13.Prueba;

import pe.edu.vallegrande_AS222_T13.Service.Impl.CrudClienteService;

public class EliminadoLogico {
	public static void main(String[] args) {
		try {
			// Datos de consulta
			Integer id = 4;
			// Proceso
			CrudClienteService service = new CrudClienteService();
			service.delete(id);
			// Reporte
			System.out.println("Registro eliminado logicamente.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
