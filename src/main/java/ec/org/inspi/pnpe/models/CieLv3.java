/**
 * 
 */
package ec.org.inspi.pnpe.models;

/**
 * @author episig := Lenin Villagran
 *
 */
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cie_diez_level_tres", schema = "CIE")
public class CieLv3 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "level1_id")
	private CieLv2 cieLv2;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	
}