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

import co.edu.sena.models.entity.Cargo;
import co.edu.sena.models.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@GetMapping("/{id}")
	public Optional<Cargo> buscarPorId(@PathVariable Integer id) {
		
		return cargoService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Cargo> listarTodos(){
		
		return cargoService.findAll();
	}
	
	@PostMapping
	public Cargo guardar(@RequestBody Cargo c) {
		
		return cargoService.save(c);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		cargoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Cargo actualizar(@RequestBody Cargo c, @PathVariable Integer id) {
		
		Cargo cEnBD = cargoService.findById(id).get();
		
		cEnBD.setNombre(c.getNombre());
				
		return cargoService.save(cEnBD);
		
	}
}
