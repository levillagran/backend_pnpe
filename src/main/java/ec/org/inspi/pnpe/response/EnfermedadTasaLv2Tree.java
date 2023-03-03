/**
 * 
 */
package ec.org.inspi.pnpe.response;

/**
 * @author episig := Lenin Villagran
 *
 */
import lombok.Data;

import java.util.List;

import ec.org.inspi.pnpe.models.EnfermedadTasaLv3;

@Data

public class EnfermedadTasaLv2Tree {

	private Integer id;
	private Integer provinceId;
	private String cie;
	private Integer frecuencia;
	private Integer poblacion;
	private Double tasa;
	private List<EnfermedadTasaLv3> enfermedadTasaLv3;
	
}