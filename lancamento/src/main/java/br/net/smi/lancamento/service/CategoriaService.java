package br.net.smi.lancamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria novo(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	public Categoria listarPorId(Long id) {
		return categoriaRepository.findById(id).get();
	}

	public void remover(Long id) {
		categoriaRepository.deleteById(id);
	}

	public Categoria atualizar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}