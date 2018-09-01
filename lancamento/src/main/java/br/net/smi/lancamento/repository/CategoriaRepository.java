package br.net.smi.lancamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.smi.lancamento.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
