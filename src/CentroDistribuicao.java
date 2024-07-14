import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroDistribuicao {
    private String nome;
    private int id;
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

    public CentroDistribuicao(int id) {
        // this.nome = nome;
        this.id = id;
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
        System.out.println("\nRoupas:");
        for (Roupa roupa : roupas) {
            roupa.exibirDetalhes();
        }
        System.out.println("\nProdutos de Higiene:");
        for (ProdutoHigiene produto : produtosHigiene) {
            produto.exibirDetalhes();
        }
        System.out.println("\nAlimentos:");
        for (Alimento alimento : alimentos) {
            alimento.exibirDetalhes();
        }
    }

    public void consultarItens() {
        String sql = "select * from itens " +
                "left join alimentos a on id = a.item_id " +
                "left join roupas r on id = r.item_id " +
                "where centro_id = ?";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Define o valor do parâmetro na consulta SQL
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Processa os resultados da consulta
                while (rs.next()) {
                    String descricao = rs.getString("descricao");
                    int tipo = rs.getInt("tipo_id");
                    int quantidade = rs.getInt("quantidade");
                    switch (tipo) {
                        case 1:
                            String unidadeDeMedida = rs.getString("unidade_medida");
                            String validade = rs.getDate("validade").toString();
                            Alimento alimento = new Alimento(descricao, quantidade, unidadeDeMedida, validade, id);
                            adicionarAlimento(alimento);
                            break;
                        case 2:
                            ProdutoHigiene produtoHigiene = new ProdutoHigiene(descricao, quantidade, id);
                            adicionarProdutoHigiene(produtoHigiene);
                            break;
                        case 3:
                            String genero = rs.getString("genero");
                            String tamanho = rs.getString("tamanho");
                            Roupa roupa = new Roupa(descricao, genero, tamanho, quantidade, id);
                            adicionarRoupa(roupa);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listarItens();
    }
}
