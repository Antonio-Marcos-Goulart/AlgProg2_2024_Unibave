package metodos.procedimentos_e_funcoes.jogador;

public class JogadorFut {
    private String nome;
    private int numCamisa;
    private String time;
    private String posicao;
    private int qntGols;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(int numCamisa) {
        this.numCamisa = numCamisa;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQntGols() {
        return qntGols;
    }

    public void setQntGols(int qntGols) {
        this.qntGols = qntGols;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nNúmero da Camisa: " + numCamisa
                + "\nTime: " + time
                + "\nPosição: " + posicao
                + "\nQuantidade de Gols: " + qntGols;
    }
}
