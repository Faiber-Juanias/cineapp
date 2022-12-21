package net.fjuanias.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.IBannerService;
import net.fjuanias.app.model.Banner;
import net.fjuanias.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannerController {
	
	@Autowired
	private IBannerService serviceBanner;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("banners", serviceBanner.buscarTodas());
		return "banners/listBanners";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute("banner") Banner banner) {
		return "banners/formBanner";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("banner") Banner banner, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			if (nombreImagen != null) {
				banner.setArchivo(nombreImagen);
			}
		}
		if (banner.getId() != 0)
			attributes.addFlashAttribute("msg", "Registro Actualizado");
		else
			attributes.addFlashAttribute("msg", "Registro Guardado");			
		serviceBanner.guardar(banner);
		return "redirect:/banners/index";
	}
	
	@GetMapping("/update/{id}")
	public String editar(@PathVariable("id") String idBanner, Model model) {
		model.addAttribute("banner", this.serviceBanner.buscarPorId(Integer.parseInt(idBanner)));
		return "banners/formBanner";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") String idBanner, Model model, RedirectAttributes attributes) {
		this.serviceBanner.eliminarPorId(Integer.parseInt(idBanner));
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/banners/index";
	}
	
}