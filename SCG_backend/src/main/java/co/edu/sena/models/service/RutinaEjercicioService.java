package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.RutinaEjercicio;

public interface RutinaEjercicioService {

	public Optional<RutinaEjercicio>findById(Integer id);
	public List<RutinaEjercicio> findAll();
	public RutinaEjercicio save(RutinaEjercicio re);
	public void deleteById(Integer id);
}
