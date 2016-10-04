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
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(840, 590).perform();
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
		touchAction.tap(570, 165).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		v_Carrinho_Cliente_Deslogado();
		e_RealizarLogin();
	}

	@Override
	public void e_fechar() {
		// Fechar tela de erro
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(178, 77).perform();
	}

	private void e_FinalizarCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		new TouchAction(driver).tap(300, 600).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		new TouchAction(driver).tap(1070, 360).perform();
	}

	@Override
	public void e_FinalizarCarrinhoDeslogado() {
		System.out.println("e_FinalizarCarrinhoDeslogado");
		e_FinalizarCarrinho();
	}

	@Override
	public void e_FinalizarCarrinhoLogadoComEndereco() {
		System.out.println("e_FinalizarCarrinhoLogadoComEndereco");
		//Simulando uma carrinho logado realizando o login pelo protótipo
		e_FinalizarCarrinho();
		v_Carrinho_Cliente_Deslogado();
		e_RealizarLogin();
	}

	@Override
	public void e_FinalizarCarrinhoLogadoSemEndereco() {
		System.out.println("e_FinalizarCarrinhoLogadoSemEndereco");
		//Simulando uma carrinho logado realizando o login pelo protótipo
		e_FinalizarCarrinho();
		v_Carrinho_Cliente_Deslogado();
		e_RealizarLogin();
	}

	@Override
	public void e_FinalizarCompra() {
		System.out.println("e_FinalizarCompra");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1054, 556).perform();
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
	}

	@Override
	public void e_init() {
		driver.launchApp();
	}

	@Override
	public void e_Pesquisar() {
		System.out.println("e_Pesquisar");
		// Botão de pesquisa
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(1150, 240).perform();
	}

	@Override
	public void e_RealizarLogin() {
		System.out.println("e_RealizarLogin");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(142, 511).perform();
	}

	@Override
	public void e_RealizarPagamentoBoleto() {
		System.out.println("e_RealizarPagamentoBoleto");
		//Realiza o pagamento via cartao, para simular o pagamento via boleto
		e_RealizarPagamentoCartao();
	}

	@Override
	public void e_RealizarPagamentoCartao() {
		System.out.println("e_RealizarPagamentoCartao");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
		driver.swipe(500, 700, 500, 0, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		new TouchAction(driver).tap(200, 280).perform();
	}

	@Override
	public void e_RemoverEndereco() {
		System.out.println("e_RemoverEndereco");
	}

	@Override
	public void e_RetornaPaginaInicial() {
		System.out.println("e_RetornaPaginaInicial");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(600, 530).perform();
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
		System.out.println("e_Voltar");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(121, 174).perform();
	}

	@Override
	public void e_VoltarParaCarrinho() {
		System.out.println("e_VoltarParaCarrinho");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 165).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
	}

	@Override
	public void e_VoltarParaCarrinhoDeslogado() {
		System.out.println("e_VoltarParaCarrinhoDeslogado");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 178).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
	}

	@Override
	public void e_VoltarParaCarrinhoSemEndereco() {
		System.out.println("e_VoltarParaCarrinhoSemEndereco");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(495, 165).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
	}

	@Override
	public void v_Cadastro_De_Endereco() {
		System.out.println("v_Cadastro_De_Endereco");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Image")));
	}

	@Override
	public void v_Carrinho() {
		System.out.println("v_Carrinho");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='35628e6c4b0c49eea72bc6288a1e0d38' or @content-desc='6a3c9f973126440eaf8c4436d1164738']")));
	}

	@Override
	public void v_Carrinho_Cliente_Deslogado() {
		System.out.println("v_Carrinho_Cliente_Deslogado");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='72926a0fbf8a41fca4402a20b38c326b']")));
	}

	@Override
	public void v_Compra_Finalizada() {
		System.out.println("v_Compra_Finalizada");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='fa5682b7bdab465780d16d6db7a1076b']")));
	}

	@Override
	public void v_Dados_Do_Cartao() {
		System.out.println("v_Dados_Do_Cartao");
	}

	@Override
	public void v_Formas_De_Pagamento() {
		System.out.println("v_Formas_De_Pagamento");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='9eb94b2bf5e94d80987db6ed5d2e8bf9']")));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='edb1d1c4a47b49f580e076924454d954']")));
	}

	@Override
	public void v_PaginaIDErro() {
		System.out.println("v_PaginaIDErro");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='da99c5adab1043f48c427a2db59b5dfd']")));
	}

	@Override
	public void v_PaginaInicialDePesquisa() {
		System.out.println("v_PaginaInicialDePesquisa");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='f5a0f9642c284c8f8b0cdb1b958c1592' or @content-desc='686461b97beb44509af96b2a1e6420f6']")));
	}

	@Override
	public void v_Resumo_Da_Compra() {
		System.out.println("v_Resumo_Da_Compra");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Image[@content-desc='50f626da76b748aaa871408b2aa2ec97']")));
	}

	@Override
	public void v_Selecao_De_Enderecos() {
		System.out.println("v_Selecao_De_Enderecos");
	}

}
