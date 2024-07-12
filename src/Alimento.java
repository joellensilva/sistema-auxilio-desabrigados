import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alimento extends Item {
    private String unidadeDeMedida;
    private String validade;

    public Alimento(String descricao, int quantidade, String unidadeDeMedida, String validade, int centro_id) {
        super(descricao, quantidade, centro_id, 1);
        this.unidadeDeMedida = unidadeDeMedida;
        this.validade = validade;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Alimento: " + descricao + ", Quantidade: " + quantidade +
                ", Unidade de Medida: " + unidadeDeMedida + ", Validade: " + validade);
    }

    public void insertAlimento() {
        int id = this.insertItem();
        String SQL = "INSERT INTO alimentos(item_id, unidade_medida, validade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, this.unidadeDeMedida);
            pstmt.setDate(3, Date.valueOf(validade));

            pstmt.executeUpdate();
            System.out.println("Dados inseridos!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}