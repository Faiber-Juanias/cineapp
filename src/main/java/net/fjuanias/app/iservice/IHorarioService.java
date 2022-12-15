package net.fjuanias.app.iservice;

import java.util.List;

import net.fjuanias.app.model.Horario;

public interface IHorarioService {

	List<Horario> buscarTodos();
	void guardar(Horario horario);
	
}
