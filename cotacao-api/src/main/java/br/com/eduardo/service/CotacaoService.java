package br.com.eduardo.service;

import br.com.eduardo.bancocentral.CotacaoBancoCentral;
import br.com.eduardo.bancocentral.CotacaoBancoCentralClient;
import br.com.eduardo.domain.Cotacao;
import br.com.eduardo.repository.CotacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class CotacaoService {

    private final CotacaoBancoCentralClient cotacaoBancoCentralClient;
    private final CotacaoRepository cotacaoRepository;

    private CotacaoService(CotacaoBancoCentralClient cotacaoBancoCentralClient,
                             CotacaoRepository cotacaoRepository) {
        this.cotacaoBancoCentralClient = cotacaoBancoCentralClient;
        this.cotacaoRepository = cotacaoRepository;
    }

    public CotacaoBancoCentral getCotacaoDolar(String dataCotacao) {
        CotacaoBancoCentral cotacaoBancoCentral = cotacaoBancoCentralClient.getCotacaoDolar(dataCotacao);
        if (cotacaoBancoCentral != null) {
            cotacaoRepository.save(new Cotacao(cotacaoBancoCentral));
        }
        return cotacaoBancoCentral;
    }

}
