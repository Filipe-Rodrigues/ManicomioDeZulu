package resources;

import java.util.ArrayList;
import java.util.List;
import static resources.Atributo.*;
import static resources.Resultado.*;

/**
 * Classe Abstrata Ator - A generalização de todo personagem do jogo.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é o modelo padrão de todo personagem do jogo, desde os NPCs
 * inimigos até mesmo o próprio personagem principal. Todo personagem está
 * inserido em algum {@link Ambiente}, com exceção do {@link Cesar}, o
 * personagem principal.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class Ator {

    private String nome;
    private List<Integer> atributos;
    private Habilidade habilidade;
    private List<Item> bagagem;
    private boolean aliado;

    /**
     * Construtor padrão da classe Ator.
     *
     * @param nome O nome do Ator.
     * @param hp A quantidade de pontos de vida do Ator. Se for igual a zero,
     * está morto. Maior que zero, vivo. Menor que zero é imortal.
     * @param capacidade Capacidade máxima de carga de itens (em n° de itens).
     * @param habilidade A habilidade especial do Ator.
     * @param bagagem Uma {@link java.util.List} de {@link Item}s portados pelo Ator.
     * @param aliado Se o Ator é aliado do protagonista ({@link Cesar}), true. Senão, false.
     */
    public Ator (String nome, int hp, int capacidade, Habilidade habilidade, List<Item> bagagem, boolean aliado) {
        this.nome = nome;
        this.atributos = new ArrayList<>();
        this.atributos.add(hp);
        this.atributos.add(capacidade);
        this.habilidade = habilidade;
        this.bagagem = new ArrayList<>(bagagem);
        this.aliado = aliado;
    }
    
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    private Resultado afetarOutroAtor (List<Efeito> efeitos, Ator alvo) {
        for (Efeito efeito : efeitos) {
            Resultado resultado = efeito.aplicar(alvo);
            if (resultado != SUCESSO) {
                return resultado;
            }
        }
        return SUCESSO;
    }
    
    /**
     * Operation
     *
     * @param 
     * @param 
     * @return boolean
     */
    private int getItemPorNome (String nomeDoItem) {
        int encontrado = -1;
        int i = 0;
        
        while (i < bagagem.size() && encontrado < 0) {
            if (nomeDoItem.equalsIgnoreCase(bagagem.get(i).getNome())) {
                encontrado = i;
            }
            i++;
        }
        
        return encontrado;
    }
    
    /**
     * Operation
     *
     * @param 
     * @param 
     * @return boolean
     */
    public Resultado darItem (String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = bagagem.get(index);
            bagagem.remove(index);
            return alvo.coletarItem(item);
        }
        
        return ITEM_NAO_ENCONTRADO;
    }
    /**
     * Operation
     *
     * @param 
     * @param 
     * @return boolean
     */
    public Resultado usarItem (String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = bagagem.get(index);
            bagagem.remove(index);
            return afetarOutroAtor(item.getEfeitos(), alvo);
        }
        
        return ITEM_NAO_ENCONTRADO;
    }
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    public Resultado coletarItem (Item item) {
        if (bagagem.size() <= atributos.get(CAPACIDADE.posicao())) {
            bagagem.add(item);
            return SUCESSO;
        }
        return BAGAGEM_LOTADA;
    }
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    public Resultado usarHabilidade (Ator alvo) {
        return alvo.afetarOutroAtor(habilidade.getEfeitos(), alvo);
    }
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    public Resultado afetarHP (int quantidade) {
        int hp = atributos.get(HP.posicao());
        if (hp > 0) {
            if (-quantidade < hp) {
                hp += quantidade;
                if (quantidade > 0) {
                    return ATOR_CURADO;
                } else {
                    return ATOR_FERIDO;
                }
            } else {
                hp = 0;
                return ATOR_ASSASSINADO;
            }
        } else if (hp == 0) {
            return ATOR_MORTO;
        } 
        return ATOR_IMORTAL;
    }
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    public abstract Resultado afetarAtributo (int atributo, int quantidade);
    /**
     * Operation
     *
     * @param 
     * @return boolean
     */
    public Resultado interagir ( Ator  )
    {
        // ## Implementation preserve start class method.interagir@boolean@@@Ator 
        // ## Implementation preserve end class method.interagir@boolean@@@Ator 
    }
    /**
     * Operation
     *
     * @return String
     */
    public String getStatus () {
        int hp = atributos.get(HP.posicao());
        int quantidadeDeItens = bagagem.size();
        int capacidade = atributos.get(CAPACIDADE.posicao());
        
        String status = "";
        status += "Nome:          " + nome + ((hp == 0) ? (" (MORTO)") : ("")) + "\n";
        status += "HP:            " + ((hp < 0) ? ("infinito") : (hp)) + "\n";
        status += "Carga no inv.: " + quantidadeDeItens + "/" + capacidade + "\n";
        status += "Habilidade:    " + habilidade.getNome() + "\n";
        return status;
    }
    /**
     * Operation
     *
     * @return String
     */
    public String getNome (  )
    {
        // ## Implementation preserve start class method.getNome@String@@ 
        // ## Implementation preserve end class method.getNome@String@@ 
    }
    /**
     * Operation
     *
     * @return int
     */
    public int getHP (  )
    {
        // ## Implementation preserve start class method.getHP@int@@ 
        // ## Implementation preserve end class method.getHP@int@@ 
    }
    
    /**
     * Operation
     *
     * @return int
     */
    public int getCapacidade (  )
    {
        // ## Implementation preserve start class method.getHP@int@@ 
        // ## Implementation preserve end class method.getHP@int@@ 
    }
    
    /**
     * Operation
     *
     * @return String
     */
    public String getDescricaoHabilidades (  )
    {
        // ## Implementation preserve start class method.getDescricaoHabilidades@String@@ 
        // ## Implementation preserve end class method.getDescricaoHabilidades@String@@ 
    }
    /**
     * Operation
     *
     * @return String
     */
    public String getListaItens (  )
    {
        // ## Implementation preserve start class method.getListaItens@String@@ 
        // ## Implementation preserve end class method.getListaItens@String@@ 
    }
    /**
     * Operation
     *
     * @return String
     */
    public String getNomeHabilidade (  )
    {
        // ## Implementation preserve start class method.getNomeHabilidade@String@@ 
        // ## Implementation preserve end class method.getNomeHabilidade@String@@ 
    }
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean taVivo (  )
    {
        // ## Implementation preserve start class method.taVivo@boolean@@ 
        // ## Implementation preserve end class method.taVivo@boolean@@ 
    }
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean ehAliado (  )
    {
        // ## Implementation preserve start class method.ehAliado@boolean@@ 
        // ## Implementation preserve end class method.ehAliado@boolean@@ 
    }
    // ## Implementation preserve start class other.operations. 
    // ## Implementation preserve end class other.operations. 
}

// ## Implementation preserve start class closing. 
// ## Implementation preserve end class closing. 
