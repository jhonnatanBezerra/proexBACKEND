package com.reciclanavirai.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclanavirai.domain.Gestor;
import com.reciclanavirai.domain.dto.GestorDTO;
import com.reciclanavirai.exception.ErroAutenticacaoException;
import com.reciclanavirai.service.GestorService;

@RestController
@RequestMapping("/api/gestores")
public class GestorController {

	@Autowired
	private GestorService service;
	
	@GetMapping()
	public ResponseEntity<List<GestorDTO>> listaDeGestores(){
		return ResponseEntity.ok(service.listarGestores());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarGestorPorId(@PathVariable("id")Long id) {
		Optional<GestorDTO> g = service.listarGestoresPorId(id);
		if(!g.isPresent()) {
			return ResponseEntity.badRequest().body("O gestor para o ID informado não foi localizado");
		}else {
			return ResponseEntity.ok(g);
		}
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody Gestor g) {
		try {
			GestorDTO gestorAutenticado = service.autenticar(g.getEmail(), g.getSenha());
			return ResponseEntity.ok(gestorAutenticado);
		}catch(ErroAutenticacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Gestor g) {
		try {
			GestorDTO dto = service.salvar(g);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Gestor g) {
	return service.listarGestoresPorId(id).map(entidade -> {
		try {
			g.setId(entidade.getId());
			service.atualizar(g);
			return ResponseEntity.ok(g);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		}).orElseGet(() -> new ResponseEntity("Gestor não encontrado",HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarGestoresPorId(id).map(entidade -> {
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Gestor não encontrado",HttpStatus.BAD_REQUEST));
	}
	
	
}
