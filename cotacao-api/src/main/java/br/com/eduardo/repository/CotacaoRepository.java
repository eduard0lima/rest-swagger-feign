package br.com.eduardo.repository;

import br.com.eduardo.domain.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

    Cotacao findByCotacaoCompra(String compra);

}
