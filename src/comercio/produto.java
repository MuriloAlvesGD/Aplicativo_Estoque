package comercio;

public class produto {
    public String nome;
    public int cod;
    public int estoque;

    public void diminuir_estoque(int i){
        estoque-=i;
    }
    public void aumentar_estoque(int i){
        estoque+=i;
    }
    public produto (String nome, int cod, int estoque){
        this.nome = nome;
        this.cod = cod;
        this.estoque = estoque;
    }
}
