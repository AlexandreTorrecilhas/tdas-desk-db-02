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

class JPanelMenuBotoes extends AbsJPanelGrid {
    private LinkedHashMap<String, JButton> mapBotoes = new LinkedHashMap();
    private final String[] chaveBotao = {"btnPesquisar", "btnAtualizar"};
    
    public JPanelMenuBotoes(){
        this.setMapBotoes();
        this.addComponentes();
    }
    
    private void setMapBotoes(){
        this.mapBotoes.put("btnPesquisar", this.addJButton("Pesquisar"));
        this.mapBotoes.put("btnAtualizar", this.addJButton("Atualizar Filmes"));
    }
    
    private void addComponentes(){
        for(int linha = 0;linha < mapBotoes.values().toArray().length; linha++){
            for(int coluna = 0; coluna < this.chaveBotao.length; coluna++){
                this.add(this.mapBotoes.get(this.chaveBotao[coluna]), this.getGridBagConstraintsIpa(coluna, linha));
            }
        }
    }
    
    private JButton addJButton(String texto){
        JButton novoBotao = new JButton(texto);
        novoBotao.setPreferredSize(new Dimension(150,30));
        novoBotao.setMaximumSize(new Dimension(200,35));
        return novoBotao;
    }

    public LinkedHashMap<String, JButton> getMapBotoes(){
        return this.mapBotoes;
    }
}
