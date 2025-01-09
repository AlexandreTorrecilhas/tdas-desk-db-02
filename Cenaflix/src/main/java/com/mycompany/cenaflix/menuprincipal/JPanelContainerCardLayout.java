package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme;
//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.CardLayout;
//Pacotes UTIL
import java.util.Map;
import java.util.LinkedHashMap;

public class JPanelContainerCardLayout extends JPanel{
    
    private LinkedHashMap<String, JPanel> telas = new LinkedHashMap();
    private JPanelAdicionarFilme jPanelAdicionarFilme = new JPanelAdicionarFilme();
    
    public JPanelContainerCardLayout(){
        this.setJPanel();
        
    }
    
    private void setJPanel(){
        this.setLayout(new CardLayout());
    }
    
    private void setTelas(){
        this.telas.put("jPanelAdicionarFilme", this.jPanelAdicionarFilme);
    }
    
    private void addElementos(){
        for(Map.Entry<String, JPanel> entry: telas.entrySet()){
            String chave = entry.getKey();
            JPanel tela = entry.getValue();
            this.add(tela, chave);
        }
    }
}
