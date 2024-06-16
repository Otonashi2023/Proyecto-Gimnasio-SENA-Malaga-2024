package co.edu.sena.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.models.entity.Aprendiz;
import co.edu.sena.models.service.AprendizService;

@RestController
@RequestMapping("/api/aprendiz")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AprendizController {

	@Autowired
	AprendizService aprendizService;
	
	@GetMapping("/{id}")
	public Optional<Aprendiz> buscarPorId(@PathVariable BigInteger id) {
		
		return aprendizService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Aprendiz> listarTodos(){
		
		return aprendizService.findAll();
	}
	
	@PostMapping
	public Aprendiz guardar(@RequestBody Aprendiz a) {
		
		return aprendizService.save(a);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		aprendizService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Aprendiz actualizar(@RequestBody Aprendiz a, @PathVariable BigInteger id) {
		
		Aprendiz aEnBD = aprendizService.findById(id).get();
		
		aEnBD.setRestricMedicas(a.getRestricMedicas());
		aEnBD.setPersona(a.getPersona());
		aEnBD.setFicha(a.getFicha());
		
		return aprendizService.save(aEnBD);
		
	}
}
