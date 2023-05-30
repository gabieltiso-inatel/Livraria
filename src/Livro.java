public class Livro implements Comparable<Livro> {
    private String nome;
    private String autor;
    private String editora;
    private int qtdPaginas;

    public Livro() {
    }

    public Livro(String nome, String autor, String editora, int qtdPaginas) throws InfoInvalidaException {
        editora = editora.trim();
        if(!editora.equals("Arqueiro") && !editora.equals("Rocco") && !editora.equals("Leya")) {
            throw new InfoInvalidaException("Essa editora não está entre as permitidas");
        }

        if(qtdPaginas <= 0) {
            throw new InfoInvalidaException("Não é possível criar um livro com 0 ou menos páginas");
        }

        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public int compareTo(Livro l2) {
        return Integer.compare(this.qtdPaginas, l2.qtdPaginas);
    }

    public void mostraInfo() {
        System.out.printf("INFORMAÇÕES DO LIVRO:\nNome: %s\nAutor: %s\nEditora: %s\nQuantidade de Páginas: %d\n\n",
                this.nome, this.autor, this.editora, this.qtdPaginas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
}
