package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.TipoEjercicio;

public interface TipoEjercicioService {

	public Optional<TipoEjercicio>findById(Integer id);
	public List<TipoEjercicio> findAll();
	public TipoEjercicio save(TipoEjercicio te);
	public void deleteById(Integer id);
}
