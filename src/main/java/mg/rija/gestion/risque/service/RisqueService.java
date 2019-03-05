package mg.rija.gestion.risque.service;

import java.util.List;

import mg.rija.gestion.risque.entity.Risque;

/**
 * Service to manage risque.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface RisqueService {

	/**
	 * Add risque to DB.
	 * 
	 * @param p
	 *            the risque.
	 * @return 
	 */
	Risque save(Risque entity);

	/**
	 * Liste des risques.
	 * 
	 * @return the list.
	 */
	List<Risque> findAll();

	/**
	 * Get risque by id.
	 * 
	 * @param id
	 *            the id.
	 * @return the risque.
	 */
	Risque findById(int id);

	/**
	 * Removo risque.
	 * 
	 * @param id
	 *            the id.
	 */
	void delete(int id);

	int countByDescriptionRisque(String descriptionRisque);

	List<Risque> findAllByOrderByDescriptionRisqueAsc();

}
