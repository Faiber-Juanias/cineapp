package net.fjuanias.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fjuanias.app.iservice.IPerfilService;
import net.fjuanias.app.iservice.IUsuarioService;
import net.fjuanias.app.model.Perfil;
import net.fjuanias.app.model.Usuario;
import net.fjuanias.app.util.Utileria;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IPerfilService servicePerfil;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/bcrypt/{pwd}")
	@ResponseBody
	public String pruebaBcrypt(@PathVariable("pwd") String pwd) {
		String encriptado = encoder.encode(pwd);
		return encriptado;
	}
	
	@GetMapping("/index")
	public String index(Model model, Pageable page) {
		model.addAttribute("usuarios", this.serviceUsuario.obtenerTodos(page));
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute("usuario") Usuario usuario, Model model) {
		model.addAttribute("flag", "create");
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/update/{cuenta}")
	public String actualizar(@PathVariable("cuenta") String cuenta, Model model) {
		model.addAttribute("usuario", this.serviceUsuario.obtenerPorCuenta(cuenta));
		model.addAttribute("perfil", this.servicePerfil.buscarPorCuenta(cuenta));
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute("usuario") Usuario usuario, BindingResult result, @RequestParam("perfil") String perfil, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "usuarios/formUsuario";
		}
		if (this.serviceUsuario.existePorCuenta(usuario.getCuenta())) {
			attributes.addFlashAttribute("msg", "Registro Actualizado");
		} else {
			usuario.setPwd(this.encoder.encode(usuario.getPwd()));
			attributes.addFlashAttribute("msg", "Registro Guardado");
		}
		System.out.println(usuario);
		this.serviceUsuario.guardar(usuario);
		
		Perfil pl = new Perfil();
		pl.setCuenta(usuario.getCuenta());
		pl.setPerfil(perfil);
		System.out.println(pl);
		this.servicePerfil.guardar(pl);
		
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/delete/{cuenta}")
	public String eliminar(@PathVariable("cuenta") String cuenta, RedirectAttributes attributes) {
		this.serviceUsuario.eliminar(cuenta);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/usuarios/index";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("perfiles", Utileria.getPerfiles());		
	}

}
