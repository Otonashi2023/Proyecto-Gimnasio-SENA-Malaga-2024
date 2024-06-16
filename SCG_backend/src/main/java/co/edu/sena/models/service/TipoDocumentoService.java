package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.TipoDocumento;

public interface TipoDocumentoService {

	public Optional<TipoDocumento>findById(Integer id);
	public List<TipoDocumento> findAll();
	public TipoDocumento save(TipoDocumento td);
	public void deleteById(Integer id);
}
