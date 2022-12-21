package net.fjuanias.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Horario;
import net.fjuanias.app.model.Pelicula;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {
	
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
	
	@Query("select distinct h.pelicula from Horario h where h.fecha = :fecha and h.pelicula.estatus = 'Activa'")
	List<Pelicula> findPeliculasByHorario_Fecha(@Param("fecha") Date fecha);
	
}
