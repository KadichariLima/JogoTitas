/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotitas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kadichari
 */
public class JogoTitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int i = 0, j = 0;
        String vetPersonagens[] = new String [50];//tipo de personagem
        String vetPosicao[] = new String [100];//sequencia de direçoes do personagem
        String vetDirecao[] = new String [4];//posicao da letra do vetor
        
        try{
            FileInputStream arq = new FileInputStream("titas.txt");
            Scanner scan = new Scanner (arq);
            
            int linha = scan.nextInt();//pega o tamanho da matriz
            int coluna = scan.nextInt();
            
            char [][] matriz = new char [linha][coluna];
            
            funcoes.MontarMatriz(linha,coluna,matriz);
            
            for(j = 0; j < linha; j++){
                for(i = 0; i < coluna; i++){
                    if(matriz[j][i] == 'L' || matriz[j][i] == 'O' || matriz[j][i] == 'N' || matriz[j][i] == 'S'){
                        vetDirecao[0] = Integer.toString(j);//converto a posicao de inteiro para string para determinar a pos x
                        vetDirecao[1] = Integer.toString(i);//converto a posicao de inteiro para string para determinar a pos y
                        vetDirecao[2] = ""+matriz[j][i];//converto char pra String pra pegar a direcao
                    }
                }
            }
   
            i = funcoes.LerArquivo(linha, vetPersonagens, vetPosicao);
            
            funcoes.CriarPersonagens(linha, coluna, vetDirecao, matriz,vetPersonagens, vetPosicao, i);
          
        }
        catch(FileNotFoundException ex){
            System.out.println("Arquivo nao encontrado.");
        }
    }
}
