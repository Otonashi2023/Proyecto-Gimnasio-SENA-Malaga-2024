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

import co.edu.sena.models.entity.Perimetros;
import co.edu.sena.models.service.PerimetrosService;

@RestController
@RequestMapping("/api/perimetros")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PerimetrosController {

	@Autowired
	PerimetrosService perimetrosService;
	
	@GetMapping("/{id}")
	public Optional<Perimetros> buscarPorId(@PathVariable BigInteger id) {
		
		return perimetrosService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Perimetros> listarTodos(){
		
		return perimetrosService.findAll();
	}
	
	@PostMapping
	public Perimetros guardar(@RequestBody Perimetros pt) {
		
		return perimetrosService.save(pt);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		perimetrosService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Perimetros actualizar(@RequestBody Perimetros pt, @PathVariable BigInteger id) {
		
		Perimetros ptEnBD = perimetrosService.findById(id).get();
		
		ptEnBD.setCabeza(pt.getCabeza());
		ptEnBD.setCuello(pt.getCuello());
		ptEnBD.setBrazoRelax(pt.getBrazoRelax());
		ptEnBD.setBrazoTenso(pt.getBrazoTenso());
		ptEnBD.setAntebrazo(pt.getAntebrazo());
		ptEnBD.setMuñeca(pt.getMuñeca());
		ptEnBD.setTorax(pt.getTorax());
		ptEnBD.setCintura(pt.getCintura());
		ptEnBD.setCadera(pt.getCadera());
		ptEnBD.setMusloMax(pt.getMusloMax());
		ptEnBD.setMusloMin(pt.getMusloMin());
		ptEnBD.setPantorrillaMax(pt.getPantorrillaMax());
		ptEnBD.setPantorrillaMin(pt.getPantorrillaMin());
		ptEnBD.setFichaantropo(pt.getFichaantropo());
				
		return perimetrosService.save(ptEnBD);
		
	}
}
