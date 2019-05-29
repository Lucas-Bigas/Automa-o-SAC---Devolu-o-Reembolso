package Paginas;


import Suporte.Generator;
import Suporte.Screenshot;
import org.openqa.selenium.WebDriver;

public class InicioPage extends PaginaBase{

    public InicioPage(WebDriver navegador){
        super(navegador);
    }

       public Produto infoProduto() throws InterruptedException {
        Thread.sleep(1000);
        navegador.get("https://hmg-netshoes-com-br.ns2online.com.br/D12-1407-026-38");
        Screenshot.tirar(navegador, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "-Produto.png");
        return new Produto(navegador);
    }



}
