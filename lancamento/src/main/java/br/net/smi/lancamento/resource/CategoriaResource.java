package br.net.smi.lancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.service.CategoriaService;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;

	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> novo(@RequestBody Categoria categoria){
		return new ResponseEntity<>(categoriaService.novo(categoria), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria){
		return new ResponseEntity<>(categoriaService.atualizar(categoria), HttpStatus.OK);		
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> listar(){
		return new ResponseEntity<>(categoriaService.listar(), HttpStatus.OK);
	}	
		
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<?> remover(@PathVariable("id") Long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
 }