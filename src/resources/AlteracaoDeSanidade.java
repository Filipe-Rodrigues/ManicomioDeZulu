package resources;

/**
 * Classe AlteracaoDeSanidade - Produz efeito de manipulação na Sanidade de César.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Representa o efeito de modificação nos pontos de sanidade de {@link Cesar}.
 * É classe filha de {@link Efeito}, portanto pode ser utilizada indiretamente
 * a partir da aplicação de polimorfismo, permitindo que esteja em uma mesma
 * coleção de dados que uma classe irmã qualquer.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class AlteracaoDeSanidade extends Efeito {

    private int quantidade;
   
    /**
     * Construtor da classe AlteracaoDeSanidade
     *
     * @param nome Contém o nome do Efeito
     * @param descricao Contém a descrição do Efeito no Ator
     * @param quantidade Representa a influência na Sanidade de César.
     * Números positivos deixam ele mais são, e números negativos, mais próximo
     * do surto.
     */
    public AlteracaoDeSanidade (String nome, String descricao, int quantidade) {
        super(nome, descricao);
        this.quantidade = quantidade;
    }

    /**
     * Método getter para o campo "quantidade".
     *
     * @return A força de influência na sanidade de César.
     */
    public int getQuantidade () {
        return quantidade;
    }
    
    /**
     * Método setter para o campo "quantidade".
     *
     * @param quantidade A força de influência na sanidade de César.
     */
    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método de aplicação do efeito em um dado Ator.
     * 
     * Essa classe foi escrita para representar um efeito apenas em um
     * personagem específico, o César. Se tentar utilizá-la para afetar outro
     * personagem, este método não causará influências nos atributos deste.
     * 
     * Nessa classe, este método irá somar a sanidade de César à quantidade
     * descrita pelo seu atributo representativo nessa classe. Se a quantidade 
     * for positiva, César ficará mais são. Se for negativa, ficará mais próximo
     * de ter um surto psicótico.
     *
     * @param alvo Ator a ser afetado pelo efeito.
     * @return true se o efeito foi aplicado corretamente, false caso contrário.
     */
    @Override
    public boolean aplicar (Ator alvo) {
        return alvo.receberDano(quantidade);
    }

}
