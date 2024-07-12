import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) {
        String csvFile = "entrada/doacoes.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                int tipo = Integer.parseInt(line[0]);
                String descricao = line[1];
                int centro = Integer.parseInt(line[2]);
                int quantidade = Integer.parseInt(line[5]);

                switch (tipo) {
                    case 1:
                        String unidadeDeMedida = line[6];
                        String validade = line[7];
                        Alimento alimento = new Alimento(descricao, quantidade, unidadeDeMedida, validade, centro);
                        alimento.insertAlimento();
                        break;
                    case 2:
                        ProdutoHigiene produtoHigiene = new ProdutoHigiene(descricao, quantidade, centro);
                        produtoHigiene.insertItem();
                        break;
                    case 3:
                        String genero = line[3];
                        String tamanho = line[4];
                        Roupa roupa = new Roupa(descricao, genero, tamanho, quantidade, centro);
                        roupa.insertRoupa();
                        break;

                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

}
