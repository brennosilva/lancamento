package br.net.smi.lancamento.resource;

import java.util.List;

import javax.validation.Valid;

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
import br.net.smi.lancamento.service.CategoriaService;

@RestController
public class CategoriaResource {
	@Autowired

	private CategoriaService categoriaService;

	@PostMapping("/categoria")
	public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid Categoria categoria) {
		return new ResponseEntity<>(categoriaService.cadastrar(categoria), HttpStatus.OK);
	}

	@PutMapping("/categoria")
	public ResponseEntity<Categoria> atualizar(@RequestBody @Valid Categoria categoria) {
		return new ResponseEntity<>(categoriaService.atualizar(categoria), HttpStatus.OK);
	}

	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> listar() {
		return new ResponseEntity<>(categoriaService.listar(), HttpStatus.OK);
	}

	@DeleteMapping("/categoria/{Id}")
	public ResponseEntity<?> deletar(@PathVariable("Id") Long Id) {
		categoriaService.delete(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}