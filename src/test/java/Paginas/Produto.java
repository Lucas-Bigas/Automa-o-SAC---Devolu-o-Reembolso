package Paginas;

import Suporte.Generator;
import Suporte.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Produto extends PaginaBase {


    public Produto(WebDriver navegador) {
        super(navegador);
    }
    public Produto clicarNumero() throws InterruptedException {
        Thread.sleep(1500);
        //Evento do click na numeração do produto
        navegador.findElement(By.linkText("38")).click();
        return this;
    }

    public PaginaCart clicarComprar() throws InterruptedException {
        //Evento do click no botão Comprar
        Thread.sleep(4000);
        navegador.findElement(By.id("buy-button-now")).click();

        return new PaginaCart(navegador);
    }

}
