package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Musculo;

public interface MusculoService {

	public Optional<Musculo>findById(Integer id);
	public List<Musculo> findAll();
	public Musculo save(Musculo m);
	public void deleteById(Integer id);
}
