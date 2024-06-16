package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Rutina;

public interface RutinaService {

	public Optional<Rutina>findById(Integer id);
	public List<Rutina> findAll();
	public Rutina save(Rutina r);
	public void deleteById(Integer id);
}
