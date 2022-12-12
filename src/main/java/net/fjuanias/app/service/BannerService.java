package net.fjuanias.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IBannerService;
import net.fjuanias.app.model.Banner;

@Service
public class BannerService implements IBannerService {
	
	private List<Banner> lista = null;
	
	public BannerService() {
		this.lista = new LinkedList<>();
		
		Banner b1 = new Banner();
		b1.setId(1);
		b1.setTitulo("Banner 4");
		b1.setArchivo("slide4.jpg");
		
		Banner b2 = new Banner();
		b2.setId(2);
		b2.setTitulo("Banner 5");
		b2.setArchivo("slide5.jpg");
		b2.setEstatus("Inactiva");
		
		Banner b3 = new Banner();
		b3.setId(3);
		b3.setTitulo("Banner 6");
		b3.setArchivo("slide6.jpg");
		
		Banner b4 = new Banner();
		b4.setId(4);
		b4.setTitulo("Banner 7");
		b4.setArchivo("slide7.jpg");
		
		this.lista.add(b1);
		this.lista.add(b2);
		this.lista.add(b3);
		this.lista.add(b4);
	}

	@Override
	public void guardar(Banner banner) {
		this.lista.add(banner);
	}

	@Override
	public List<Banner> buscarTodas() {
		return this.lista;
	}

}
