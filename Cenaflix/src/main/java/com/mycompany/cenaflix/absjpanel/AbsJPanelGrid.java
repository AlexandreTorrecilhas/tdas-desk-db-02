package com.mycompany.cenaflix.absjpanel;

//Pacotes Swing
import javax.swing.JPanel;
//Pacotes AWT
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
*@author Carlos Alexandre
*@version 1.0
*Objetivo: Criar uma classe abstrata que impelemente o GridLayout
* Descrição: Muitos JPanels utilizariam o GridBagLayout, então, essa classe serve como
* uma base para esses outros JPanels implementando funcoes que retornam as GridConstraints,
*/

public abstract class AbsJPanelGrid extends JPanel {
    
    public AbsJPanelGrid(){
        this.setLayout(new GridBagLayout());
    }

    /*
    *Objetivo da funcao: Retornar a GridBagConstraints para posicionar os componentes.
    *@param int coluna: Essa variável é usada para informar a coluna em que o componente será colocado.
    *@param int linha: Essa variável é usada para informar a linha em que o componente será colocado.
    * @return Está função retorna uma GridBagConstraints que será utilizada pelas classes concretas para posicionar os seus
    * componentes e o espaçamento entre eles.
    */

    protected GridBagConstraints getGridBagConstraints(int coluna, int linha){
        GridBagConstraints regra = new GridBagConstraints();
        regra.gridx = coluna;
        regra.gridy = linha;
        regra.insets = new Insets(5,5,5,5);
        return regra;
    }

    /*
     *Objetivo da funcao: Retornar a GridBagConstraints para posicionar os componentes.
     *@param int coluna: Essa variável é usada para informar a coluna em que o componente será colocado.
     *@param int linha: Essa variável é usada para informar a linha em que o componente será colocado.
     * @return Está função retorna uma GridBagConstraints que será utilizada pelas classes concretas para posicionar os seus
     * componentes e o espaçamento entre eles. A diferença dessa classes é que permite que os componentes cresçam e
     * ocupem todo o espaço horizontal das células.
     */

    protected GridBagConstraints getGridBagConstraintsIpa(int coluna, int linha){
        GridBagConstraints regra = new GridBagConstraints();
        regra.gridx = coluna;
        regra.gridy = linha;
        regra.insets = new Insets(5,5,5,5);
        regra.fill = GridBagConstraints.HORIZONTAL;
        regra.anchor = GridBagConstraints.WEST;
        return regra;
    }
}
