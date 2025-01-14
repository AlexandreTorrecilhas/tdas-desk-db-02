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
    private final String[] chaveBotao = {"btnPesquisar"};
    
    public JPanelMenuBotoes(){
        this.setMapBotoes();
        this.addComponentes();
    }
    
    private void setMapBotoes(){
        this.mapBotoes.put("btnPesquisar", this.addJButton("Pesquisar"));
    }
    
    private void addComponentes(){
        for(int linha = 0;linha < mapBotoes.values().toArray().length; linha++){
            for(int coluna = 0; coluna < this.chaveBotao.length; coluna++){
                this.add(this.mapBotoes.get(this.chaveBotao[coluna]), this.getGridBagConstraints(coluna, linha));
            }
        }
    }
    
    private JButton addJButton(String texto){
        JButton novoBotao = new JButton(texto);
        novoBotao.setPreferredSize(new Dimension(30,20));
        novoBotao.setMaximumSize(new Dimension(50,20));
        return novoBotao;
    }
}
