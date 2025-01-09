package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes AWT
import java.awt.BorderLayout;


class JPanelMenuPrincipal extends AbsJPanelGrid {
    
    private final JPanelMenuNavegacao jPanelMenuNavegcao = new JPanelMenuNavegacao();
    
    public JPanelMenuPrincipal(){
        this.setLayout(new BorderLayout());
        this.add(jPanelMenuNavegcao, BorderLayout.NORTH);
    }

    public JPanelMenuNavegacao getJPanelMenuNavegacao() {
        return jPanelMenuNavegcao;
    }
    
}
