package net.fjuanias.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private IPeliculaService servicePelicula;

	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes) {
		servicePelicula.guardar(pelicula);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/peliculas/create";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdt, false));
	}
	
}
