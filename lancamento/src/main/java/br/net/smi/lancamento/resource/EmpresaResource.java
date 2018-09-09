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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.service.EmpresaService;

@RestController
public class EmpresaResource {
	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/empresa/{id}")
	public ResponseEntity<Empresa> buscarPeloId(@PathVariable("id") Long id) {
		return new ResponseEntity<Empresa>(empresaService.buscarPorId(id), HttpStatus.OK);
	}

	@PostMapping("/empresa")
	public ResponseEntity<Empresa> cadastrar(@RequestBody @Valid Empresa empresa) {
		return new ResponseEntity<>(empresaService.cadastrar(empresa), HttpStatus.OK);
	}

	@PutMapping("/empresa")
	public ResponseEntity<Empresa> atualizar(@RequestBody @Valid Empresa empresa) {
		return new ResponseEntity<>(empresaService.atualizar(empresa), HttpStatus.OK);
	}

	@GetMapping("/empresa")
	public ResponseEntity<List<Empresa>> listar() {
		return new ResponseEntity<>(empresaService.listar(), HttpStatus.OK);
	}

	@DeleteMapping("/empresa/{Id}")
	public ResponseEntity<?> deletar(@PathVariable("Id") Long Id) {
		empresaService.delete(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}