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
		System.out.println("e_AdicionarProduto");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(850, 590).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_DecrementarQtd() {
		System.out.println("e_DecrementarQtd");
	}

	@Override
	public void e_Deslogar() {
		System.out.println("e_Deslogar");
	}

	@Override
	public void e_ErroAoProcessarPagamento() {
		System.out.println("e_ErroAoProcessarPagamento");
	}

	@Override
	public void e_EscolherOutraFormaDePagamento() {
		System.out.println("e_EscolherOutraFormaDePagamento");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(178, 77).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_fechar() {
		System.out.println("e_fechar");
		// Fechar tela de erro
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(178, 77).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	private void e_FinalizarCarrinho() {
		System.out.println("e_FinalizarCarrinho");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(300, 600).perform();
		// CEP
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
		swipeDown();
		touchAction = new TouchAction(driver);
		touchAction.tap(1070, 370).perform();
		swipeUp();
	}

	@Override
	public void e_FinalizarCarrinhoDeslogado() {
		e_FinalizarCarrinho();
	}

	@Override
	public void e_FinalizarCarrinhoLogadoComEndereco() {
		e_FinalizarCarrinho();
	}

	@Override
	public void e_FinalizarCarrinhoLogadoSemEndereco() {
		e_FinalizarCarrinho();
	}

	@Override
	public void e_FinalizarCompra() {
		System.out.println("e_FinalizarCompra");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1054, 556).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_FinalizarPagamento() {
		System.out.println("e_FinalizarPagamento");

	}

	@Override
	public void e_IncluirEndereco() {
		System.out.println("e_IncluirEndereco");

	}

	@Override
	public void e_IncrementarQtd() {
		System.out.println("e_IncrementarQtd");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(703, 462).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_init() {
		System.out.println("e_init");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_Pesquisar() {
		System.out.println("e_Pesquisar");
		// Botão de pesquisa
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1150, 240).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_RealizarLogin() {
		System.out.println("e_RealizarLogin");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(142, 511).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_RealizarPagamentoBoleto() {
		System.out.println("e_RealizarPagamentoBoleto");

	}

	@Override
	public void e_RealizarPagamentoCartao() {
		System.out.println("e_RealizarPagamentoCartao");
		swipeDown();
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(200, 280).perform();
		swipeUp();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_RemoverEndereco() {
		System.out.println("e_RemoverEndereco");

	}

	@Override
	public void e_RetornaPaginaInicial() {
		System.out.println("e_RetornaPaginaInicial");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(600, 530).perform();
		// HOME
		// TouchAction touchAction = new TouchAction(driver);
		// touchAction.tap(113, 82).perform();
	}

	@Override
	public void e_SelecionarBoleto() {
		System.out.println("e_SelecionarBoleto");
	}

	@Override
	public void e_SelecionarCartao() {
		System.out.println("e_SelecionarCartao");

	}

	@Override
	public void e_SelecionarEndereco() {
		System.out.println("e_SelecionarEndereco");

	}

	@Override
	public void e_SelecionarModalidadeDeEntrega() {
		System.out.println("e_SelecionarModalidadeDeEntrega");

	}

	@Override
	public void e_SelecionarProduto() {
		System.out.println("e_SelecionarProduto");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(181, 635).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_ValidarPreenchimento() {
		System.out.println("e_ValidarPreenchimento");

	}

	@Override
	public void e_Voltar() {
		System.out.println("e_Voltar");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(121, 174).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_VoltarParaCarrinho() {
		System.out.println("e_VoltarParaCarrinho");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 178).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_VoltarParaCarrinhoDeslogado() {
		System.out.println("e_VoltarParaCarrinhoDeslogado");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 178).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	@Override
	public void e_VoltarParaCarrinhoSemEndereco() {
		System.out.println("e_VoltarParaCarrinhoSemEndereco");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 178).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
	}

	private void swipeDown() {
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
	}

	private void swipeUp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
		driver.swipe(500, 0, 500, 700, 500);
		driver.swipe(500, 0, 500, 700, 500);
	}

	@Override
	public void v_Cadastro_De_Endereco() {
		System.out.println("v_Cadastro_De_Endereco");
	}

	@Override
	public void v_Carrinho() {
		System.out.println("v_Carrinho");
	}

	@Override
	public void v_Carrinho_Cliente_Deslogado() {
		System.out.println("v_Carrinho_Cliente_Deslogado");
	}

	@Override
	public void v_Compra_Finalizada() {
		System.out.println("v_Compra_Finalizada");
	}

	@Override
	public void v_Dados_Do_Cartao() {
		System.out.println("v_Dados_Do_Cartao");
	}

	@Override
	public void v_Formas_De_Pagamento() {
		System.out.println("v_Formas_De_Pagamento");
	}

	@Override
	public void v_Intermediador_De_Pagamentos() {
		System.out.println("v_Intermediador_De_Pagamentos");
	}

	@Override
	public void v_Modalidades_De_Entrega() {
		System.out.println("v_Modalidades_De_Entrega");
	}

	@Override
	public void v_PaginaComProduto() {
		System.out.println("v_PaginaComProduto");
	}

	@Override
	public void v_PaginaIDErro() {
		System.out.println("v_PaginaIDErro");
	}

	@Override
	public void v_PaginaInicialDePesquisa() {
		System.out.println("v_PaginaInicialDePesquisa");
	}

	@Override
	public void v_Resumo_Da_Compra() {
		System.out.println("v_Resumo_Da_Compra");
	}

	@Override
	public void v_Selecao_De_Enderecos() {
		System.out.println("v_Selecao_De_Enderecos");
	}

}
