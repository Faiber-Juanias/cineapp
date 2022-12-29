package net.fjuanias.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IPerfilService;
import net.fjuanias.app.model.Perfil;
import net.fjuanias.app.repository.IPerfilRepository;

@Service
public class PerfilService implements IPerfilService {
	
	@Autowired
	private IPerfilRepository repoPerfil;

	@Override
	public void guardar(Perfil perfil) {
		this.repoPerfil.save(perfil);
	}

	@Override
	public Perfil buscarPorCuenta(String cuenta) {
		Optional<Perfil> per = this.repoPerfil.findByCuenta(cuenta);
		if (per.isPresent()) {
			return per.get();
		}
		return null;
	}

}
