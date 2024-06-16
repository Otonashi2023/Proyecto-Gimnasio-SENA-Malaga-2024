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

import co.edu.sena.models.entity.Ficha;
import co.edu.sena.models.service.FichaService;

@RestController
@RequestMapping("/api/ficha")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FichaController {

	@Autowired
	FichaService fichaService;
	
	@GetMapping("/{id}")
	public Optional<Ficha> buscarPorId(@PathVariable Integer id) {
		
		return fichaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Ficha> listarTodos(){
		
		return fichaService.findAll();
	}
	
	@PostMapping
	public Ficha guardar(@RequestBody Ficha fi) {
		
		return fichaService.save(fi);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		fichaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Ficha actualizar(@RequestBody Ficha fi, @PathVariable Integer id) {
		
		Ficha fiEnBD = fichaService.findById(id).get();
		
		fiEnBD.setNumero(fi.getNumero());
		fiEnBD.setFormacion(fi.getFormacion());
		
		return fichaService.save(fiEnBD);
		
	}
}
