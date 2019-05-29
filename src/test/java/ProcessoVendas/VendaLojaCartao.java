package ProcessoVendas;

import Paginas.Login;
import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class VendaLojaCartao {
    private WebDriver navegador;

    @Before
    public void setUp(){

        navegador = Web.createChrome();
    }

    @Test
    public void VendaCartao() throws InterruptedException {
        new Login(navegador)
            .clickEntrar()
            .clickLogin()
            .loginCompleto("lucas.netshoesteste2@outlook.com", "lucas2010")
            .infoProduto()
            .clicarNumero()
            .clicarComprar();
    }

    @After
    public void tearDown() {
        //Fecha apenas a aba que usou
        //driver.close();

        //Fecha a janela do browser
        navegador.quit( );

    }


}