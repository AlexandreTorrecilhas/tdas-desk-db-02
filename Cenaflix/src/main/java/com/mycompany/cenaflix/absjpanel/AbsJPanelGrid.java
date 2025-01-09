package com.mycompany.cenaflix.absjpanel;

//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public abstract class AbsJPanelGrid extends JPanel {
    
    public AbsJPanelGrid(){
        this.setLayout(new GridBagLayout());
    }
    
    protected GridBagConstraints getGridBagConstraints(int coluna, int linha){
        GridBagConstraints regra = new GridBagConstraints();
        regra.gridx = coluna;
        regra.gridy = linha;
        regra.insets = new Insets(5,5,5,5);
        return regra;
    }

    protected GridBagConstraints getGridBagConstraintsIpa(int coluna, int linha){
        GridBagConstraints regra = new GridBagConstraints();
        regra.gridx = coluna;
        regra.gridy = linha;
        regra.insets = new Insets(5,5,5,5);
        regra.weightx = 1.0;
        regra.fill = GridBagConstraints.HORIZONTAL;
        return regra;
    }
}
