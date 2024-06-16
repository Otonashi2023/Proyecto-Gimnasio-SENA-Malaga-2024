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

import co.edu.sena.models.entity.Personal;
import co.edu.sena.models.service.PersonalService;

@RestController
@RequestMapping("/api/personal")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PersonalController {

	@Autowired
	PersonalService personalService;
	
	@GetMapping("/{id}")
	public Optional<Personal> buscarPorId(@PathVariable BigInteger id) {
		
		return personalService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Personal> listarTodos(){
		
		return personalService.findAll();
	}
	
	@PostMapping
	public Personal guardar(@RequestBody Personal pl) {
		
		return personalService.save(pl);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		personalService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Personal actualizar(@RequestBody Personal pl, @PathVariable BigInteger id) {
		
		Personal plEnBD = personalService.findById(id).get();
		
		plEnBD.setPersona(pl.getPersona());
		plEnBD.setCargo(pl.getCargo());
				
		return personalService.save(plEnBD);
		
	}
}
