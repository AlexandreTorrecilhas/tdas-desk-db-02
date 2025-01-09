package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
import com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme;
//Pacotes AWT
import java.awt.BorderLayout;


public class JPanelMenuPrincipal extends AbsJPanelGrid {
    
    
    public JPanelMenuPrincipal(){
        this.setLayout(new BorderLayout());
        this.add(new JPanelMenuNavegacao(), BorderLayout.NORTH);
        this.add(new JPanelAdicionarFilme(), BorderLayout.CENTER);

    }
    
}
