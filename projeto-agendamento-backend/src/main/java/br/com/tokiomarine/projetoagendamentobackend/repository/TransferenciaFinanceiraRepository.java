package br.com.tokiomarine.projetoagendamentobackend.repository;

import br.com.tokiomarine.projetoagendamentobackend.model.entity.TransferenciaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaFinanceiraRepository extends JpaRepository<TransferenciaFinanceira, Long> {
}
