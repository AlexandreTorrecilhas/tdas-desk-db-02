package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme;
import com.mycompany.cenaflix.consultarfilme.JPanelConsultaFilme;
//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.CardLayout;
//Pacotes UTIL
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Painel container que utiliza CardLayout para exibir diferentes telas.
 * Este painel gerencia a exibição de painéis como "Adicionar Filme" e "Consultar Filme" utilizando um CardLayout.
 *
 * @author (Carlos ALexandre)
 * @version 1.0
 * @since 1.0
 */

public class JPanelContainerCardLayout extends JPanel{
    
    private LinkedHashMap<String, JPanel> telas = new LinkedHashMap();
    private final JPanelAdicionarFilme jPanelAdicionarFilme = new JPanelAdicionarFilme();
    private final JPanelConsultaFilme jPanelConsultarFilme = new JPanelConsultaFilme();
    private CardLayout layout = new CardLayout();

    /**
     * Obtém o CardLayout utilizado pelo painel container.
     *
     * @return O CardLayout do painel.
     */

    @Override
    public CardLayout getLayout() {
        return this.layout;
    }

    /**
     * Construtor do JPanelContainerCardLayout.
     * Inicializa o CardLayout, o mapa de telas e adiciona as telas ao painel container.
     */

    public JPanelContainerCardLayout(){
        this.setJPanel();
        this.setTelas();
        this.addElementos();
    }
    
    private void setJPanel(){
        this.setLayout(layout);
        this.setVisible(false);
    }
    
    private void setTelas(){
        this.telas.put("jPanelConsultarFilme", this.jPanelConsultarFilme);
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
