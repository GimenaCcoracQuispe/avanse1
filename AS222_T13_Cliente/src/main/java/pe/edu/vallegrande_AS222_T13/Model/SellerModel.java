package pe.edu.vallegrande_AS222_T13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SellerModel {
	
	private Integer id;
	private String last_name;
	private String name;
	private String address;
	private String email;
	private String usuario;
	private String password;
	
}
