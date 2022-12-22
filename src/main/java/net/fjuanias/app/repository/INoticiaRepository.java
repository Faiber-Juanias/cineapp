package net.fjuanias.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Noticia;

@Repository
public interface INoticiaRepository extends JpaRepository<Noticia, Integer> {

	List<Noticia> findByEstatus(String estatus);
	List<Noticia> findByFecha(Date fecha);
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	List<Noticia> findTop3ByEstatusOrderByFechaDesc(String estatus);
	
}
