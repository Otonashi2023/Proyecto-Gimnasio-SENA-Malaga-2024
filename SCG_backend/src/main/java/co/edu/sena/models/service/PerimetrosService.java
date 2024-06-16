package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Perimetros;

public interface PerimetrosService {

	public Optional<Perimetros>findById(BigInteger id);
	public List<Perimetros> findAll();
	public Perimetros save(Perimetros pt);
	public void deleteById(BigInteger id);
}
