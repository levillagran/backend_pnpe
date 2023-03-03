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
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cie_diez_level_uno", schema = "CIE")
public class CieLv1 {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "serial")
	private String serial;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	
}