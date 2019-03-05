package mg.rija.gestion.risque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.rija.gestion.risque.entity.Risque;
import mg.rija.gestion.risque.repository.RisqueRepository;
import mg.rija.gestion.risque.service.RisqueService;

@Service
public class RisqueServiceImpl implements RisqueService {

	@Autowired
	private RisqueRepository risqueRepository;

	@Override
	public Risque save(Risque entity) {
		return risqueRepository.save(entity);
	}

	@Override
	public List<Risque> findAll() {
		return (List<Risque>) risqueRepository.findAll();
	}

	@Override
	public Risque findById(int id) {
		return risqueRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		if (risqueRepository.exists(id)) {
			risqueRepository.delete(id);
		}
	}

	@Override
	public int countByDescriptionRisque(String descriptionRisque) {
		return risqueRepository.countByDescriptionRisque(descriptionRisque);
	}

	@Override
	public List<Risque> findAllByOrderByDescriptionRisqueAsc() {
		return risqueRepository.findAllByOrderByDescriptionRisqueAsc();
	}

}
