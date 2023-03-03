package ec.org.inspi.pnpe.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ec.org.inspi.pnpe.models.EnfermedadTasaLv3;

public interface EnfermedadLv3Repository extends PagingAndSortingRepository<EnfermedadTasaLv3, Integer>{
	List<EnfermedadTasaLv3> findTop10ByProvinceIdAndCie10OrderByTasaDesc(Integer provinceId, String cie);

}
