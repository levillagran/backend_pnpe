package ec.org.inspi.pnpe.services;

import java.util.List;

import ec.org.inspi.pnpe.response.defunciones.Root;

public interface TableService {
	public List<Root> findAll(Integer id);
}
