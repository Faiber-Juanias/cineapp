package net.fjuanias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Horario;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {

}
