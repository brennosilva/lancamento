package br.net.smi.lancamento.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.config.RecursoNaoEncontradoException;
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa cadastrar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public Empresa atualizar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	public void delete(Long id) {
		empresaRepository.deleteById(id);
	}

	public Empresa buscarPorId(Long idEmpresa) {
		
		Optional<Empresa> empresaOptional = empresaRepository.findById(idEmpresa);
		if(!empresaOptional.isPresent())
			throw new RecursoNaoEncontradoException();
		
		return empresaOptional.get();
	}

}