package net.fjuanias.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.fjuanias.app.iservice.INoticiaService;
import net.fjuanias.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	
	@Autowired
	private INoticiaService serviceNoticia;

	@GetMapping("/create")
	public String crear() {
		return "noticias/formNoticia";
	}
	
	@PostMapping("/save")
	public String guardar(Noticia noticia) {
		
		this.serviceNoticia.guardar(noticia);
		
		System.out.println(noticia);
		return "noticias/formNoticia";
	}
	
}
