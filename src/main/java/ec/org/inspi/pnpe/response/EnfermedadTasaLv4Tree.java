/**
 * 
 */
package ec.org.inspi.pnpe.response;

/**
 * @author episig := Lenin Villagran
 *
 */
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "disease_prioritization_lv4_2021", schema = "health")
public class EnfermedadTasaLv4Tree {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "province_id")
	private Integer provinceId;
	@Column(name = "cie10_code")
	private String cie;
	@Column(name = "frequency")
	private Integer frecuencia;
	@Column(name = "population")
	private Integer poblacion;
	@Column(name = "rate")
	private Double tasa;
	
}