package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swing
import javax.swing.JButton;

class JPanelMenuNavegacao extends AbsJPanelGrid {
    
    private JButton btnAdicionarFilme = new JButton("Adicionar Filme");
    private JButton btnConsultarFilme = new JButton("Consultar/Atualizar Filme");
    private JButton btnExcluirFilme = new JButton("Excluir Filme");
    
    public JPanelMenuNavegacao(){
        this.add(btnAdicionarFilme, this.getGridBagConstraints(0, 0));
        this.add(btnConsultarFilme, this.getGridBagConstraints(1, 0));
        this.add(btnExcluirFilme, this.getGridBagConstraints(2,0));
    }

    public JButton getBtnAdicionarFilme() {
        return btnAdicionarFilme;
    }

    public JButton getBtnConsultarFilme() {
        return btnConsultarFilme;
    }

    public JButton getBtnExcluirFilme() {
        return btnExcluirFilme;
    }
    
}
