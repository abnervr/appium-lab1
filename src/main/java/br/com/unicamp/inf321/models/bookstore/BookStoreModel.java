package br.com.unicamp.inf321.models.bookstore;

import org.graphwalker.core.machine.ExecutionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.unicamp.inf321.Diagrama;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BookStoreModel extends ExecutionContext implements Diagrama {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public BookStoreModel(AndroidDriver<WebElement> driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	@Override
	public void e_FinalizarCarrinho() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_SelecionarEndereco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_RealizarPagamentoBoleto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_SelecionarCartao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Cadastro_De_Endereco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_DecrementarQtd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_VoltarParaCarrinhoDeslogado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Carrinho_Cliente_Deslogado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_PagamentoComCartaoCredito() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_FinalizarCompra() {
		System.out.println("e_FinalizarCompra");
		TouchAction touchAction = new TouchAction(driver);
    	touchAction.tap(1054, 556).perform();			
	}

	@Override
	public void v_Selecao_De_Enderecos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_RealizarLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_VoltarParaCarrinho() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Modalidades_De_Entrega() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_SelecionarModalidadeDeEntrega() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_RetornaPaginaInicial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_SelecionarBoleto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Compra_Finalizada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_PaginaComProduto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_RealizarPagamentoCartao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Formas_De_Pagamento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_PaginaInicialDePesquisa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_init() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/14623175")));
	}

	@Override
	public void e_IncrementarQtd() {
		System.out.println("e_AdicionarProduto");
		TouchAction touchAction = new TouchAction(driver);
    	touchAction.tap(703, 462).perform();	
	}

	@Override
	public void v_Resumo_Da_Compra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_VoltarParaCarrinhoSemEndereco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_IncluirEndereco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Carrinho() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_RemoverEndereco() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_SelecionarProduto() {
		System.out.println("Selecionar produto");
		TouchAction touchAction = new TouchAction(driver);
    	touchAction.tap(181, 635).perform();
	}

	@Override
	public void e_Voltar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_Deslogar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_FinalizarPagamento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_AdicionarProduto() {
		System.out.println("e_AdicionarProduto");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.webkit.WebView")));
		TouchAction touchAction = new TouchAction(driver);
    	touchAction.tap(871, 597).perform();		
	}
	
}
