import java.util.ArrayList;
import java.util.List;

public class Lote {
    private String centroDeDistribuicao;
    private List<Item> itens;

    public Lote(String centroDeDistribuicao) {
        this.centroDeDistribuicao = centroDeDistribuicao;
        this.itens = new ArrayList<>();
    }

    public String getCentroDeDistribuicao() {
        return centroDeDistribuicao;
    }

    public void setCentroDeDistribuicao(String centroDeDistribuicao) {
        this.centroDeDistribuicao = centroDeDistribuicao;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void listarItens() {
        System.out.println("Centro de Distribuição: " + centroDeDistribuicao);
        for (Item item : itens) {
            item.exibirDetalhes();
        }
    }
}