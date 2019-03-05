package mg.rija.gestion.risque.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mg.rija.gestion.risque.entity.Risque;

/**
 * Acces to DB to manage risque.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface RisqueRepository extends CrudRepository<Risque, Integer> {

	int countByDescriptionRisque(String descriptionRisque);
	
	List<Risque> findAllByOrderByDescriptionRisqueAsc();
}
