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

import ec.org.inspi.pnpe.models.EnfermedadTasaLv4;

@Data
public class EnfermedadTasaLv3Tree {

	private Integer id;
	private Integer provinceId;
	private String cie10;
	private Integer frecuencia;
	private Integer poblacion;
	private Double tasa;
	private List<EnfermedadTasaLv4> enfermedadTasaLv4;
	
}