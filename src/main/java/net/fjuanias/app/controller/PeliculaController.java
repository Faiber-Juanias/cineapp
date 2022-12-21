package net.fjuanias.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Pelicula;
import net.fjuanias.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private IPeliculaService servicePelicula;

	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "peliculas/formPelicula";
		}
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			if (nombreImagen != null) {
				pelicula.setImagen(nombreImagen);
			}
		}
		System.out.println(pelicula);
		if (pelicula.getId() != 0)
			attributes.addFlashAttribute("msg", "Registro Actualizado");
		else
			attributes.addFlashAttribute("msg", "Registro Guardado");
		this.servicePelicula.guardar(pelicula);
		return "redirect:/peliculas/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model, Pageable page) {
		Page<Pelicula> lista = servicePelicula.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/update/{id}")
	public String editar(@PathVariable("id") String id, Model model) {
		model.addAttribute("pelicula", this.servicePelicula.buscarPorId(Integer.parseInt(id)));
		return "peliculas/formPelicula";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") String id, Model model, RedirectAttributes attributes) {
		this.servicePelicula.eliminar(Integer.parseInt(id));
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/peliculas/index";
	}
	
	@ModelAttribute 
	public void setGenericos(Model model) {
		model.addAttribute("generos", this.servicePelicula.buscarGeneros());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdt, false));
	}
	
}
