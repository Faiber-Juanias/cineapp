package net.fjuanias.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.INoticiaService;
import net.fjuanias.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	
	@Autowired
	private INoticiaService serviceNoticia;
	
	@GetMapping("/index")
	public String index(Model model, Pageable page) {
		model.addAttribute("noticias", this.serviceNoticia.buscarTodasPaginado(page));
		return "noticias/listNoticias";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute("noticia") Noticia noticia) {
		return "noticias/formNoticia";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("noticia") Noticia noticia, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "noticias/formNoticia";
		}
		if (noticia.getId() != 0)
			attributes.addFlashAttribute("msg", "Registro Actualizado");
		else
			attributes.addFlashAttribute("msg", "Registro Guardado");
		this.serviceNoticia.guardar(noticia);
		return "redirect:/noticias/index";
	}
	
	@GetMapping("/update/{id}")
	public String actualizar(@PathVariable("id") String idNoticia, Model model) {
		model.addAttribute("noticia", this.serviceNoticia.buscarPorId(Integer.parseInt(idNoticia)));
		return "noticias/formNoticia";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") String idNoticia, RedirectAttributes attributes) {
		this.serviceNoticia.eliminarPorId(Integer.parseInt(idNoticia));
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/noticias/index";
	}
	
}
