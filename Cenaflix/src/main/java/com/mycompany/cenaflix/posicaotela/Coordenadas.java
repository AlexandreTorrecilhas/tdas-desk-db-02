package com.mycompany.cenaflix.posicaotela;

//Pacotes AWT
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Classe utilitária para calcular as coordenadas de centralização de uma janela.
 * Esta classe calcula as coordenadas (x, y) para centralizar uma janela na tela.
 *
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public class Coordenadas {
    
    private Integer[] coordenadas = new Integer[2];
    private Dimension tamanhoJFrame;
    private final Dimension tamanhoMonitor = Toolkit.getDefaultToolkit().getScreenSize();
    
    /**
     * Construtor da classe Coordenadas.
     *
     * @param tamanhoJFrame As dimensões da janela a ser centralizada.
     */
    
    public Coordenadas(Dimension tamanhoJFrame){
        this.tamanhoJFrame = tamanhoJFrame;
        this.setCoordenadas();
    }
    
    /**
     * Calcula as coordenadas para centralizar a janela.
     */
    
    private void setCoordenadas(){
        this.coordenadas[0] = (int)((this.tamanhoMonitor.height - this.tamanhoJFrame.getHeight()) / 2);
        this.coordenadas[1] = (int)((this.tamanhoMonitor.width - this.tamanhoJFrame.getWidth()) / 2);
    }
    
    /**
     * Retorna as coordenadas calculadas para centralizar a janela.
     *
     * @return Um array de Integers contendo as coordenadas [y, x].
     */
    
    public Integer[] getCoordenadas(){
        return this.coordenadas;
    }
}
