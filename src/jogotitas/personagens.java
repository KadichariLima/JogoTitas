
package jogotitas;

public class personagens {
    private int tesouros = 0;
    private int mortes = 0;
    String direcao;
    int px;
    int py;

    public int getTesouros() {
        return tesouros;
    }

    public void setTesouros(int tesouros) {
        this.tesouros = tesouros;
    }

    public int getMortes() {
        return mortes;
    }

    public void setMortes(int mortes) {
        this.mortes = mortes;
    }
    
    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public void andar(String vetDirecao[],int linha, int coluna, personagens person, char matriz[][], String vetAux[]){//funcao generica pra andar de modo a cada personagem
   
    }
}
