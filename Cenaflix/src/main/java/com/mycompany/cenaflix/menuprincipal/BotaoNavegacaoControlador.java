package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.menuprincipal.JPanelContainerCardLayout;
//Pacotes AWT
import javax.swing.*;
import java.awt.CardLayout;

/**
 * Controlador para os botões de navegação da tela principal.
 * Esta classe gerencia a exibição dos painéis "Inserir Filme" e "Consultar Filme" utilizando um CardLayout.
 *
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

class BotaoNavegacaoControlador {

    private final JPanelContainerCardLayout jPanelContainerCardLayout;
    private boolean visibilidadeJPanelCard;
    private CardLayout cardLayout;

    /**
     * Construtor do BotaoNavegacaoControlador.
     *
     * @param jPanelContainerCardLayout O painel container que utiliza o CardLayout.
     */

    public BotaoNavegacaoControlador(JPanelContainerCardLayout jPanelContainerCardLayout){
        this.jPanelContainerCardLayout = jPanelContainerCardLayout;
        this.visibilidadeJPanelCard = this.jPanelContainerCardLayout.isVisible();
    }

    /**
     * Exibe o painel "Inserir Filme".
     */

    public void abrirTelaInserirFilme(){
        this.cardLayout = (CardLayout) this.jPanelContainerCardLayout.getLayout();
        cardLayout.show(jPanelContainerCardLayout, "jPanelAdicionarFilme");
        this.setVisibilidadeContainerCard(true);
    }

    /**
     * Exibe o painel "Consultar Filme".
     */

    public void abrirTelaPesquisaFilme(){
        
        this.cardLayout = (CardLayout) this.jPanelContainerCardLayout.getLayout();
        this.cardLayout.show(jPanelContainerCardLayout, "jPanelConsultarFilme");
        this.setVisibilidadeContainerCard(true);
    }
    
    private void setVisibilidadeContainerCard(boolean visibilidade){
        this.jPanelContainerCardLayout.setVisible(visibilidade);
    }
}
