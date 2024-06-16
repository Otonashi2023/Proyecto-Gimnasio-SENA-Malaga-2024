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

import co.edu.sena.models.entity.Asistencia;
import co.edu.sena.models.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AsistenciaController {

	@Autowired
	AsistenciaService asistenciaService;
	
	@GetMapping("/{id}")
	public Optional<Asistencia> buscarPorId(@PathVariable BigInteger id) {
		
		return asistenciaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Asistencia> listarTodos(){
		
		return asistenciaService.findAll();
	}
	
	@PostMapping
	public Asistencia guardar(@RequestBody Asistencia as) {
		
		return asistenciaService.save(as);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		asistenciaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Asistencia actualizar(@RequestBody Asistencia as, @PathVariable BigInteger id) {
		
		Asistencia asEnBD = asistenciaService.findById(id).get();
		
		asEnBD.setFecha(as.getFecha());
		asEnBD.setAprendiz(as.getAprendiz());
		
		return asistenciaService.save(asEnBD);
		
	}
}
