package net.fjuanias.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fjuanias.app.iservice.IDetalleService;
import net.fjuanias.app.model.Detalle;
import net.fjuanias.app.repository.IDetalleRepository;

@Service
public class DetalleService implements IDetalleService {

	@Autowired
	IDetalleRepository repoDetalle;
	
	@Override
	public void guardar(Detalle detalle) {
		this.repoDetalle.save(detalle);
	}

}
