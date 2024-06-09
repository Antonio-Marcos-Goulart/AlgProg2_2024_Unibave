package avaliacao_3.questao_1;

public class Livros {
    private String tituo;
    private String autor;
    private Integer anoDePublicacao;
    private Integer numeroDeLivroPadraoInternacional_ISBN;
    private String[] pessoasQuePegaramLivroEmprestado;

    public Livros() {
        this.autor = autor;
        this.tituo = tituo;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDeLivroPadraoInternacional_ISBN = numeroDeLivroPadraoInternacional_ISBN;
        this.pessoasQuePegaramLivroEmprestado = pessoasQuePegaramLivroEmprestado;
    }

    public String getTituo() {
        return tituo;
    }

    public void setTituo(String tituo) {
        this.tituo = tituo;
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

    public Integer getNumeroDeLivroPadraoInternacional_ISBN() {
        return numeroDeLivroPadraoInternacional_ISBN;
    }

    public void setNumeroDeLivroPadraoInternacional_ISBN(Integer numeroDeLivroPadraoInternacional_ISBN) {
        this.numeroDeLivroPadraoInternacional_ISBN = numeroDeLivroPadraoInternacional_ISBN;
    }

    public String[] getPessoasQuePegaramLivroEmprestado() {
        return pessoasQuePegaramLivroEmprestado;
    }

    public void setPessoasQuePegaramLivroEmprestado(String[] pessoasQuePegaramLivroEmprestado) {
        this.pessoasQuePegaramLivroEmprestado = pessoasQuePegaramLivroEmprestado;
    }
}
