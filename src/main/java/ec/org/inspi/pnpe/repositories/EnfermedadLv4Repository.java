package ec.org.inspi.pnpe.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ec.org.inspi.pnpe.models.EnfermedadTasaLv3;
import ec.org.inspi.pnpe.models.EnfermedadTasaLv4;

public interface EnfermedadLv4Repository extends PagingAndSortingRepository<EnfermedadTasaLv4, Integer>{
	List<EnfermedadTasaLv4> findTop10ByProvinceIdAndCieOrderByTasaDesc(Integer provinceId, String cie);

}
