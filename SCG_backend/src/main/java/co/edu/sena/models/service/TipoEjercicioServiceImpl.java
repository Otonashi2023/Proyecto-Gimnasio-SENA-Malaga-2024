package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.TipoEjercicio;
import co.edu.sena.repository.TipoEjercicioRepository;

@Service
public class TipoEjercicioServiceImpl implements TipoEjercicioService {

	@Autowired
	TipoEjercicioRepository tipoEjercicioRepository;
	
	@Override
	public Optional<TipoEjercicio> findById(Integer id) {
		
		return tipoEjercicioRepository.findById(id);
	}

	@Override
	public List<TipoEjercicio> findAll() {
		
		return tipoEjercicioRepository.findAll();
	}

	@Override
	public TipoEjercicio save(TipoEjercicio te) {
		
		return tipoEjercicioRepository.save(te);
	}

	@Override
	public void deleteById(Integer id) {
		
		tipoEjercicioRepository.deleteById(id);
	}

}
