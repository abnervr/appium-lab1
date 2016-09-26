package br.com.unicamp.inf321.models.bookstore;

import org.graphwalker.core.machine.ExecutionContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.unicamp.inf321.Diagrama;
import io.appium.java_client.android.AndroidDriver;

public class BookStoreModel extends ExecutionContext implements Diagrama {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public BookStoreModel() {
		super();
	}
	
	public BookStoreModel(AndroidDriver<WebElement> driver) {
		this();
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_IncrementarQtd() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
}
