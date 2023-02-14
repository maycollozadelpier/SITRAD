package detel.copere.ejercito.mil.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import detel.copere.ejercito.mil.pe.models.entity.Nucleo;
import detel.copere.ejercito.mil.pe.models.service.INucleoService;
import detel.copere.ejercito.mil.pe.util.paginator.PageRender;

@Controller
@RequestMapping("/nucleos")
public class NucleoController {

	@Autowired
	private INucleoService nucleoService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Nucleo> nucleos = nucleoService.findAll(pageRequest);
		PageRender<Nucleo> pageRender = new PageRender<Nucleo>("/listar", nucleos);
		model.addAttribute("titulopage", "SISMEP | NUCLEOS");
		model.addAttribute("nucleos", nucleos);
		model.addAttribute("page", pageRender);
		return "nucleo/listar";
		
	}
}
