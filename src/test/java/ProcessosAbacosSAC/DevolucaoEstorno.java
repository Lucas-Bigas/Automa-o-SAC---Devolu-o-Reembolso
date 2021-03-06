package ProcessosAbacosSAC;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DevolucaoEstorno {

        //instanciando a classe webdriver
        static WebDriver driver;

        @BeforeClass
        public static void setUp() {
            // dizer onde esta os executaveis chrome ou FireFox
            System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
            //System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://172.18.52.80:9000/");
            //Paginas	usuário e senha
            driver.findElement(By.name("ctl02$TxtUserName")).sendKeys("teste.automacao");
            driver.findElement(By.name("ctl02$TxtPassword")).sendKeys("123456" + Keys.ENTER);
            //Direcionar direto para a pagina requerida
            driver.get("http://172.18.52.80:9000/PedidoPesquisar.aspx");

        }

         @Test
        public void DevolucaoComReembolso() throws InterruptedException {
            //Inserindo o numero do pedido
            driver.findElement(By.id("ctl00_MainContainer_PnlFiltros_TxtCodigoExterno1_I")).sendKeys("600096531");
            //Evento do click no botão pesquisar
            driver.findElement(By.id("ctl00_MainContainer_PnlFiltros_BtnPesquisar_CD")).click();
            Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Tela Inicio.png");
            //Evento de clicar no botão nova troca
            driver.findElement(By.id("ctl00_MainContainer_btnTroca_B")).click();
             Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Tela Troca.png");
             //Evento de clicar no combo para habilitar as opções
            Thread.sleep(1500);
            driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_chkProduto_S_D")).click();
            //Aguardar os elementos carregarem
            Thread.sleep(1500);
            //Evento do click para apresentar a lista de objetivo
            driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_B-1']")).click();
            //Selecionando a opção devolução
            Thread.sleep(1500);
            driver.findElement(By.xpath(".//*[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_DDD_L_LBI3T0']")).click();
            Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Objetivo.png");
            Thread.sleep(1500);
            //Evento click para apresentar a lista de motivos
            driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbMotivo_B-1']")).click();
            //Selecionando o motivo,
            Thread.sleep(1500);
            driver.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbMotivo_DDD_L_LBI4T0']")).click();

            //Selecionar a opção de devolver o frete
            //driver.findElement (By.xpath("//*[@id=ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_chkDevolverValorFrete_S_D']")).click();

            //Clicar na aba Dados para coleta/Postagem
            Thread.sleep(1500);
            driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_T1T")).click();
            //Selecionando o tipo de postagem
            Thread.sleep(1700);
            driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlDadosTroca_pnlDadosTrocaPostagemColeta_radAutorizacaoItemPequeno_S_D")).click();
            Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Tipo Coleta.png");
            //Clicando na aba Estorno
            Thread.sleep(1500);
            driver.findElement(By.xpath(".//*[@id='ctl00_MainContainer_PageTrocaDevolucao_T4T']")).click();
             Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Valor Estorno.png");
            //Clicando na aba confirmar
            driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_T6T")).click();
            //Clicando no botão Confirmar Processo
            Thread.sleep(1500);
            driver.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlConfirmacao_btnConfirmarProcesso_CD")).click();
            Thread.sleep(2000);
            Screenshot.tirar(driver, "C:\\Users\\lucas.menezes\\Documents\\EvidenciasAut\\" + Generator.dataHoraParaArquivo() + "Protocolo.png");
        }


        @AfterClass
        public static void tearDown() {
            //Fecha apenas a aba que usou
            //driver.close();

            //Fecha a janela do browser
            driver.quit( );

        }
    }

