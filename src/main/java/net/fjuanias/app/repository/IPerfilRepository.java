package net.fjuanias.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Perfil;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {
	
	Optional<Perfil> findByCuenta(String cuenta);
	
}
