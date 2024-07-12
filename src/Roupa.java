import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Roupa extends Item {
    private String genero;
    private String tamanho;

    public Roupa(String descricao, String genero, String tamanho, int quantidade, int centro_id) {
        super(descricao, quantidade, centro_id, 3);
        this.genero = genero;
        this.tamanho = tamanho;
        // this.centro_id = centro_id;
        // this.tipo_id = 3;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Roupa: " + descricao + ", Gênero: " + genero + ", Tamanho: " + tamanho + ", Quantidade: " + quantidade);
    }

    public void insertRoupa() {
        int id = this.insertItem();
        String SQL = "INSERT INTO roupas(item_id, genero, tamanho) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, this.genero);
            pstmt.setString(3, this.tamanho);

            pstmt.executeUpdate();
            System.out.println("Dados inseridos!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}