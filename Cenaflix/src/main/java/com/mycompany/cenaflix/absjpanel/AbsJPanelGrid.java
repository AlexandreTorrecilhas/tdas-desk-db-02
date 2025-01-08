package com.mycompany.cenaflix.absjpanel;

//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public abstract class AbsJPanelGrid extends JPanel {
    
    public AbsJPanelGrid(){}
    
    protected GridBagConstraints getGridBagConstraints(int coluna, int linha){
        GridBagConstraints regra = new GridBagConstraints();
        regra.gridx = coluna;
        regra.gridy = linha;
        regra.insets = new Insets(5,5,5,5);
        return regra;
    }
}
