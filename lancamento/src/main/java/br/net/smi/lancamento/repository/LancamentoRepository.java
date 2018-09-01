package br.net.smi.lancamento.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.smi.lancamento.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	Optional<Lancamento> findByVencimentoBetween(LocalDate value1,LocalDate value2);
}
