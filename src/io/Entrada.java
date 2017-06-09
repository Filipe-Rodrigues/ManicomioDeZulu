package io;
import java.util.Scanner;
import java.util.List;

/**
 * Classe Entrada - Controla operações de entrada de dados.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função ler entrada de usuarios, que servirão como comando 
 * para que o player possa controlar o seu personagem através de comandos.
 * 
 * @author  Raydson Ferreira Carlota
 * @version 2017.06.08
 */
public class Entrada {
    private PalavrasDeComando palavrasDeComando;
    private Scanner input;
    
    /**
     * Construtor da classe Efeito
     * 
     * @param palavras Lista de String com as palavras válidas do jogo; 
     */
    public Entrada(List<String> palavras){
        palavrasDeComando = new PalavrasDeComando(palavras);
        input = new Scanner(System.in);
    }
    
    /**
     * Metodo para pegar um comando.
     * 
     * Pega um comando do usuario, divide em duas palavras, e cria 
     * um objeto do tipo {@link Comando} e o retorna.
     * 
     * @return retorna um objeto do tipo {@link Comando}
     */
    public Comando pegarComando(){
        String linha;
        String palavra1 = null;
        String palavra2 = null;
        linha = input.nextLine();
        
        Scanner tokenizer = new Scanner(linha);
        if(tokenizer.hasNext()) {
            palavra1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                palavra2 = tokenizer.next();
            }
        }
        
        Comando novoComando = new Comando(palavra1, palavra2);
        return novoComando;
    }
}