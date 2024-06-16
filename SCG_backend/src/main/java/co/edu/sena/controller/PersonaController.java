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

import co.edu.sena.models.entity.Persona;
import co.edu.sena.models.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@GetMapping("/{id}")
	public Optional<Persona> buscarPorId(@PathVariable BigInteger id) {
		
		return personaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Persona> listarTodos(){
		
		return personaService.findAll();
	}
	
	@PostMapping
	public Persona guardar(@RequestBody Persona pe) {
		
		return personaService.save(pe);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		personaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Persona actualizar(@RequestBody Persona pe, @PathVariable BigInteger id) {
		
		Persona peEnBD = personaService.findById(id).get();
		
		peEnBD.setNombres(pe.getNombres());
		peEnBD.setApellidos(pe.getApellidos());
		peEnBD.setCedula(pe.getCedula());
		peEnBD.setCelular(pe.getCelular());
		peEnBD.setContacto(pe.getContacto());
		peEnBD.setCelularAlt(pe.getCelularAlt());
		peEnBD.setCorreo(pe.getCorreo());
		peEnBD.setTipoDocumento(pe.getTipoDocumento());
		
		return personaService.save(peEnBD);
		
	}
}
