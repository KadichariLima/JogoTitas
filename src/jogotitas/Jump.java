
package jogotitas;

public class Jump extends personagens{

    public Jump(int psx, int psy, String direcao) {
        this.px = psx;
        this.py = psy;
        this.direcao = direcao;
    }    
    
    @Override
    public void andar(String vetDirecao[], int linha, int coluna,personagens person,char matriz[][], String vetAux[]){
        int morto = 0;
        
        for (String vet : vetAux) {
            if(morto == 1){
                person.setPx(Integer.parseInt(vetDirecao[0]));// muda a sua posição x
                person.setPy(Integer.parseInt(vetDirecao[1]));// muda a sua posição x
                person.setDirecao(vetDirecao[2]);//Muda para a direção inicial
                morto = 0;// volta a ficar vivo
            }
            
            if("F".equals(vet)){
                if("L".equals(person.getDirecao())){// Se o personagem estiver para o leste
                    if(person.getPy()+1 >= coluna){//Parede
                        morto = 1;
                    }
                    else{
                        if(matriz[person.getPx()][person.getPy() + 1] == '.'){
                            person.setPy(person.getPy() + 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() + 1] == '#'){// barreira
                            person.setPy(person.getPy() + 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() + 1] == '@'){// barreira
                            person.setPy(person.getPy() + 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() + 1] == '$'){// Tesouro
                            person.setTesouros(person.getTesouros() + 1);
                            matriz[person.getPx()][person.getPy()+1] = '.';
                            person.setPy(person.getPy() + 1);
                        }
                    }
                }else if("O".equals(person.getDirecao())){
                    if(person.getPy() <= 0){//Parede
                        morto = 1;
                    }
                    else{
                        if(matriz[person.getPx()][person.getPy() - 1] == '.'){
                            person.setPy(person.getPy() - 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() - 1] == '#'){// barreira
                            person.setPy(person.getPy() - 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() - 1] == '@'){// barreira
                            person.setPy(person.getPy() - 1);
                        }
                        else if(matriz[person.getPx()][person.getPy() - 1] == '$'){// Tesouro
                            person.setTesouros(person.getTesouros() + 1);
                            matriz[person.getPx()][person.getPy()-1] = '.';
                            person.setPy(person.getPy() - 1);
                        }
                    }    
                }else if("N".equals(person.getDirecao())){
                    if(person.getPx() <= 0){//Parede
                        morto = 1;
                    }
                    else{
                        if(matriz[person.getPx()-1][person.getPy()] == '.'){
                            person.setPx(person.getPx() - 1);
                        }
                        else if(matriz[person.getPx()-1][person.getPy()] == '#'){// barreira
                            person.setPx(person.getPx() - 1);
                        }
                        else if(matriz[person.getPx()-1][person.getPy()] == '@'){// barreira
                            person.setPx(person.getPx() - 1);
                        }
                        else if(matriz[person.getPx()-1][person.getPy()] == '$'){// Tesouro
                            person.setTesouros(person.getTesouros() + 1);
                            matriz[person.getPx()-1][person.getPy()] = '.';
                            person.setPx(person.getPx() - 1);
                        }
                    }
                }
                else{//Sul
                    if(person.getPx()+1 == linha){//Parede
                       morto = 1;
                    }
                    else{
                       if(matriz[person.getPx()+1][person.getPy()] == '.'){
                           person.setPx(person.getPx() + 1);
                        }
                        else if(matriz[person.getPx()+1][person.getPy()] == '#'){// barreira
                            person.setPx(person.getPx() + 1);
                        }
                        else if(matriz[person.getPx()+1][person.getPy()] == '@'){// barreira
                            person.setPx(person.getPx() +1);
                        }
                        else if(matriz[person.getPx()+1][person.getPy()] == '$'){// Tesouro
                            person.setTesouros(person.getTesouros() + 1);
                            matriz[person.getPx()+1][person.getPy()] = '.';
                            person.setPx(person.getPx() + 1);
                        }
                    }
                }
        }else if("E".equals(vet)){ 
               if("L".equals(person.getDirecao())){
                   person.setDirecao("N");
               }else if("O".equals(person.getDirecao())){
                   person.setDirecao("S");
               }else if("N".equals(person.getDirecao())){
                   person.setDirecao("O");
               }
               else{//Sul
                   person.setDirecao("L");
               }
            }else{// Direita
                if("L".equals(person.getDirecao())){
                   person.setDirecao("S");
               }else if("O".equals(person.getDirecao())){
                   person.setDirecao("N");
               }else if("N".equals(person.getDirecao())){
                   person.setDirecao("L");
               }
               else{//Sul
                   person.setDirecao("O");
               }
            }  
            
            if(morto == 1){
                person.setMortes(person.getMortes() + 1);
            } 
        } 
    }
}
