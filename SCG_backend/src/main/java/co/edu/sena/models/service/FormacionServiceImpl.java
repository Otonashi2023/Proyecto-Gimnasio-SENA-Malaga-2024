package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Formacion;
import co.edu.sena.repository.FormacionRepository;

@Service
public class FormacionServiceImpl implements FormacionService{

	@Autowired
	FormacionRepository formacionRepository;
	
	@Override
	public Optional<Formacion> findById(Integer id) {
		
		return formacionRepository.findById(id);
	}

	@Override
	public List<Formacion> findAll() {
		
		return formacionRepository.findAll();
	}

	@Override
	public Formacion save(Formacion fo) {
		
		return formacionRepository.save(fo);
	}

	@Override
	public void deleteById(Integer id) {
		
		formacionRepository.deleteById(id);
	}

}
