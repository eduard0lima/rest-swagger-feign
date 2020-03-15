package br.com.eduardo.bancocentral;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Component;

@Component
public class CotacaoBancoCentralClient {

    private CotacaoBancoCentralApi api;

    public CotacaoBancoCentralClient() {
        this.api = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(CotacaoBancoCentralApi.class, "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/");
    }

    public CotacaoBancoCentral getCotacaoDolar(String data) {
        ResponseBodyCotacaoBancoCentral response = this.api.getCotacaoDolar(data);
        return response.getValues().size() > 0 ? response.getValues().get(0) : null;
    }

}
