package br.com.unicamp.inf321.models.bookstore;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.unicamp.inf321.Bookstore;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_PaginaInicialDePesquisa")
public class BookStoreModel extends ExecutionContext implements Bookstore {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public BookStoreModel(AndroidDriver<WebElement> driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	@Override
	public void e_AdicionarProduto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(840, 590).perform();
	}

	@Override
	public void e_Deslogar() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(570, 165).perform();
	}

	@Override
	public void e_ErroAoProcessarPagamento() {
		System.out.println("e_ErroAoProcessarPagamento");
	}

	@Override
	public void e_EscolherOutraFormaDePagamento() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(570, 165).perform();
		v_Login();
		e_RealizarLogin();
	}
	
	@Override
	public void e_FecharPaginaDeErro() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(178, 77).perform();
	}

	@Override
	public void e_FinalizarCarrinho() {
		new TouchAction(driver).tap(300, 600).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='6a3c9f973126440eaf8c4436d1164738']")));
		swipeDown();
		new TouchAction(driver).tap(1070, 360).perform();
	}

	@Override
	public void e_FinalizarCompra() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1054, 556).perform();
	}

	@Override
	public void e_FinalizarPagamento() {
		System.out.println("e_FinalizarPagamento");
	}

	@Override
	public void e_IncrementarQtd() {
		System.out.println("e_IncrementarQtd");
	}

	@Override
	public void e_init() {
		driver.launchApp();
	}

	@Override
	public void e_Pesquisar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1150, 240).perform();
	}

	@Override
	public void e_RealizarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(142, 511).perform();
	}

	@Override
	public void e_RealizarPagamentoBoleto() {
		//Realiza o pagamento via cartao, para simular o pagamento via boleto
		e_RealizarPagamentoCartao();
	}

	@Override
	public void e_RealizarPagamentoCartao() {
		swipeDown();
		new TouchAction(driver).tap(200, 280).perform();
	}

	@Override
	public void e_RetornaPaginaInicial() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(600, 530).perform();
	}

	@Override
	public void e_SelecionarEndereco() {
		new TouchAction(driver).tap(300, 600).perform();
	}

	@Override
	public void e_SelecionarModalidadeDeEntrega() {
		System.out.println("e_SelecionarModalidadeDeEntrega");
	}

	@Override
	public void e_SelecionarProduto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(181, 635).perform();
	}

	@Override
	public void e_ValidarPreenchimento() {
		System.out.println("e_ValidarPreenchimento");
	}

	@Override
	public void e_Voltar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(121, 174).perform();
	}

	@Override
	public void e_VoltarParaCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(482, 174).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
	}

	@Override
	public void e_VoltarParaModalidadesEntrega() {
		System.out.println("e_VoltarParaModalidadesEntrega");
	}

	@Override
	public void e_VoltarParaPaginaProduto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(359, 175).perform();
	}

	private void swipeDown() {
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void v_Carrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='35628e6c4b0c49eea72bc6288a1e0d38' or @content-desc='6a3c9f973126440eaf8c4436d1164738']")));
	}

	@Override
	public void v_Compra_Finalizada() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='fa5682b7bdab465780d16d6db7a1076b']")));
	}

	@Override
	public void v_Dados_Do_Cartao() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='50f626da76b748aaa871408b2aa2ec97']")));
	}

	@Override
	public void v_Formas_De_Pagamento() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='9eb94b2bf5e94d80987db6ed5d2e8bf9']")));
	}

	@Override
	public void v_Intermediador_De_Pagamentos() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='50f626da76b748aaa871408b2aa2ec97']")));
	}

	@Override
	public void v_Login() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='72926a0fbf8a41fca4402a20b38c326b']")));
	}

	@Override
	public void v_Modalidades_De_Entrega() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='9eb94b2bf5e94d80987db6ed5d2e8bf9']")));
	}

	@Override
	public void v_PaginaComProduto() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='edb1d1c4a47b49f580e076924454d954']")));
	}

	@Override
 	public void v_PaginaDeErro() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='da99c5adab1043f48c427a2db59b5dfd']")));
	}

	@Override
	public void v_PaginaInicialDePesquisa() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='f5a0f9642c284c8f8b0cdb1b958c1592' or @content-desc='686461b97beb44509af96b2a1e6420f6']")));
	}

	@Override
	public void v_Resumo_Da_Compra() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='50f626da76b748aaa871408b2aa2ec97']")));
	}

}
