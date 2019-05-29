package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        // dizer onde esta os executaveis chrome ou FireFox
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        //driver = new FirefoxDriver();
        navegador.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //Acessando o endereço da loja
        navegador.get("https://hmg-netshoes-com-br.ns2online.com.br");

        //Evento para f4echar a propaganda
        //driver.findElement(By.xpath("//*[@id=\"bg-sombra-floater\"]/div/div[2]/span")).click();
        //Thread.sleep(3000);

        return navegador;
    }
}