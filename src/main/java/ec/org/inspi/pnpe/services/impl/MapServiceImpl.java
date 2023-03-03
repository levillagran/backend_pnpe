package ec.org.inspi.pnpe.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.org.inspi.pnpe.models.TasaProvincia;
import ec.org.inspi.pnpe.repositories.TasaProvinciaRepository;
import ec.org.inspi.pnpe.response.TasaProvinciaResponse;
import ec.org.inspi.pnpe.services.MapService;

@Service("mapService")
public class MapServiceImpl implements MapService {

	@Autowired
	private TasaProvinciaRepository tasaRepo;

	@Override
	public List<TasaProvinciaResponse> tasasAll() {
		List<TasaProvincia> tasas = (List<TasaProvincia>) tasaRepo.findAll();
		List<TasaProvinciaResponse> tasRes = new ArrayList<>();
		for (TasaProvincia tasa : tasas) {
			TasaProvinciaResponse tas = new TasaProvinciaResponse();
			tas.setProvince(tasa.getProvinceId());
			if (tasa.getTasa() != null) {
				tas.setValue(tasa.getTasa().intValue());
				tasRes.add(tas);
			}
		}
		return tasRes;
	}

}
