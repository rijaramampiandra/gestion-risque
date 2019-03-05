package mg.rija.gestion.risque.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mg.rija.gestion.risque.ViewName;
import mg.rija.gestion.risque.service.RisqueService;

@Controller
@RequestMapping(value = ViewName.PAGE_LISTE_RISQUE)
public class ListRisqueController {

	private static final Logger logger = LoggerFactory.getLogger(ListRisqueController.class);

	@Autowired
	private RisqueService risqueService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest() {
		logger.info("Appel liste des clients!");

		final ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_LISTE_RISQUE);

		map.addObject("listRisque", risqueService.findAll());

		// Utiliser sur le header
		map.addObject(ViewName.PAGE, ViewName.PAGE_LISTE_RISQUE);

		return map;
	}

}