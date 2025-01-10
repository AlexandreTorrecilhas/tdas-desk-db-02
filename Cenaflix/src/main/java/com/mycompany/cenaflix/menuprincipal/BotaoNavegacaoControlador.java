package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.menuprincipal.JPanelContainerCardLayout;
//Pacotes Swing
import javax.smartcardio.Card;
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.BorderLayout;
import java.awt.CardLayout;

class BotaoNavegacaoControlador {

    private final JPanelContainerCardLayout jPanelContainerCardLayout;
    private final CardLayout cardLayout = new CardLayout();
    
    public BotaoNavegacaoControlador(JPanelContainerCardLayout jPanelContainerCardLayout){
        this.jPanelContainerCardLayout = jPanelContainerCardLayout;
    }
    
    public void abrirTelaInserirFilme(){
        this.jPanelContainerCardLayout.getLayout().show(jPanelContainerCardLayout, "JPanelAdicionarFilme");
    }
}
