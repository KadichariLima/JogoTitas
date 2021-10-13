/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotitas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Kadichari
 */
public class funcoes {
    
    
    public static void MontarMatriz(int linha, int coluna, char matriz[][]) throws FileNotFoundException{ 
        FileInputStream arq = new FileInputStream("titas.txt");//abrir arquivo
        Scanner scan = new Scanner (arq);
        String l;
        l = scan.nextLine();//le a proxima linha 
        char n;
        for(int i=0; i < linha; i++){
            l = scan.nextLine();//pula as linhas 

            for(int j = 0; j < coluna; j ++){
                n = l.charAt(j);//quebra a string
                matriz[i][j] = n;//faço a matriz 
            }
        }
        scan.close();//fecho o arquivo
    }
    public static void ImprimeMatriz(int linha, int coluna, char matriz[][]){
        for(int a = 0; a < linha; a++){
           for(int b = 0; b < coluna; b ++){
               System.out.print(matriz[a][b]);
               System.out.print("\t");
           }
           System.out.print("\n");
        }
    }
    public static int LerArquivo(int linha, String vetPersonagens[], String vetPosicao[]) throws FileNotFoundException{
        FileInputStream arq = new FileInputStream("titas.txt");
        Scanner scan = new Scanner (arq);
        String pula = null;
        String personagem;
        int cont = 0;
        
        for(int i=0; i<linha+1; i++){
            pula = scan.nextLine();//percorro a matriz pulando as linhas 
        }

        while(scan.hasNext()){//leio o arquivo enquanto tiver proxima linha
            personagem = scan.next();//pego alguma coisa kk 
            if(!"0".equals(personagem)){//percorro se for diferente de 0
                scan.next();//pulo string
                pula = scan.next();//pego o proximo
                vetPersonagens[cont] = personagem;
                vetPosicao[cont] = pula;
                cont++;
            }else{
                break;
            }
        }
        return cont;
    }
    
    public static void CriarPersonagens(int linha, int coluna, String vetDirecao[], char matriz[][], String vetPersonagens[],String vetPosicao[], int quantidade) throws IOException{
        
        FileWriter arquivo = new FileWriter ("Resultado.txt");
        PrintWriter arq = new PrintWriter (arquivo); 
        
        int numJ = 1, numD = 1, numC = 1;
        String direcao;//pego a direcao do personagem 
        String vetAux[] = null;
        matriz[Integer.parseInt(vetDirecao[0])][Integer.parseInt(vetDirecao[1])] = '.';
        for(int i=0; i < quantidade; i++){ 
            direcao = vetPosicao[i];//pego a posicao do vetor
            vetAux = direcao.split("");//armazeno as posicoes
            if("Jump".equals(vetPersonagens[i])){
                Jump jump = new Jump(Integer.parseInt(vetDirecao[0]),Integer.parseInt(vetDirecao[1]), vetDirecao[2]);
                jump.andar(vetDirecao,linha, coluna,jump, matriz, vetAux);
                arq.printf("Jump J"+ numJ +" "+jump.getTesouros() +" "+jump.getMortes()+"%n");
                numJ++;
            }else if("Destructor".equals(vetPersonagens[i])){
                Destructor destruct = new Destructor(Integer.parseInt(vetDirecao[0]),Integer.parseInt(vetDirecao[1]), vetDirecao[2]);
                destruct.andar(vetDirecao,linha, coluna,destruct, matriz, vetAux);
                arq.printf("Destructor D"+ numD +" "+destruct.getTesouros() +" "+destruct.getMortes()+"%n");
                numD++;
            }else{
                Constructor construct = new Constructor(Integer.parseInt(vetDirecao[0]),Integer.parseInt(vetDirecao[1]), vetDirecao[2]);
                construct.andar(vetDirecao,linha, coluna,construct, matriz, vetAux);
                arq.printf("Constructor C"+ numC +" "+construct.getTesouros() +" "+construct.getMortes()+"%n");
                numC++;
            }
        }
        arq.close();
    }
}
