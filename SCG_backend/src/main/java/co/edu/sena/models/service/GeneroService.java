package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Genero;

public interface GeneroService {

	public Optional<Genero>findById(Integer id);
	public List<Genero> findAll();
	public Genero save(Genero g);
	public void deleteById(Integer id);
}
