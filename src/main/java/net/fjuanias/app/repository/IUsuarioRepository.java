package net.fjuanias.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.fjuanias.app.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByCuenta(String cuenta);
	@Transactional
	@Modifying
	@Query(value = "delete from Usuario u where u.cuenta = :cuenta")
	void deleteByCuenta(@Param("cuenta") String cuenta);
	
}
