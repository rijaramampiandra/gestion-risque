package mg.rija.gestion.risque;

/**
 * Constant utiliser par l'application.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface ViewName {

	/**
	 * Page risque.
	 */
	String PAGE_LISTE_RISQUE = "/risqueListe";

	/**
	 * page edit risque.
	 */
	String PAGE_ADD_OR_EDIT_DEVELOPPEUR = "/risqueAddOrEdit";

	/**
	 * Appel fichier errorPage.html.
	 */
	String PAGE_SUCCESS_PAGE = "/inscriptionSuccess";

	/**
	 * Page.
	 */
	String PAGE = "page";

	/**
	 * Appel fichier errorPage.html.
	 */
	String VIEW_ERROR_PAGE = "error/errorPage";

	/**
	 * Afficher la vue ajout.
	 */
	String SHOW_ADD_VIEW = "/ajouter";

	/**
	 * Ajout action dans le DB.
	 */
	String ADD_TO_DB = "/addAction";

	/**
	 * Sauvegarder les données dans la base de données.
	 */
	String SAVE_TO_DB = "/saveedit";
}
