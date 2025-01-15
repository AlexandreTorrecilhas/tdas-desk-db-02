package com.mycompany.cenaflix.consultarfilme;

//Pacotes SWing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.BorderLayout;

public class JPanelConsultaFilme extends JPanel{

    private final JPanelFiltros jPanelFiltros = new JPanelFiltros();
    private final JPanelTabela jPanelTabela = new JPanelTabela();
    private final JPanelMenuBotoes jPanelMenuBotoes = new JPanelMenuBotoes();

    public JPanelConsultaFilme(){
        this.setLayout(new BorderLayout());
        this.add(this.jPanelFiltros, BorderLayout.NORTH);
        
    }
    
}
