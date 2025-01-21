package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes AWT
import java.awt.BorderLayout;

/**
 * Painel principal da tela inicial da aplicação Cenaflix.
 * Este painel abrange o menu de navegação e o container que exibe os painéis de "Adicionar Filme" e "Consultar Filme".
 *
 * @author (Carlos ALexandre)
 * @version 1.0
 * @since 1.0
 */

class JPanelMenuPrincipal extends AbsJPanelGrid {
    
    private final JPanelMenuNavegacao jPanelMenuNavegcao = new JPanelMenuNavegacao();
    private final JPanelContainerCardLayout jPanelContainerCardLayout = new JPanelContainerCardLayout();

    /**
     * Construtor do JPanelMenuPrincipal.
     * Inicializa o painel de navegação, o painel container e organiza o layout usando BorderLayout.
     */

    public JPanelMenuPrincipal(){
        this.setLayout(new BorderLayout());
        this.add(jPanelMenuNavegcao, BorderLayout.NORTH);
        this.add(jPanelContainerCardLayout, BorderLayout.CENTER);
    }

    /**
     * Obtém o painel de navegação (contendo botões "Adicionar Filme" e "Consultar/Atualizar Filme").
     *
     * @return O painel de navegação.
     */

    public JPanelMenuNavegacao getJPanelMenuNavegacao() {
        return jPanelMenuNavegcao;
    }

    /**
     * Obtém o painel container que gerencia a exibição de "Adicionar Filme" e "Consultar Filme".
     *
     * @return O painel container.
     */

    public JPanelContainerCardLayout getjPanelContainerCardLayout() {
        return jPanelContainerCardLayout;
    }
}
