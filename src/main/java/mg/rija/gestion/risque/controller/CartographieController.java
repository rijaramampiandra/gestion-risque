package mg.rija.gestion.risque.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mg.rija.gestion.risque.ViewName;
import mg.rija.gestion.risque.dto.CartographieDto;
import mg.rija.gestion.risque.entity.Risque;
import mg.rija.gestion.risque.service.RisqueService;

@Controller
@RequestMapping(value = "/cartographie")
public class CartographieController {

	@Autowired
	private RisqueService risqueService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest() {
		final ModelAndView map = new ModelAndView();
		map.setViewName("/cartographie");

		final List<Risque> listeRisque = risqueService.findAllByOrderByDescriptionRisqueAsc();

		final List<CartographieDto> listCartographie = new ArrayList<>();

		final List<String[]> classes = new ArrayList<>();
		classes.add(new String[] { "jaune", "jaune", "red", "red", "red" });
		classes.add(new String[] { "jaune", "jaune", "jaune", "red", "red" });
		classes.add(new String[] { "green", "jaune", "jaune", "jaune", "red" });
		classes.add(new String[] { "green", "green", "jaune", "jaune", "jaune" });
		classes.add(new String[] { "green", "green", "green", "jaune", "jaune" });

		String[][] array = new String[5][5];
		for (int ligne = 4; ligne >= 0; ligne--) {
			for (int colonne = 0; colonne < 5; colonne++) {
				array[ligne][colonne] = StringUtils.EMPTY;
			}
		}

		for (Risque risk : listeRisque) {
			String oldValue = array[(risk.getProbabiliter() - 1)][(risk.getImpact() - 1)];
			if (StringUtils.EMPTY.equals(oldValue)) {
				array[(risk.getProbabiliter() - 1)][(risk.getImpact() - 1)] = risk.getDescriptionRisque();
			} else {
				array[(risk.getProbabiliter() - 1)][(risk.getImpact() - 1)] = oldValue + ","
						+ risk.getDescriptionRisque();
			}
		}

		int index = 0;
		for (int ligne = 4; ligne >= 0; ligne--) {
			final CartographieDto carto = new CartographieDto();
			carto.setId((ligne + 1));
			final String[] classArray = classes.get(index);
			carto.setClasse1(classArray[0]);
			carto.setClasse2(classArray[1]);
			carto.setClasse3(classArray[2]);
			carto.setClasse4(classArray[3]);
			carto.setClasse5(classArray[4]);

			carto.setFirstValue(array[ligne][0]);
			carto.setSecondValue(array[ligne][1]);
			carto.setThirdValue(array[ligne][2]);
			carto.setFourthValue(array[ligne][3]);
			carto.setFifthValue(array[ligne][4]);
			listCartographie.add(carto);
			index++;
		}

		map.addObject("listCarto", listCartographie);

		// Utiliser sur le header
		map.addObject(ViewName.PAGE, "/cartographie");

		return map;
	}

}