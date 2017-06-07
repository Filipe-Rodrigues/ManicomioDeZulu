package resources;

/**
 * Classe Abstrata Efeito - Controla operações de saída de dados.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela provê um modelo padrão para todos os efeitos que um {@link Ator} poderá
 * sofrer. Todo efeito que surgirá no decorrer do jogo deverá partir de alguma
 * classe que herdará diretamente desta.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class Efeito {

    private String nome;
    private String descricao;

    /**
     * Construtor da classe Efeito
     *
     * @param nome Contém o nome do Efeito
     * @param descricao Contém a descrição do Efeito no Ator
     */
    public Efeito (String nome, String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Método getter para o campo "nome".
     *
     * @return O nome do Efeito.
     */
    public String getNome () {
        return nome;
    }
    
    /**
     * Método getter para o campo "descricao".
     *
     * @return A descrição do Efeito.
     */
    public String getDescricao () {
        return descricao;
    }
    
    /**
     * Método abstrato de aplicação de efeito em um dado Ator.
     * Toda subclasse deverá implementar de que maneira esse efeito será
     * aplicado ao Ator.
     *
     * @param alvo Ator a ser afetado pelo efeito.
     * @return true se o efeito foi aplicado corretamente, false caso contrário.
     */
    public abstract  boolean aplicar (Ator alvo);

}
