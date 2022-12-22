package net.fjuanias.app.iservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fjuanias.app.model.Noticia;

public interface INoticiaService {
	
	void guardar(Noticia noticia);
	List<Noticia> buscarTodas();
	Page<Noticia> buscarTodasPaginado(Pageable page);
	Noticia buscarPorId(int idNoticia);
	void eliminarPorId(int idNoticia);
	List<Noticia> buscarNoticiasOrderByFechaDesc();

}
