package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Ficha;

public interface FichaService {

	public Optional<Ficha>findById(Integer id);
	public List<Ficha> findAll();
	public Ficha save(Ficha fi);
	public void deleteById(Integer id);
}
