package net.fjuanias.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IHorarioService;
import net.fjuanias.app.model.Horario;

@Service
public class HorarioService implements IHorarioService {
	
	private List<Horario> listaHorarios = null;
	
	public HorarioService() {
		this.listaHorarios = new LinkedList<>();
		
		Horario h1 = new Horario();
		h1.setId(1);
		h1.setFecha(new Date());
		h1.setHora("21:00");
		h1.setPrecio(3000);
		h1.setSala("Sala 1");
		
		Horario h2 = new Horario();
		h2.setId(2);
		h2.setFecha(new Date());
		h2.setHora("19:00");
		h2.setPrecio(2500);
		h2.setSala("Sala 2");
		
		listaHorarios.add(h1);
		listaHorarios.add(h2);
	}

	@Override
	public void guardar(Horario horario) {
		this.listaHorarios.add(horario);
	}

	@Override
	public List<Horario> buscarTodos() {
		return this.listaHorarios;
	}

}
