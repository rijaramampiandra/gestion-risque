package mg.rija.gestion.risque.controller;

import java.util.Calendar;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.rija.gestion.risque.ViewName;
import mg.rija.gestion.risque.entity.Risque;
import mg.rija.gestion.risque.service.RisqueService;

/**
 * Cette controlleur permet de gerer la mise a jour des risque.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR)
public class AddOrEditRisqueController {

	@Autowired
	private RisqueService risqueService;

	@RequestMapping(value = ViewName.SHOW_ADD_VIEW, method = RequestMethod.GET)
	public ModelAndView ajouterRisque() {

		ModelAndView model = new ModelAndView();
		model.setViewName(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		Risque dev = new Risque();
		// dev.setType(new Type("Java", 1));
		dev.setCreateDate(Calendar.getInstance().getTime());

		model.addObject("risque", dev);
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("add", true);

		return model;
	}

	@RequestMapping(value = ViewName.ADD_TO_DB, method = RequestMethod.POST)
	public ModelAndView ajouterRisqueToDb(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("risque") Risque risque, BindingResult bindingResult, ModelMap model) {

		if (bindingResult != null && bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();

			final String objectName = fieldError.getField();
			final String cap = objectName.substring(0, 1).toUpperCase() + objectName.substring(1);

			return generateViewError(risque, "error" + cap, "Il y a une erreur sur ce champ.");
		}

		if (StringUtils.isBlank(risque.getDescriptionRisque())) {
			return generateViewError(risque, "errorRisqueDescription", "Description risque obligatoire!");
		}

		risque.setDescriptionRisque(risque.getDescriptionRisque().trim());

		if (risque.getProbabiliter() == null) {
			return generateViewError(risque, "errorProbabiliter", "Probabilité obligatoire!");
		}

		if (risque.getProbabiliter() < 0 || risque.getProbabiliter() > 5) {
			return generateViewError(risque, "errorProbabiliter",
					"Probabilité doit être comprise entre 1 et 5 (tous les deux inclus)!");
		}

		if (risque.getImpact() == null) {
			return generateViewError(risque, "errorImpact", "Impacte obligatoire!");
		}

		if (risque.getImpact() < 0 || risque.getImpact() > 5) {
			return generateViewError(risque, "errorImpact",
					"Impacte doit être comprise entre 1 et 5 (tous les deux inclus)!");
		}

		risque.setDescriptionRisque(risque.getDescriptionRisque().trim().toUpperCase());
		int counts = risqueService.countByDescriptionRisque(risque.getDescriptionRisque());
		if (counts > 0) {
			return generateViewError(risque, "errorDescriptionRisque", "Risque déjà éxistant!");
		}
		risque.setCreateDate(Calendar.getInstance().getTime());

		int criticiter = risque.getProbabiliter() * risque.getImpact();
		risque.setCriticiter(criticiter);

		risqueService.save(risque);

		final ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_SUCCESS_PAGE);
		map.addObject("add", true);
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editRisque(@RequestParam(value = "id", required = false) String id) {
		if (StringUtils.isBlank(id)) {
			ModelAndView model = new ModelAndView(ViewName.VIEW_ERROR_PAGE);
			model.addObject("errorMessage", "Risque obligatoire.");
			model.addObject(ViewName.PAGE, ViewName.VIEW_ERROR_PAGE);
			model.addObject("edit", true);

			return model;
		}

		ModelAndView model = new ModelAndView(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("msg", id);
		int idInt = Integer.valueOf(id);
		Optional<Risque> risque = risqueService.findById(idInt);
		if (risque.isPresent()) {
			model.addObject("risque", risque.get());
		} else {
			model.addObject("risque", null);
		}
		// Utiliser sur le header
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("edit", true);

		return model;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeRisque(@RequestParam(value = "id", required = false) String id) {

		int idInt = Integer.valueOf(id);

		risqueService.delete(idInt);

		final ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_SUCCESS_PAGE);
		map.addObject("remove", true);
		return map;
	}

	@RequestMapping(value = ViewName.SAVE_TO_DB, method = RequestMethod.POST)
	public String saveRisqueToDB(@ModelAttribute("risque") Risque risque, ModelMap model) {
		risque.setDescriptionRisque(risque.getDescriptionRisque().trim().toUpperCase());
		risque.setCreateDate(Calendar.getInstance().getTime());

		int criticiter = risque.getProbabiliter() * risque.getImpact();
		risque.setCriticiter(criticiter);

		risqueService.save(risque);

		return "redirect:" + ViewName.PAGE_LISTE_RISQUE;
	}

	private ModelAndView generateViewError(Risque risque, String errorName, String errorMessage) {

		ModelAndView modelToReturn = new ModelAndView();
		modelToReturn.setViewName(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);

		modelToReturn.addObject("risque", risque);
		modelToReturn.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		modelToReturn.addObject(errorName, true);
		modelToReturn.addObject("error", errorMessage);
		modelToReturn.addObject("add", true);
		return modelToReturn;
	}
}