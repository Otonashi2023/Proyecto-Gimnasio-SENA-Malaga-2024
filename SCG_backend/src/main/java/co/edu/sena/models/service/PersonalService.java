package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Personal;

public interface PersonalService {

	public Optional<Personal>findById(BigInteger id);
	public List<Personal> findAll();
	public Personal save(Personal pl);
	public void deleteById(BigInteger id);
}
