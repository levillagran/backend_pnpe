package ec.org.inspi.pnpe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.org.inspi.pnpe.response.TasaProvinciaResponse;
import ec.org.inspi.pnpe.services.MapService;

@CrossOrigin(origins = "http://192.168.9.160:8085", maxAge = 3600)
@RestController
@RequestMapping("/api/map")
public class MapController {
	@Autowired
	private MapService mapSer;
	
	@GetMapping(value = "/tasas")
	public List<TasaProvinciaResponse> listUnidadesAll() {
		return mapSer.tasasAll();
	}
}
