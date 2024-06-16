package co.edu.sena.controller;

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

import co.edu.sena.models.entity.Formacion;
import co.edu.sena.models.service.FormacionService;

@RestController
@RequestMapping("/api/formacion")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	@GetMapping("/{id}")
	public Optional<Formacion> buscarPorId(@PathVariable Integer id) {
		
		return formacionService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Formacion> listarTodos(){
		
		return formacionService.findAll();
	}
	
	@PostMapping
	public Formacion guardar(@RequestBody Formacion fo) {
		
		return formacionService.save(fo);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		formacionService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Formacion actualizar(@RequestBody Formacion fo, @PathVariable Integer id) {
		
		Formacion foEnBD = formacionService.findById(id).get();
		
		foEnBD.setNombre(fo.getNombre());
		
		return formacionService.save(foEnBD);
		
	}
}
