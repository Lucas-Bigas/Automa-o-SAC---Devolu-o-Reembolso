package ProcessoTroca;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Troca {

    //instanciando a classe webdriver
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // dizer onde esta esse executaveis chrome
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://172.18.52.80:9000/");
        //Login	usuário e senha
        driver.findElement(By.name("ctl02$TxtUserName")).sendKeys("lucas.menezes");
        driver.findElement(By.name("ctl02$TxtPassword")).sendKeys("Luc@s2010" + Keys.ENTER);
        //Direcionar direto para a pagina requerida
        driver.get("http://172.18.52.80:9000/PedidoPesquisar.aspx");

    }

    @Test
    public void test() throws InterruptedException {
        //Inserindo o numero do pedido
       driver.findElement(By.id("ctl00_MainContainer_PnlFiltros_TxtCodigoExterno1_I")).sendKeys("600087162");
        //Evento do click no botão pesquisar
       driver.findElement (By.id("ctl00_MainContainer_PnlFiltros_BtnPesquisar_CD")).click();
        //Evento de clicar no botão nova troca
       driver.findElement(By.id("ctl00_MainContainer_btnTroca_B")).click();
        //Evento de clicar no combo
       driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_chkProduto_S_D")).click();
        //Aguardar os elementos carregarem
       Thread.sleep(1000);
        //Evento do click para apresentar a lista de objetivo
       driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_B-1']")).click();
        //Selecionando a opção devolução
       driver.findElement(By.xpath(".//*[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_DDD_L_LBI3T0']")).click();
        Thread.sleep(1000);
       //Evento click para apresentar a lista de motivos
        driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbMotivo_B-1']")).click();
        //Selecionando o motivo,
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbMotivo_DDD_L_LBI4T0']")).click();
        //Clicar na aba Dados para coleta/Postagem
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_T1T")).click();
        //Selecionando o tipo de postagem
        driver.findElement(By.linkText("//*[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlDadosTroca_pnlDadosTrocaPostagemColeta_radAutorizacaoItemPequeno_S_D']")).click();
        //Clicando na aba Reembolso
        driver.findElement(By.xpath(".//*[@id='ctl00_MainContainer_PageTrocaDevolucao_T3T']")).click();
        //Clicar no campo Banco para apresentar a lista
        driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlDadosReembolsoEstorno_cmbBancoReembolsoEstorno_B-1']")).click();
        //Selecionando o banco
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlDadosReembolsoEstorno_cmbBancoReembolsoEstorno_DDD_L_LBI162T0")).click();
        //Preencher o campo Agencia
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlDadosReembolsoEstorno_txtAgenciaReembolsoEstorno_I")).sendKeys("3093");
        //Preencher o campo Conta Corrente
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlDadosReembolsoEstorno_txtContaReembolsoEstorno_I")).sendKeys("222212-2");
        //Clicando na aba confirmar
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_T6T")).click();
        //Clicando no botão Confirmar Processo
        driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlConfirmacao_btnConfirmarProcesso_CD")).click();

}

    @AfterClass
    public static void tearDown() {

        //Fecha apenas a aba que usou
        //driver.close();

        //Fecha a janela do browser
       //driver.quit( );

    }
}