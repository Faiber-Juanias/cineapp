package net.fjuanias.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IPeliculaService;
import net.fjuanias.app.model.Pelicula;

@Service
public class PeliculaService implements IPeliculaService {
	
	public List<Pelicula> lista = null;
	
	public PeliculaService() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.lista = new LinkedList<>();
			
			Pelicula p1 = new Pelicula();
			p1.setId(1);
			p1.setTitulo("En Este Rincón del Mundo");
			p1.setDuracion(120);
			p1.setClasificacion("B");
			p1.setGenero("Aventura");
			p1.setImagen("estreno1.png");
			p1.setFechaEstreno(formatter.parse("02-05-2017"));
			
			Pelicula p2 = new Pelicula();
			p2.setId(2);
			p2.setTitulo("Logan");
			p2.setDuracion(132);
			p2.setClasificacion("A");
			p2.setGenero("Acción");
			p2.setFechaEstreno(formatter.parse("20-05-2017"));
			p2.setImagen("estreno2.png");
			p2.setEstatus("Inactiva");
			
			this.lista.add(p1);
			this.lista.add(p2);
		
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return this.lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p : lista) {
			if (p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void guardar(Pelicula pelicula) {
		this.lista.add(pelicula);
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
		return generos;
	}

}
