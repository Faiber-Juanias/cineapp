package net.fjuanias.app.iservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fjuanias.app.model.Usuario;

public interface IUsuarioService {

	void guardar(Usuario usuario);
	Page<Usuario> obtenerTodos(Pageable page);
	Usuario obtenerPorCuenta(String cuenta);
	boolean existePorCuenta(String cuenta);
	void eliminar(String cuenta);
	
}
