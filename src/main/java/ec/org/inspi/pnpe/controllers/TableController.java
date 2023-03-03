package ec.org.inspi.pnpe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.org.inspi.pnpe.response.defunciones.Root;
import ec.org.inspi.pnpe.services.TableService;

@CrossOrigin(origins = "http://192.168.9.160:8085", maxAge = 3600)
@RestController
@RequestMapping("/api/table")
public class TableController {
	@Autowired
	private TableService tableSer;
	
	@GetMapping(value = "/priorizacion/{id}")
	public List<Root> listUnidadesAll(@PathVariable String id) {
		return tableSer.findAll(Integer.parseInt(id));
	}
}
