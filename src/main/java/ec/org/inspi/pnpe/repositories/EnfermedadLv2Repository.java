package ec.org.inspi.pnpe.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ec.org.inspi.pnpe.models.EnfermedadTasaLv2;

public interface EnfermedadLv2Repository extends PagingAndSortingRepository<EnfermedadTasaLv2, Integer>{
	List<EnfermedadTasaLv2> findTop10ByProvinceIdAndCieOrderByTasaDesc(Integer provinceId, String cie);
	
}
