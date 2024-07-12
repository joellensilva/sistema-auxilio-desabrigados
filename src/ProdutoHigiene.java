public class ProdutoHigiene extends Item {
    // private boolean sabonete;
    // private boolean escovaDeDentes;
    // private boolean pastaDeDentes;
    // private boolean absorventes;

    public ProdutoHigiene(String descricao, int quantidade, int centro_id) {
        super(descricao, quantidade, centro_id, 2);
        // this.sabonete = sabonete;
        // this.escovaDeDentes = escovaDeDentes;
        // this.pastaDeDentes = pastaDeDentes;
        // this.absorventes = absorventes;
    }

    // public boolean isSabonete() {
    // return sabonete;
    // }

    // public void setSabonete(boolean sabonete) {
    // this.sabonete = sabonete;
    // }

    // public boolean isEscovaDeDentes() {
    // return escovaDeDentes;
    // }

    // public void setEscovaDeDentes(boolean escovaDeDentes) {
    // this.escovaDeDentes = escovaDeDentes;
    // }

    // public boolean isPastaDeDentes() {
    // return pastaDeDentes;
    // }

    // public void setPastaDeDentes(boolean pastaDeDentes) {
    // this.pastaDeDentes = pastaDeDentes;
    // }

    // public boolean isAbsorventes() {
    // return absorventes;
    // }

    // public void setAbsorventes(boolean absorventes) {
    // this.absorventes = absorventes;
    // }

    @Override
    public void exibirDetalhes() {
        System.out.println("Produto de Higiene: " + descricao + ", Quantidade: " + quantidade);
        /*
         * ", Sabonete: " + sabonete +
         * ", Escova de Dentes: " + escovaDeDentes + ", Pasta de Dentes: " +
         * pastaDeDentes +
         * ", Absorventes: " + absorventes
         */
    }
}