package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends PaginaBase {

    public Login(WebDriver navegador){
        super(navegador);
    }

    public Login clickEntrar(){
        navegador.findElement(By.linkText("Entrar")).click();

        return this;
    }

    public LoginFormatPage clickLogin(){
        navegador.findElement(By.linkText("Login")).click();

        return new LoginFormatPage(navegador);
    }
}
