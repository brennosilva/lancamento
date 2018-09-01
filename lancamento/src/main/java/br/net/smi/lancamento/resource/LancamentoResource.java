package br.net.smi.lancamento.resource;

import java.time.LocalDate;
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
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.repository.CategoriaRepository;
import br.net.smi.lancamento.repository.EmpresaRepository;
import br.net.smi.lancamento.repository.LancamentoRepository;
import br.net.smi.lancamento.service.CategoriaService;
import br.net.smi.lancamento.service.EmpresaService;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class LancamentoResource {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired 
	private EmpresaRepository empresaRepository;
	
	@Autowired 
	private CategoriaRepository categoriaRepository;

	
	@PutMapping("/lancamento")
	public ResponseEntity<Lancamento> atualizar(@RequestBody Lancamento lancamento){
		return new ResponseEntity<>(lancamentoService.atualizar(lancamento), HttpStatus.OK);
	}
	
	@GetMapping("/lancamento")
	public ResponseEntity<List<Lancamento>> listar(){
		return new ResponseEntity<>(lancamentoService.listar(), HttpStatus.OK);
	}
	
	@DeleteMapping("/lancamento/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "lancamento/{dataInicial}/{dataInicial}")
	public ResponseEntity<?> listarPorPeriodo(@PathVariable("dataInicial") String dataInicial,
			@PathVariable("dataFinal") String dataFinal) {
		LocalDate inicio = LocalDate.parse(dataInicial);
		LocalDate fim = LocalDate.parse(dataInicial);		
		return new ResponseEntity<>(lancamentoRepository.findByVencimentoBetween(inicio, fim), HttpStatus.OK);
	}
	
	@PostMapping(path = "lancamento/{id_empresa}/{id_categoria}")
	public ResponseEntity<?> cadastrarLancamento(@PathVariable("id_empresa") Long id_empresa,
			@PathVariable("id_categoria") Long id_categoria, @RequestBody Lancamento lancamento) {
		Empresa empresa = empresaRepository.getOne(id_empresa);
		Categoria categoria = categoriaRepository.getOne(id_categoria);
		lancamento.setEmpresa(empresa);
		lancamento.setCategoria(categoria);
		lancamentoRepository.save(lancamento);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}