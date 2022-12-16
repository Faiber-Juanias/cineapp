package net.fjuanias.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.INoticiaService;
import net.fjuanias.app.model.Noticia;
import net.fjuanias.app.repository.INoticiaRepository;

@Service
public class NoticiaService implements INoticiaService {
	
	@Autowired
	private INoticiaRepository noticiaRepo;

	@Override
	public void guardar(Noticia noticia) {
		this.noticiaRepo.save(noticia);
	}

}
