package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme;
//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.BorderLayout;
import javax.swing.JButton;

class BotaoNavegacaoControlador {
    
    private JPanelAdicionarFilme jPanelAdicionarFilme = new JPanelAdicionarFilme();
    
    private JPanel jPanelMenuPrincipal;
    
    public BotaoNavegacaoControlador(JPanelMenuPrincipal jMenuPrincipal){
        this.jPanelMenuPrincipal = jMenuPrincipal;
    }
    
    public void abrirTelaInserirFilme(){
        this.jPanelMenuPrincipal.add(jPanelAdicionarFilme, BorderLayout.CENTER);
        System.out.println("clicado aqui também");
        this.jPanelMenuPrincipal.setVisible(true);
        this.jPanelMenuPrincipal.add(new JButton("teste"));
    }
}
