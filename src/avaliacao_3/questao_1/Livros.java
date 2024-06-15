package avaliacao_3.questao_1;

public class Livros {
    String titulo;
    String genero;
    String autor;
    int anoDePublicacao;
    long numeroDeLivroPadraoInternacional_ISBN; // USANDO LONG POIS COM INT NÃO FUNIONA CORRETAMENTE
    String[] pessoasQuePegaramLivroEmprestado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tiluo) {
        this.titulo = tiluo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(Integer anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public long getNumeroDeLivroPadraoInternacional_ISBN() {
        return numeroDeLivroPadraoInternacional_ISBN;
    }

    public void setNumeroDeLivroPadraoInternacional_ISBN(long numeroDeLivroPadraoInternacional_ISBN) {
        this.numeroDeLivroPadraoInternacional_ISBN = numeroDeLivroPadraoInternacional_ISBN;
    }

    public String[] getPessoasQuePegaramLivroEmprestado() {
        return pessoasQuePegaramLivroEmprestado;
    }

    public void setPessoasQuePegaramLivroEmprestado(String[] pessoasQuePegaramLivroEmprestado) {
        this.pessoasQuePegaramLivroEmprestado = pessoasQuePegaramLivroEmprestado;
    }


    public String toString2020() {
        return "Titulo do Livro: " + titulo + "\n" +
                "Autor: " + autor + "\n";
    }


}
