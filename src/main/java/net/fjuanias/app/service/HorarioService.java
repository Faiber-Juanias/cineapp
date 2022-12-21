package net.fjuanias.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
