package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swing
import javax.swing.JButton;

/**
 * Painel contendo os botões de navegação do menu principal.
 * Este painel contém os botões "Adicionar Filme" e "Consultar/Atualizar Filme".
 *
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

class JPanelMenuNavegacao extends AbsJPanelGrid {
    
    private JButton btnAdicionarFilme = new JButton("Adicionar Filme");
    private JButton btnConsultarFilme = new JButton("Consultar/Atualizar Filme");

    /**
     * Construtor do JPanelMenuNavegacao.
     * Inicializa e adiciona os botões ao painel.
     */

    public JPanelMenuNavegacao(){
        this.add(btnAdicionarFilme, this.getGridBagConstraints(0, 0));
        this.add(btnConsultarFilme, this.getGridBagConstraints(1, 0));
    }

    /**
     * Retorna o botão "Adicionar Filme".
     *
     * @return O botão "Adicionar Filme".
     */

    public JButton getBtnAdicionarFilme() {
        return btnAdicionarFilme;
    }

    /**
     * Retorna o botão "Consultar/Atualizar Filme".
     *
     * @return O botão "Consultar/Atualizar Filme".
     */

    public JButton getBtnConsultarFilme() {
        return btnConsultarFilme;
    }    
}
