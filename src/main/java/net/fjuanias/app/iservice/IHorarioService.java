package net.fjuanias.app.iservice;

import java.util.Date;
import java.util.List;

import net.fjuanias.app.model.Horario;
import net.fjuanias.app.model.Pelicula;

public interface IHorarioService {

	List<Horario> buscarTodos();
	void guardar(Horario horario);
	List<Horario> buscarPorPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
	List<Pelicula> buscarPeliculasByHorario_Fecha(Date fecha);
	
}
