package net.fjuanias.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
	public String mostrarIndex(Model model, Pageable page) {
		model.addAttribute("horarios", this.serviceHorario.buscarTodosPaginados(page));
		return "horarios/listHorarios";
	}
	
	@GetMapping("/create")
	public String mostrarFormulario(@ModelAttribute Horario horario) {
		return "horarios/formHorario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("horario") Horario horario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "horarios/formHorario";
		}
		if (horario.getId() != 0) 
			attributes.addFlashAttribute("msg", "Registro Actualizado");
		else
			attributes.addFlashAttribute("msg", "Registro Guardado");
		this.serviceHorario.guardar(horario);
		return "redirect:/horarios/index";
	}
	
	@GetMapping("/update/{id}")
	public String actualizar(@PathVariable("id") String idHorario, Model model) {
		model.addAttribute("horario", this.serviceHorario.buscarPorId(Integer.parseInt(idHorario)));
		return "horarios/formHorario";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") String idHorario, RedirectAttributes attributes) {
		this.serviceHorario.eliminarPorId(Integer.parseInt(idHorario));
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/horarios/index";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("peliculas", this.servicePelicula.buscarTodas());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdt, false));
	}
	
}
