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

import com.reciclanavirai.domain.Bairro;
import com.reciclanavirai.domain.dto.BairroDTO;
import com.reciclanavirai.service.BairroService;

@RestController
@RequestMapping("/api/bairros")
public class BairroController {
	
	@Autowired
	private BairroService service;
	
	@GetMapping()
	public ResponseEntity<List<BairroDTO>> listaDeBairros(){
		return ResponseEntity.ok(service.listarBairros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarBairroPorId(@PathVariable("id") Long id){
		Optional<BairroDTO> bairro = service.listarBairroPorId(id);
		if(!bairro.isPresent()) {
			return ResponseEntity.badRequest().body("O bairro para o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(bairro);
		}
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Bairro bairro) {
		try {			
			BairroDTO dto = service.salvar(bairro);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Bairro bairro) {
		return service.listarBairroPorId(id).map(entity -> {
			try {				
				bairro.setId(entity.getId());
				service.atualizar(bairro);
				return ResponseEntity.ok(bairro);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}			
		}).orElseGet(() -> new ResponseEntity("Bairro não encontrado na base de dados", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id){						
		return service.listarBairroPorId(id).map(entidade -> {			
			service.excluir(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Bairro não encontrado na base de dados", HttpStatus.BAD_REQUEST));
	}
	
}
