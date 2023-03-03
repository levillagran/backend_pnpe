package ec.org.inspi.pnpe.response.defunciones;

import java.util.List;

import lombok.Data;

@Data
public class Root {
	
	private String key;
	private Datos data;
	private List<Padre> children;

}
