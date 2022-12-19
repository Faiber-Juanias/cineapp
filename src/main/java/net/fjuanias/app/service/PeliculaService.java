package net.fjuanias.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Pelicula;
import net.fjuanias.app.repository.IPeliculaRepository;

@Service
public class PeliculaService implements IPeliculaService {
	
	@Autowired
	private IPeliculaRepository repoPelicula;

	@Override
	public List<Pelicula> buscarTodas() {
		return this.repoPelicula.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> p = this.repoPelicula.findById(idPelicula);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}

	@Override
	public void guardar(Pelicula pelicula) {
		this.repoPelicula.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		generos.add("Thriller");
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		this.repoPelicula.deleteById(idPelicula);
	}

}
