package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.TipoRutina;

public interface TipoRutinaService {

	public Optional<TipoRutina>findById(Integer id);
	public List<TipoRutina> findAll();
	public TipoRutina save(TipoRutina tr);
	public void deleteById(Integer id);
}
