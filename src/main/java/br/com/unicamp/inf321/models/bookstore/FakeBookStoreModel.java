package br.com.unicamp.inf321.models.bookstore;

import org.graphwalker.core.machine.ExecutionContext;

import br.com.unicamp.inf321.Bookstore;

public class FakeBookStoreModel extends ExecutionContext implements Bookstore {

	public FakeBookStoreModel() {
	}

	@Override
	public void e_EscolherOutraFormaDePagamento() {
		System.out.println("e_EscolherOutraFormaDePagamento");

	}

	@Override
	public void e_SelecionarEndereco() {
		System.out.println("e_SelecionarEndereco");

	}

	@Override
	public void e_RealizarPagamentoBoleto() {
		System.out.println("e_RealizarPagamentoBoleto");

	}

	@Override
	public void v_Login() {
		System.out.println("v_Login");
	}

	@Override
	public void e_FinalizarCompra() {
		System.out.println("e_FinalizarCompra");

	}

	@Override
	public void e_ErroAoProcessarPagamento() {
		System.out.println("e_ErroAoProcessarPagamento");

	}

	@Override
	public void e_RealizarLogin() {
		System.out.println("e_RealizarLogin");

	}

	@Override
	public void v_Dados_Do_Cartao() {
		System.out.println("v_Dados_Do_Cartao");

	}

	@Override
	public void e_VoltarParaCarrinho() {
		System.out.println("e_VoltarParaCarrinho");

	}

	@Override
	public void v_Modalidades_De_Entrega() {
		System.out.println("v_Modalidades_De_Entrega");

	}

	@Override
	public void v_Intermediador_De_Pagamentos() {
		System.out.println("v_Intermediador_De_Pagamentos");

	}

	@Override
	public void e_SelecionarModalidadeDeEntrega() {
		System.out.println("e_SelecionarModalidadeDeEntrega");

	}

	@Override
	public void e_RetornaPaginaInicial() {
		System.out.println("e_RetornaPaginaInicial");

	}

	@Override
	public void v_Compra_Finalizada() {
		System.out.println("v_Compra_Finalizada");

	}

	@Override
	public void v_PaginaComProduto() {
		System.out.println("v_PaginaComProduto");

	}

	@Override
	public void v_PaginaDeErro() {
		System.out.println("v_PaginaDeErro");

	}

	@Override
	public void e_RealizarPagamentoCartao() {
		System.out.println("e_RealizarPagamentoCartao");

	}

	@Override
	public void e_ValidarPreenchimento() {
		System.out.println("e_ValidarPreenchimento");

	}

	@Override
	public void v_Formas_De_Pagamento() {
		System.out.println("v_Formas_De_Pagamento");

	}

	@Override
	public void v_PaginaInicialDePesquisa() {
		System.out.println("v_PaginaInicialDePesquisa");

	}

	@Override
	public void e_init() {
		System.out.println("e_init");

	}

	@Override
	public void e_Pesquisar() {
		System.out.println("e_Pesquisar");

	}

	@Override
	public void e_IncrementarQtd() {
		System.out.println("e_IncrementarQtd");

	}

	@Override
	public void v_Resumo_Da_Compra() {
		System.out.println("v_Resumo_Da_Compra");

	}

	@Override
	public void v_Carrinho() {
		System.out.println("v_Carrinho");

	}

	@Override
	public void e_SelecionarProduto() {
		System.out.println("e_SelecionarProduto");

	}

	@Override
	public void e_Voltar() {
		System.out.println("e_Voltar");

	}

	@Override
	public void e_Deslogar() {
		System.out.println("e_Deslogar");

	}

	@Override
	public void e_FinalizarPagamento() {
		System.out.println("e_FinalizarPagamento");

	}

	
	@Override
	public void e_FecharPaginaDeErro() {
		System.out.println("e_FecharPaginaDeErro");

	}

	@Override
	public void e_AdicionarProduto() {
		System.out.println("e_AdicionarProduto");

	}

	@Override
	public void e_FinalizarCarrinho() {
		System.out.println("e_FinalizarCarrinho");
	}

	@Override
	public void e_VoltarParaModalidadesEntrega() {
		System.out.println("e_VoltarParaModalidadesEntrega");
	}

	@Override
	public void e_VoltarParaPaginaProduto() {
		System.out.println("e_VoltarParaPaginaProduto");		
	}

}
