package net.fjuanias.app.iservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fjuanias.app.model.Horario;
import net.fjuanias.app.model.Pelicula;

public interface IHorarioService {

	List<Horario> buscarTodos();
	Page<Horario> buscarTodosPaginados(Pageable page);
	void guardar(Horario horario);
	List<Horario> buscarPorPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
	List<Pelicula> buscarPeliculasByHorario_Fecha(Date fecha);
	Horario buscarPorId(int idHorario);
	void eliminarPorId(int idHorario);
	
}
