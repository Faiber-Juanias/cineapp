package net.fjuanias.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.fjuanias.app.iservice.IBannerService;
import net.fjuanias.app.iservice.IHorarioService;
import net.fjuanias.app.iservice.INoticiaService;
import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculaService servicePelicula;
	@Autowired
	private IBannerService serviceBanner;
	@Autowired
	private IHorarioService serviceHorario;
	@Autowired
	private INoticiaService serviceNoticia;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		try {
			model.addAttribute("peliculas", this.serviceHorario.buscarPeliculasByHorario_Fecha(this.dateFormat.parse(Utileria.getNextDays(1).get(0))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		return "home";
	}
	
	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(@PathVariable("id") int id, @PathVariable("fecha") Date fecha, Model model) {
		model.addAttribute("pelicula", this.servicePelicula.buscarPorId(id));
		model.addAttribute("fechaBusqueda", this.dateFormat.format(fecha));
		model.addAttribute("horarios", this.serviceHorario.buscarPorPelicula_IdAndFechaOrderByHora(id, fecha));				 
		return "detalle";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {
		model.addAttribute("peliculas", this.serviceHorario.buscarPeliculasByHorario_Fecha(fecha));
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		return "home";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("banners", this.serviceBanner.buscarTodas());
		model.addAttribute("fechas", Utileria.getNextDays(6));
		model.addAttribute("noticias", this.serviceNoticia.buscarNoticiasOrderByFechaDesc());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
