package net.fjuanias.app.iservice;

import java.util.List;

import net.fjuanias.app.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	void guardar(Pelicula pelicula);
	List<String> buscarGeneros();
	
}
