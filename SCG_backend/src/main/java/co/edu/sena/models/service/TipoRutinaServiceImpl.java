package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.TipoRutina;
import co.edu.sena.repository.TipoRutinaRepository;

@Service
public class TipoRutinaServiceImpl implements TipoRutinaService {

	@Autowired
	TipoRutinaRepository tipoRutinaRepository;
	
	@Override
	public Optional<TipoRutina> findById(Integer id) {
		
		return tipoRutinaRepository.findById(id);
	}

	@Override
	public List<TipoRutina> findAll() {
		
		return tipoRutinaRepository.findAll();
	}

	@Override
	public TipoRutina save(TipoRutina tr) {
		
		return tipoRutinaRepository.save(tr);
	}

	@Override
	public void deleteById(Integer id) {
		tipoRutinaRepository.deleteById(id);
		
	}

}
