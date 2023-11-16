package pe.edu.vallegrande_AS222_T13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class ClienteModel {

	private Integer id;
	private String name;
	private String last_names;
	private String type_document;
	private String number_document;
	private String cellphone;
	private String email;
	private String birthday;
	private String status;
}
