package net.fjuanias.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IUsuarioService;
import net.fjuanias.app.model.Usuario;
import net.fjuanias.app.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository repoUsuario;

	@Override
	public void guardar(Usuario usuario) {
		this.repoUsuario.save(usuario);
	}

	@Override
	public Page<Usuario> obtenerTodos(Pageable page) {
		return this.repoUsuario.findAll(page);
	}

	@Override
	public Usuario obtenerPorCuenta(String cuenta) {
		Optional<Usuario> usu = this.repoUsuario.findByCuenta(cuenta);
		if (usu.isPresent()) {
			return usu.get();
		}
		return null;
	}

	@Override
	public boolean existePorCuenta(String cuenta) {
		return this.obtenerPorCuenta(cuenta) != null ? true : false;
	}

	@Override
	public void eliminar(String cuenta) {
		this.repoUsuario.deleteByCuenta(cuenta);
	}

}
