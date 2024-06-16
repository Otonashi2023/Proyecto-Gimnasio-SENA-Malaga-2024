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

import co.edu.sena.models.entity.Genero;
import co.edu.sena.models.service.GeneroService;


@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class GeneroController {

	@Autowired
	GeneroService generoService;
	
	@GetMapping("/{id}")
	public Optional<Genero> buscarPorId(@PathVariable Integer id) {
		
		return generoService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Genero> listarTodos(){
		
		return generoService.findAll();
	}
	
	@PostMapping
	public Genero guardar(@RequestBody Genero g) {
		
		return generoService.save(g);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		generoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Genero actualizar(@RequestBody Genero g, @PathVariable Integer id) {
		
		Genero gEnBD = generoService.findById(id).get();
		
		gEnBD.setNombre(g.getNombre());
				
		return generoService.save(gEnBD);
		
	}
}
