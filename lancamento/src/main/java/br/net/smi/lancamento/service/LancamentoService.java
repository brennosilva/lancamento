package br.net.smi.lancamento.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<Lancamento> listar(){ 
		return lancamentoRepository.findAll();
	}
	
	public Lancamento novo(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(Lancamento lancamento){ 
		return lancamentoRepository.save(lancamento);
	}
	
	public void remover(Long id) {
		lancamentoRepository.deleteById(id);
	}
}