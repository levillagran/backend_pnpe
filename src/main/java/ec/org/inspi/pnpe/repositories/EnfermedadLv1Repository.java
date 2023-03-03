package ec.org.inspi.pnpe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.org.inspi.pnpe.models.EnfermedadTasaLv1;

public interface EnfermedadLv1Repository extends CrudRepository<EnfermedadTasaLv1, Integer>{
	List<EnfermedadTasaLv1> findAllByProvinceIdOrderByTasaDesc(Integer provinceId);
	
}
