package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.posicaotela.Coordenadas;
//Pacotes Swing
import javax.swing.JFrame;
//Pacotes AWT
import java.awt.Dimension;

public class JFrameMenuPrincipal extends JFrame {
    Dimension tamanhoJFrame = new Dimension(900,500);
    Integer[] coordenadas = new Coordenadas(this.tamanhoJFrame).getCoordenadas();
    
    public JFrameMenuPrincipal(){
        this.setConfiguracoes();
        this.addComponentes();
    }
    
    private void setConfiguracoes(){
        this.setSize(tamanhoJFrame);
        this.setLocation(coordenadas[0],coordenadas[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponentes(){
        this.add(new JPanelMenuPrincipal());
    }
    
}
