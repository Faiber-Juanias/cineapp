package net.fjuanias.app.iservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fjuanias.app.model.Pelicula;

public interface IPeliculaService {

	Page<Pelicula> buscarTodas(Pageable page);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	void guardar(Pelicula pelicula);
	List<String> buscarGeneros();
	void eliminar(int idPelicula);
	
}
