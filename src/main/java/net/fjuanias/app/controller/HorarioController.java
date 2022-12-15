package net.fjuanias.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.IHorarioService;
import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Horario;

@Controller
@RequestMapping("/horarios")
public class HorarioController {
	
	@Autowired
	private IHorarioService serviceHorario;
	
	@Autowired
	private IPeliculaService servicePelicula;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("horarios", this.serviceHorario.buscarTodos());
		return "horarios/listHorarios";
	}
	
	@GetMapping("/create")
	public String mostrarFormulario(@ModelAttribute Horario horario, Model model) {
		model.addAttribute("peliculas", this.servicePelicula.buscarTodas());
		return "horarios/formHorario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("horario") Horario horario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "horarios/formHorario";
		}
		this.serviceHorario.guardar(horario);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/horarios/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdt, false));
	}
	
}
