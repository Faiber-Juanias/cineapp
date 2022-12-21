package net.fjuanias.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IHorarioService;
import net.fjuanias.app.model.Horario;
import net.fjuanias.app.model.Pelicula;
import net.fjuanias.app.repository.IHorarioRepository;

@Service
public class HorarioService implements IHorarioService {
	
	@Autowired
	private IHorarioRepository repoHorario;

	@Override
	public void guardar(Horario horario) {
		this.repoHorario.save(horario);
	}

	@Override
	public List<Horario> buscarTodos() {
		return this.repoHorario.findAll();
	}

	@Override
	public List<Horario> buscarPorPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha) {
		return this.repoHorario.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}
	
	@Override
	public List<Pelicula> buscarPeliculasByHorario_Fecha(Date fecha) {
		return this.repoHorario.findPeliculasByHorario_Fecha(fecha);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> h = this.repoHorario.findById(idHorario);
		if (h.isPresent()) {
			return h.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int idHorario) {
		this.repoHorario.deleteById(idHorario);
	}

	@Override
	public Page<Horario> buscarTodosPaginados(Pageable page) {
		return this.repoHorario.findAll(page);
	}

}
