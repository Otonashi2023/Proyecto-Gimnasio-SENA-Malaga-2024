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

import co.edu.sena.models.entity.Musculo;
import co.edu.sena.models.service.MusculoService;

@RestController
@RequestMapping("/api/musculo")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class MusculoController {
	@Autowired
	MusculoService musculoService;
	
	@GetMapping("/{id}")
	public Optional<Musculo> buscarPorId(@PathVariable Integer id) {
		
		return musculoService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Musculo> listarTodos(){
		
		return musculoService.findAll();
	}
	
	@PostMapping
	public Musculo guardar(@RequestBody Musculo m) {
		
		return musculoService.save(m);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		musculoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Musculo actualizar(@RequestBody Musculo m, @PathVariable Integer id) {
		
		Musculo mEnBD = musculoService.findById(id).get();
		
		mEnBD.setNombre(m.getNombre());
				
		return musculoService.save(mEnBD);
		
	}
}
