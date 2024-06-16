package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.FichaAntropo;
import co.edu.sena.repository.FichaAntropoRepository;

@Service
public class FichaAntropoServiceImpl implements FichaAntropoService{

	@Autowired
	FichaAntropoRepository fichaAntropoRepository;
	
	@Override
	public Optional<FichaAntropo> findById(BigInteger id) {
		
		return fichaAntropoRepository.findById(id);
	}

	@Override
	public List<FichaAntropo> findAll() {
		
		return fichaAntropoRepository.findAll();
	}

	@Override
	public FichaAntropo save(FichaAntropo fa) {
		
		return fichaAntropoRepository.save(fa);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		fichaAntropoRepository.deleteById(id);
	}

}
