package net.fjuanias.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.fjuanias.app.iservice.IBannerService;
import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Banner;
import net.fjuanias.app.model.Pelicula;
import net.fjuanias.app.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculaService servicePelicula;
	@Autowired
	private IBannerService serviceBanner;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(3);
		List<Pelicula> peliculas = servicePelicula.buscarTodas();
		List<Banner> banners = serviceBanner.buscarTodas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banners);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("fechas", listaFechas);
		
		return "home";
	}
	
	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(@PathVariable("id") int id, @PathVariable("fecha") Date fecha, Model model) {
		model.addAttribute("pelicula", servicePelicula.buscarPorId(id));
		return "detalle";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {
		List<String> listaFechas = Utileria.getNextDays(3);
		List<Pelicula> peliculas = servicePelicula.buscarTodas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("fechas", listaFechas);
		return "home";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
