package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swing


public class JPanelMenuPrincipal extends AbsJPanelGrid {
    
    
    public JPanelMenuPrincipal(){
        this.add(new JPanelMenuNavegacao());
    }
    
}
