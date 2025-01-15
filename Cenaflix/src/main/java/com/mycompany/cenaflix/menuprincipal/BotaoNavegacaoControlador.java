package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.menuprincipal.JPanelContainerCardLayout;
//Pacotes AWT
import java.awt.CardLayout;

class BotaoNavegacaoControlador {

    private final JPanelContainerCardLayout jPanelContainerCardLayout;
    private boolean visibilidadeJPanelCard;
    private CardLayout cardLayout;
    
    public BotaoNavegacaoControlador(JPanelContainerCardLayout jPanelContainerCardLayout){
        this.jPanelContainerCardLayout = jPanelContainerCardLayout;
        this.visibilidadeJPanelCard = this.jPanelContainerCardLayout.isVisible();
    }
    
    public void abrirTelaInserirFilme(){
        this.cardLayout = (CardLayout) this.jPanelContainerCardLayout.getLayout();
        cardLayout.show(jPanelContainerCardLayout, "jPanelAdicionarFilme");
        this.setVisibilidadeContainerCard(true);
    }
    
    public void abrirTelaPesquisaFilme(){
        
        this.cardLayout = (CardLayout) this.jPanelContainerCardLayout.getLayout();
        this.cardLayout.show(jPanelContainerCardLayout, "jPanelConsultarFilme");
        this.setVisibilidadeContainerCard(true);
    }
    
    private void setVisibilidadeContainerCard(boolean visibilidade){
        this.jPanelContainerCardLayout.setVisible(visibilidade);
    }
}
