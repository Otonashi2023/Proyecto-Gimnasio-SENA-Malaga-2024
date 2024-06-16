package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.FichaAntropo;

public interface FichaAntropoService {

	public Optional<FichaAntropo>findById(BigInteger id);
	public List<FichaAntropo> findAll();
	public FichaAntropo save(FichaAntropo fa);
	public void deleteById(BigInteger id);
}
