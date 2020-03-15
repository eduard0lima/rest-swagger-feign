package br.com.eduardo.bancocentral;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseBodyCotacaoBancoCentral {

    @JsonProperty("value")
    private List<CotacaoBancoCentral> values;


}
