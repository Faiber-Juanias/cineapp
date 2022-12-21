package net.fjuanias.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IBannerService;
import net.fjuanias.app.model.Banner;
import net.fjuanias.app.repository.IBannerRepository;

@Service
public class BannerService implements IBannerService {
	
	@Autowired
	private IBannerRepository repoBanner;

	@Override
	public void guardar(Banner banner) {
		this.repoBanner.save(banner);
	}

	@Override
	public List<Banner> buscarTodas() {
		return this.repoBanner.findAll();
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> banner = this.repoBanner.findById(idBanner);
		if (banner.isPresent()) {
			return banner.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int idBanner) {
		this.repoBanner.deleteById(idBanner);
	}

}
