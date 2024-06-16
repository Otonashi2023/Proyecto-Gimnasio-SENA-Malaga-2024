package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.TipoDocumento;
import co.edu.sena.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	@Override
	public Optional<TipoDocumento> findById(Integer id) {
		
		return tipoDocumentoRepository.findById(id);
	}

	@Override
	public List<TipoDocumento> findAll() {
		
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public TipoDocumento save(TipoDocumento td) {
		
		return tipoDocumentoRepository.save(td);
	}

	@Override
	public void deleteById(Integer id) {
		tipoDocumentoRepository.deleteById(id);
		
	}

}
