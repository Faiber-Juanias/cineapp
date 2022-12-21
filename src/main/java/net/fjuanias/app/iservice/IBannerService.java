package net.fjuanias.app.iservice;

import java.util.List;

import net.fjuanias.app.model.Banner;

public interface IBannerService {

	void guardar(Banner banner);
	List<Banner> buscarTodas();
	Banner buscarPorId(int idBanner);
	void eliminarPorId(int idBanner);
	
}
