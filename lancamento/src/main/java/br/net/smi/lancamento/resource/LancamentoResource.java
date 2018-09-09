package br.net.smi.lancamento.resource;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.LancamentoDTO;
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

	@PostMapping("/lancamento")
	public ResponseEntity<Lancamento> cadastrar(@RequestBody @Valid LancamentoDTO lancamentoDTO) {
		return new ResponseEntity<>(lancamentoService.cadastrar(lancamentoDTO), HttpStatus.OK);
	}

	@PutMapping("/lancamento")
	public ResponseEntity<Lancamento> atualizar(@RequestBody @Valid Lancamento lancamento) {
		return new ResponseEntity<>(lancamentoService.atualizar(lancamento), HttpStatus.OK);
	}

	@GetMapping("/lancamento")
	public ResponseEntity<List<Lancamento>> listarPorVencimento(
			@RequestParam("dataInicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFim) {
		return new ResponseEntity<>(lancamentoService.listarPorVencimento(dataInicio,dataFim), HttpStatus.OK);
	}

	@DeleteMapping("/lancamento/{Id}")
	public ResponseEntity<?> deletar(@PathVariable("Id") Long Id) {
		lancamentoService.delete(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}