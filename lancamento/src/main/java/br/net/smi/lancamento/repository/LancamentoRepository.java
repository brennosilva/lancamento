package br.net.smi.lancamento.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.smi.lancamento.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	List<Lancamento> findByVencimentoBetween(LocalDate vencimentoInicial, LocalDate vencimentoFinal);
}
