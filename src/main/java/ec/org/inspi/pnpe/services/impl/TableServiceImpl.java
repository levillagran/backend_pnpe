package ec.org.inspi.pnpe.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.org.inspi.pnpe.models.CieLv1;
import ec.org.inspi.pnpe.models.CieLv2;
import ec.org.inspi.pnpe.models.CieLv3;
import ec.org.inspi.pnpe.models.CieLv4;
import ec.org.inspi.pnpe.models.EnfermedadTasaLv1;
import ec.org.inspi.pnpe.models.EnfermedadTasaLv2;
import ec.org.inspi.pnpe.models.EnfermedadTasaLv3;
import ec.org.inspi.pnpe.models.EnfermedadTasaLv4;
import ec.org.inspi.pnpe.models.TasaProvincia;
import ec.org.inspi.pnpe.repositories.CieLv1Repository;
import ec.org.inspi.pnpe.repositories.CieLv2Repository;
import ec.org.inspi.pnpe.repositories.CieLv3Repository;
import ec.org.inspi.pnpe.repositories.CieLv4Repository;
import ec.org.inspi.pnpe.repositories.EnfermedadLv1Repository;
import ec.org.inspi.pnpe.repositories.EnfermedadLv2Repository;
import ec.org.inspi.pnpe.repositories.EnfermedadLv3Repository;
import ec.org.inspi.pnpe.repositories.EnfermedadLv4Repository;
import ec.org.inspi.pnpe.repositories.TasaProvinciaRepository;
import ec.org.inspi.pnpe.response.TasaProvinciaResponse;
import ec.org.inspi.pnpe.response.defunciones.Datos;
import ec.org.inspi.pnpe.response.defunciones.Hijo;
import ec.org.inspi.pnpe.response.defunciones.Padre;
import ec.org.inspi.pnpe.response.defunciones.Root;
import ec.org.inspi.pnpe.services.MapService;
import ec.org.inspi.pnpe.services.TableService;

@Service("tableService")
public class TableServiceImpl implements TableService {

	@Autowired
	private EnfermedadLv1Repository en1repo;
	@Autowired
	private EnfermedadLv2Repository en2repo;
	@Autowired
	private EnfermedadLv3Repository en3repo;
	@Autowired
	private EnfermedadLv4Repository en4repo;
	@Autowired
	private CieLv1Repository cie1Repo;
	@Autowired
	private CieLv2Repository cie2Repo;
	@Autowired
	private CieLv3Repository cie3Repo;
	@Autowired
	private CieLv4Repository cie4Repo;

	@Override
	public List<Root> findAll(Integer id) {
		
		List<CieLv1> cie1s = (List<CieLv1>) cie1Repo.findAll();
		List<CieLv2> cie2s = (List<CieLv2>) cie2Repo.findAll();
		List<CieLv3> cie3s = (List<CieLv3>) cie3Repo.findAll();
		List<CieLv4> cie4s = (List<CieLv4>) cie4Repo.findAll();
		
		List<EnfermedadTasaLv1> enlv1s = en1repo.findAllByProvinceIdOrderByTasaDesc(id);
		for (EnfermedadTasaLv1 enlv1 : enlv1s) {
			for (CieLv1 cie1 : cie1s) {
				if (cie1.getCode().equals(enlv1.getCie())) {
					System.out.println(enlv1);
					List<EnfermedadTasaLv2> enlv2s = en2repo.findTop10ByProvinceIdAndCieOrderByTasaDesc(id, enlv1.getCie());
					for (EnfermedadTasaLv2 enlv2 : enlv2s) {
						for (CieLv2 cie2 : cie2s) {
							if (cie2.getCode().equals(enlv2.getCie())) {
								System.out.println(enlv2);
								List<EnfermedadTasaLv3> enlv3s = en3repo.findTop10ByProvinceIdAndCie10OrderByTasaDesc(id, enlv2.getCie());
								for (EnfermedadTasaLv3 enlv3 : enlv3s) {
									for (CieLv3 cie3 : cie3s) {
										if (cie3.getCode().equals(enlv3.getCie10())) {
											System.out.println(enlv3);
											List<EnfermedadTasaLv4> enlv4s = en4repo.findTop10ByProvinceIdAndCieOrderByTasaDesc(id, enlv3.getCie10());
											for (EnfermedadTasaLv4 enlv4 : enlv4s) {
												for (CieLv4 cie4 : cie4s) {
													if (cie4.getCode().equals(enlv4.getCie())) {
														System.out.println(enlv4);
													}
												}
											}
											
										}
									}
								}
								
							}
						}
					}
				}
			}
			
		}
		
		
		
		List<Root> roots = new ArrayList<>();
		
		/*List<EnfermedadTasaLv1> enlv1s = en1repo.findByProvinceIdByOrderByTasaDes(id);
		
		List<EnfermedadTasaLv3> enlv3s = new ArrayList<>();
		List<EnfermedadTasaLv4> enlv4s = new ArrayList<>();
		
		for (EnfermedadTasaLv1 enlv1 : enlv1s) {
			List<EnfermedadTasaLv2> enlv2s = en2repo.findTop10ByProvinceIdByCieByOrderByTasaDes(id, enlv1.getCie());
		}
		
		List<EnfermedadTasaLv1> enlv1 = en1repo.findTop10ByProvinceIdByOrderByTasaAsc(id);
		Datos data;
		Hijo childre;
		List<Hijo> childres;
		List<Hijo> childress;
		Padre children;
		List<Padre> childrens;
		List<Padre> childrenss;
		Root root;
		List<Root> roots;

		childres = new ArrayList<>();
		for (Indicador indicador : indicadores) {
			//System.out.println(indicador);
			data = new Datos();
			data.setIndicadorId(indicador.getId());
			data.setEjeId(indicador.getEjeId());
			data.setCode(indicador.getCode());
			data.setName(indicador.getName());
			data.setDescription(indicador.getDescription());
			data.setType(indicador.getType());
			data.setCuantitativo(indicador.isQuantitative());
			for (ValorIndicador valorIndicador : resultados) {
				if (indicador.getId().equals(valorIndicador.getEjeId())
						&& valorIndicador.getCantonId().equals(cantonId)) {
					data.setValueIndicadorId(valorIndicador.getId());
					if (valorIndicador != null && valorIndicador.getEjeId() > 0) {
						data.setValue(String.valueOf(valorIndicador.getValor()));
					} else {
						data.setValue(null);
					}
					if (valorIndicador.getAnio() != null && valorIndicador.getMes() != null
							&& valorIndicador.getDia() != null) {
						data.setDate(
								String.valueOf(valorIndicador.getMes()) + "-" + String.valueOf(valorIndicador.getDia())
										+ "-" + String.valueOf(valorIndicador.getAnio()));
					}
					if (valorIndicador.getFecha() != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(valorIndicador.getFecha());
						data.setDateRegister(String.valueOf(cal.get(Calendar.MONTH) + 1) + "-"
								+ String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "-"
								+ String.valueOf(cal.get(Calendar.YEAR)));
					}
					if (valorIndicador.getObservacion() != null) {
						data.setObs(valorIndicador.getObservacion());
					} else {
						data.setObs("");
					}
					if (valorIndicador.getFuente() != null) {
						data.setFont(valorIndicador.getFuente());
					}
					if (valorIndicador.getArchivo() != null) {
						data.setArchivoId(valorIndicador.getArchivo());
						Documento doc = docRepository.findById(valorIndicador.getArchivo()).get();
						// System.out.println(doc.getDocumento());
						data.setArchivo(doc.getDocumento());
						data.setDocUno(doc.getDocUno());
					} else {
						data.setArchivo(null);
						data.setDocUno("");
					}

				}
			}
			data.setOption1(indicador.getInicial());
			data.setOption2(indicador.getSatisfactorio());
			data.setOption3(indicador.getOptimo());
			if (indicador.isQuantitative()) {
				data.setLimite1(Integer.valueOf(indicador.getLimite1()));
				data.setLimite2(Integer.valueOf(indicador.getLimite2()));
				data.setLimite3(Double.valueOf(indicador.getLimite3()));
				data.setLimite4(Integer.valueOf(indicador.getLimite4()));
			}
			data.setObligatory(indicador.isObliged());
			data.setDesnutrition(indicador.isDesnutrition());
			data.setMaternity(indicador.isMaternity());
			data.setViolence(indicador.isViolence());
			childre = new Hijo();
			childre.setKey(String.valueOf(indicador.getId()));
			childre.setData(data);
			childres.add(childre);
		}

		childrens = new ArrayList<>();
		for (Eje determinante : determinantes) {
			children = new Padre();
			children.setKey(String.valueOf(determinante.getId()));
			data = new Datos();
			data.setName(determinante.getName());
			data.setEjeId(determinante.getParent());
			children.setData(data);
			childress = new ArrayList<>();
			for (Hijo hijo : childres) {
				if (determinante.getId().equals(hijo.getData().getEjeId())) {
					childress.add(hijo);
				}
			}
			children.setChildren(childress);
			childrens.add(children);
		}

		roots = new ArrayList<>();
		for (Eje eje : ejes) {
			root = new Root();
			root.setKey(String.valueOf(eje.getId() - 1));
			data = new Datos();
			data.setName(eje.getName());
			data.setEjeId(eje.getId());
			root.setData(data);
			childrenss = new ArrayList<>();
			for (Padre childen : childrens) {
				if (eje.getId().equals(childen.getData().getEjeId())) {
					childrenss.add(childen);
				}
			}
			root.setChildren(childrenss);
			roots.add(root);
		}
		int i = 0;
		for (Root roo : roots) {
			List<Padre> padres = roo.getChildren();
			int j = 0;
			for (Padre padre : padres) {
				padre.setKey(roo.getKey() + "-" + String.valueOf(j));
				List<Hijo> hijos = padre.getChildren();
				int k = 0;
				for (Hijo hijo : hijos) {
					hijo.setKey(roo.getKey() + "-" + String.valueOf(j) + "-" + String.valueOf(k));
					k = k + 1;
				}
				j = j + 1;
			}
			i = i + 1;
		}*/
		return roots;
	}

}
