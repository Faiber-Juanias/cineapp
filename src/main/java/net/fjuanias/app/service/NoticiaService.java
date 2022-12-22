package net.fjuanias.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public List<Noticia> buscarTodas() {
		return this.noticiaRepo.findAll();
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		Optional<Noticia> n = this.noticiaRepo.findById(idNoticia);
		if (n.isPresent()) {
			return n.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int idNoticia) {
		this.noticiaRepo.deleteById(idNoticia);
	}

	@Override
	public Page<Noticia> buscarTodasPaginado(Pageable page) {
		return this.noticiaRepo.findAll(page);
	}

}
