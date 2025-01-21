package com.mycompany.cenaflix.consultarfilme;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swing
import javax.swing.JButton;
//Pacotes UTIL
import java.util.Map;
import java.util.LinkedHashMap;
//Pacotes AWT
import java.awt.Dimension;

/**
 * Painel contendo os botões de ação para a consulta de filmes.
 * Este painel organiza os botões para pesquisar, atualizar e excluir filmes.
 * @author (Carlos Alexandre)
 * @version 1.0
 * @since 1.0
 */

class JPanelMenuBotoes extends AbsJPanelGrid {
    private LinkedHashMap<String, JButton> mapBotoes = new LinkedHashMap();
    private final String[] chaveBotao = {"btnPesquisar", "btnAtualizar", "btnExcluirFilme"};

    /**
     * Construtor do JPanelMenuBotoes.
     * Inicializa o mapa de botões e adiciona os componentes ao painel.
     */

    public JPanelMenuBotoes(){
        this.setMapBotoes();
        this.addComponentes();
    }

    /**
     * Cria e armazena os JButtons no mapa, utilizando nomes descritivos.
     */

    private void setMapBotoes(){
        this.mapBotoes.put("btnPesquisar", this.addJButton("Pesquisar"));
        this.mapBotoes.put("btnAtualizar", this.addJButton("Atualizar Filme"));
        this.mapBotoes.put("btnExcluirFilme", this.addJButton("Excluir Filme"));
    }

    /**
     * Adiciona os JButtons ao painel utilizando o layout GridBagLayout.
     */

    private void addComponentes(){
        for(int linha = 0;linha < mapBotoes.values().toArray().length; linha++){
            for(int coluna = 0; coluna < this.chaveBotao.length; coluna++){
                this.add(this.mapBotoes.get(this.chaveBotao[coluna]), this.getGridBagConstraintsIpa(coluna, linha));
            }
        }
    }

    /**
     * Cria um novo JButton com o texto especificado e as dimensões predefinidas.
     * @param texto O texto do botão.
     * @return O JButton criado.
     */

    private JButton addJButton(String texto){
        JButton novoBotao = new JButton(texto);
        novoBotao.setPreferredSize(new Dimension(150,30));
        novoBotao.setMaximumSize(new Dimension(200,35));
        return novoBotao;
    }

    /**
     * Retorna o mapa de botões associados a seus nomes.
     * @return O mapa de botões.
     */

    public LinkedHashMap<String, JButton> getMapBotoes(){
        return this.mapBotoes;
    }
}
