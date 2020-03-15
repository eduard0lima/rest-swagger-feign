package br.com.eduardo.web.rest;

import br.com.eduardo.bancocentral.CotacaoBancoCentral;
import br.com.eduardo.service.CotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cotacao")
public class CotacaoResource {

    private final CotacaoService cotacaoService;

    private CotacaoResource(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }

    @GetMapping("/{dataCotacao}")
    public ResponseEntity<?> getCotacaoDolar(@PathVariable String dataCotacao) {
        CotacaoBancoCentral cotacaoBancoCentral = cotacaoService.getCotacaoDolar(dataCotacao);
        if (cotacaoBancoCentral == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cotacaoBancoCentral);
        }
    }

}
