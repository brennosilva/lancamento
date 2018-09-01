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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.service.EmpresaService;

@RestController
public class EmpresaResource {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/empresa")
	public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa empresa){
		return new ResponseEntity<>(empresaService.novo(empresa), HttpStatus.OK);
	}
	
	@PutMapping("/empresa")
	public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresa){
		return new ResponseEntity<>(empresaService.atualizar(empresa), HttpStatus.OK);
	}
		
	
	@GetMapping("/empresa")
	public ResponseEntity<List<Empresa>> listar(){		
		return new ResponseEntity<>(empresaService.listar(), HttpStatus.OK);
				
	}
	
	@GetMapping("/empresa/buscarPorNomeCnpj")
	public ResponseEntity<?> filtrarPorCnpjENome(@RequestParam("cnpj") String cnpj, @RequestParam("nome") String nome){		
		return new ResponseEntity<>(empresaService.filtrarPorCnpjENome(cnpj, nome), HttpStatus.OK);
				
	}
	
	@DeleteMapping("/empresa/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}