package net.fjuanias.app.iservice;

import net.fjuanias.app.model.Perfil;

public interface IPerfilService {

	void guardar(Perfil perfil);
	Perfil buscarPorCuenta(String cuenta);
	
}
