import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registro de Doações");
            System.out.println("2. Registro de Abrigos");
            System.out.println("3. Ordem de Pedido");
            System.out.println("4. Checkout de Itens");
            System.out.println("5. Transferência de doações");
            System.out.println("0. Sair");
            op = in.nextInt();

            switch (op) {
                case 1:
                    registroDoacoes(in);
                    break;

                default:
                    break;
            }
        } while (op != 0);
        in.close();
    }

    static void cadastrarDoacoes(Scanner in) {
        int tipo, centro, quantidade;
        String descricao;
        int op;
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar por CSV ('./entrada/doacoes.csv')");
        System.out.println("2. Cadastrar manualmente");
        op = in.nextInt();

        if (op == 1) {
            String csvFile = "entrada/doacoes.csv";
            try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
                reader.skip(1);
                String[] line;
                while ((line = reader.readNext()) != null) {
                    tipo = Integer.parseInt(line[0]);
                    descricao = line[1];
                    centro = Integer.parseInt(line[2]);
                    quantidade = Integer.parseInt(line[5]);

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
        } else {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Alimento");
            System.out.println("2. Produto de Higiene");
            System.out.println("3. Roupa");
            tipo = in.nextInt();
            in.nextLine();
            System.out.println("Descrição do item:");
            descricao = in.nextLine();
            System.out.println("ID centro de distribuição:");
            centro = in.nextInt();
            System.out.println("Quantidade:");
            quantidade = in.nextInt();
            in.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("Unidade de medida:");
                    String unidadeDeMedida = in.nextLine();

                    System.out.println("Data de validade (formato: 'ano-mes-dia'):");
                    String validade = in.nextLine();

                    Alimento alimento = new Alimento(descricao, quantidade, unidadeDeMedida, validade, centro);
                    alimento.insertAlimento();
                    break;
                case 2:
                    ProdutoHigiene produtoHigiene = new ProdutoHigiene(descricao, quantidade, centro);
                    produtoHigiene.insertItem();
                    break;
                case 3:
                    System.out.println("Gênero (M/F):");
                    String genero = in.next();

                    System.out.println("Tamanho:");
                    String tamanho = in.next();

                    Roupa roupa = new Roupa(descricao, genero, tamanho, quantidade, centro);
                    roupa.insertRoupa();
                    break;
                default:
                    break;
            }
        }
    }

    static void listarDoacoes(Scanner in){
        System.out.println("ID centro de distribuição:");
        int centro_id = in.nextInt();

        CentroDistribuicao centro = new CentroDistribuicao(centro_id);
        centro.consultarItens();
    }

    static void registroDoacoes(Scanner in) {
        int op;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Doações");
            System.out.println("2. Listar Doações");
            System.out.println("3. Alterar Doações");
            System.out.println("4. Excluir Doações");
            System.out.println("0. Sair");
            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    cadastrarDoacoes(in);
                    break;
                case 2:
                    listarDoacoes(in);
                    break;
                default:
                    break;
            }
        } while (op != 0);
    }
}