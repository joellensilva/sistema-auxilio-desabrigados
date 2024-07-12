import java.util.ArrayList;
import java.util.List;

public class CentroDistribuicao {
    private String nome;
    private List<Roupa> roupas;
    private List<ProdutoHigiene> produtosHigiene;
    private List<Alimento> alimentos;
    private final int CAPACIDADE_MAXIMA = 1000;

    public CentroDistribuicao(String nome) {
        this.nome = nome;
        this.roupas = new ArrayList<>();
        this.produtosHigiene = new ArrayList<>();
        this.alimentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean adicionarRoupa(Roupa roupa) {
        if (roupas.size() < CAPACIDADE_MAXIMA) {
            roupas.add(roupa);
            return true;
        } else {
            System.out.println("Capacidade máxima de roupas atingida no " + nome);
            return false;
        }
    }

    public boolean adicionarProdutoHigiene(ProdutoHigiene produto) {
        if (produtosHigiene.size() < CAPACIDADE_MAXIMA) {
            produtosHigiene.add(produto);
            return true;
        } else {
            System.out.println("Capacidade máxima de produtos de higiene atingida no " + nome);
            return false;
        }
    }

    public boolean adicionarAlimento(Alimento alimento) {
        if (alimentos.size() < CAPACIDADE_MAXIMA) {
            alimentos.add(alimento);
            return true;
        } else {
            System.out.println("Capacidade máxima de alimentos atingida no " + nome);
            return false;
        }
    }

    public void listarItens() {
        System.out.println("Centro de Distribuição: " + nome);
        System.out.println("Roupas:");
        for (Roupa roupa : roupas) {
            roupa.exibirDetalhes();
        }
        System.out.println("Produtos de Higiene:");
        for (ProdutoHigiene produto : produtosHigiene) {
            produto.exibirDetalhes();
        }
        System.out.println("Alimentos:");
        for (Alimento alimento : alimentos) {
            alimento.exibirDetalhes();
        }
    }
}
