package net.fjuanias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Pelicula;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

}
