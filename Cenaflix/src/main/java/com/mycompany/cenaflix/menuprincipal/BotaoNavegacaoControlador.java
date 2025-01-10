package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.menuprincipal.JPanelContainerCardLayout;
//Pacotes AWT
import java.awt.CardLayout;

class BotaoNavegacaoControlador {

    private final JPanelContainerCardLayout jPanelContainerCardLayout;
    private boolean visibilidadeJPanelCard;
    
    public BotaoNavegacaoControlador(JPanelContainerCardLayout jPanelContainerCardLayout){
        this.jPanelContainerCardLayout = jPanelContainerCardLayout;
        this.visibilidadeJPanelCard = this.jPanelContainerCardLayout.isVisible();
    }
    
    public void abrirTelaInserirFilme(){
        this.setVisibilidadeContainerCard(true);
        this.jPanelContainerCardLayout.getLayout().show(jPanelContainerCardLayout, "JPanelAdicionarFilme");
    }
    
    private void setVisibilidadeContainerCard(boolean visibilidade){
        this.jPanelContainerCardLayout.setVisible(visibilidade);
    }
}
