package net.fjuanias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Detalle;

@Repository
public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {

}
