package br.com.eduardo.service;

import br.com.eduardo.bancocentral.CotacaoBancoCentral;
import br.com.eduardo.domain.Cotacao;
import br.com.eduardo.repository.CotacaoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SalvarCotacaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Test
    public void deveSalvarCotacao() {
        CotacaoBancoCentral cotacaoBancoCentral = new CotacaoBancoCentral();
        cotacaoBancoCentral.setCompra("3,5");
        cotacaoBancoCentral.setVenda("4,1");
        cotacaoBancoCentral.setData("2017-11-27 13:04:59.406");

        Long id = entityManager.persistAndGetId(new Cotacao(cotacaoBancoCentral), Long.class);
        Assert.assertNotNull(id);

        Cotacao cotacaoEncontrada = cotacaoRepository.findByCotacaoCompra(cotacaoBancoCentral.getCompra());

        Assert.assertEquals(cotacaoBancoCentral.getCompra(), cotacaoEncontrada.getCotacaoCompra());
        Assert.assertEquals(cotacaoBancoCentral.getVenda(), cotacaoEncontrada.getCotacaoVenda());
    }

}
