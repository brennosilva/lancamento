package br.net.smi.lancamento.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.LancamentoDTO;
import br.net.smi.lancamento.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	

	public Lancamento cadastrar(LancamentoDTO lancamentoDTO) {	
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
		lancamento.setCategoria(categoriaService.buscarPorId(lancamentoDTO.getIdCategoria()));
		lancamento.setEmpresa(empresaService.buscarPorId(lancamentoDTO.getIdEmpresa()));		
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Lancamento lancamento) {		
		return lancamentoRepository.save(lancamento);
	}

	public List<Lancamento> listar() {		
		return lancamentoRepository.findAll();
	}

	public void delete(Long id) {
		lancamentoRepository.deleteById(id);	
	}

	public List<Lancamento> listarPorVencimento(LocalDate dataInicio, LocalDate dataFim) {
		return lancamentoRepository.findByVencimentoBetween(dataInicio, dataFim);
	}
	
	
	
}