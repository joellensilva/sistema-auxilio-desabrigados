import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Item {
    protected String descricao;
    protected int quantidade;
    protected int tipo_id;
    protected int centro_id;

    public Item(String descricao, int quantidade, int centro_id, int tipo_id) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.centro_id = centro_id;
        this.tipo_id = tipo_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public abstract void exibirDetalhes();

    public int insertItem() {
        String SQL = "INSERT INTO itens(descricao, quantidade, tipo_id, centro_id) VALUES (?, ?, ?, ?) RETURNING id";
        int generatedId = -1;
        
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, this.descricao);
            pstmt.setInt(2, this.quantidade);
            pstmt.setInt(3, this.tipo_id);
            pstmt.setInt(4, this.centro_id);

            System.out.println("Dados inseridos!");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return generatedId;
    }

    public void updateData(int id, String nome) {
        String SQL = "UPDATE pessoa SET nome = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Dados atualizados!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(int id) {
        String SQL = "DELETE FROM pessoa WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Dados deletados!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectData() {
        String SQL = "SELECT * FROM pessoa";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("nome") + "\t" +
                        rs.getInt("idade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}