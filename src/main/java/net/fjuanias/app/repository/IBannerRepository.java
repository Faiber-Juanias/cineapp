package net.fjuanias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fjuanias.app.model.Banner;

@Repository
public interface IBannerRepository extends JpaRepository<Banner, Integer> {

}
