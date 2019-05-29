package Paginas;

import Suporte.Generator;
import Suporte.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginFormatPage extends PaginaBase {

    public LoginFormatPage(WebDriver navegador){
        super(navegador);
    }


    public LoginFormatPage digitarLogin (String login){
        navegador.findElement(By.id("username")).sendKeys(login);

        return this;
    }

    public LoginFormatPage digitarSenha(String password){
        navegador.findElement(By.id("password")).sendKeys(password);

        return this;
    }

    public InicioPage AcessarConta(){
        navegador.findElement(By.id("login-button")).click();

        return new InicioPage(navegador);
    }

    public InicioPage loginCompleto (String login, String password) throws InterruptedException {
        digitarLogin (login);
        digitarSenha (password);
        Screenshot.tirar(navegador, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "-Login.png");
        AcessarConta();
        Thread.sleep(2500);
        return new InicioPage(navegador);
    }
}
