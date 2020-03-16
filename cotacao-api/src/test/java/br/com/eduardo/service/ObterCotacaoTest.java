package br.com.eduardo.service;

import br.com.eduardo.bancocentral.CotacaoBancoCentral;
import br.com.eduardo.bancocentral.CotacaoBancoCentralClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObterCotacaoTest {

    @Autowired
    private CotacaoBancoCentralClient cotacaoBancoCentralClient;

    @Test
    public void deveObterCotacao() {
        CotacaoBancoCentral cotacao = cotacaoBancoCentralClient.getCotacaoDolar("11-27-2017");
        Assert.assertNotNull(cotacao);

        Assert.assertEquals(cotacao.getCompra(), "3.22120");
        Assert.assertEquals(cotacao.getVenda(), "3.22180");
        Assert.assertEquals(cotacao.getData(), "2017-11-27 13:04:59.406");
    }
}
