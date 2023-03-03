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

import ec.org.inspi.pnpe.models.EnfermedadTasaLv2;

@Data
public class EnfermedadTasaLv1Tree {

	private Integer id;
	private Integer provinceId;
	private String cie;
	private Integer frecuencia;
	private Integer poblacion;
	private Double tasa;
	private List<EnfermedadTasaLv2> enfermedadTasaLv2;
	
}