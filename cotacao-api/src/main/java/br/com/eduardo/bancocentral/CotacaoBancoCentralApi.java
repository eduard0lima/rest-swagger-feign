package br.com.eduardo.bancocentral;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface CotacaoBancoCentralApi {

    @RequestLine("GET CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='{param}'&$top=100&$format=json&$select=cotacaoCompra,cotacaoVenda,dataHoraCotacao")
    ResponseBodyCotacaoBancoCentral getCotacaoDolar(@Param("param") String data);

}
