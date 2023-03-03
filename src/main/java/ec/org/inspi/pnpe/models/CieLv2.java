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
@Table(name = "cie_diez_level_dos", schema = "CIE")
public class CieLv2 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "level0_id")
	private CieLv1 cieLv1;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "serial")
	private String serial;
}