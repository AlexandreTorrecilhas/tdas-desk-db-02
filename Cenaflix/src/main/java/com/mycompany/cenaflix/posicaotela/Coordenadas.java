package com.mycompany.cenaflix.posicaotela;

//Pacotes AWT
import java.awt.Dimension;
import java.awt.Toolkit;

public class Coordenadas {
    
    private Integer[] coordenadas = new Integer[2];
    private Dimension tamanhoJFrame;
    private final Dimension tamanhoMonitor = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Coordenadas(Dimension tamanhoJFrame){
        this.tamanhoJFrame = tamanhoJFrame;
        this.setCoordenadas();
    }
    
    private void setCoordenadas(){
        this.coordenadas[0] = (int)((this.tamanhoMonitor.height - this.tamanhoJFrame.getHeight()) / 2);
        this.coordenadas[1] = (int)((this.tamanhoMonitor.width - this.tamanhoJFrame.getWidth()) / 2);
    }
    
    public Integer[] getCoordenadas(){
        return this.coordenadas;
    }
}
