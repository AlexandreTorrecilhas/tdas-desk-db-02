package com.mycompany.cenaflix.adicionarfilme;
//Pacotes DAO
//Pacotes Swing
import javax.swing.JButton;
//Pacotes UTIL
import java.util.LinkedHashMap;

public class InserirFilmeControlador {
    
    private LinkedHashMap<String, JButton> mapJButton;

    public void InserirFilmeControlador(LinkedHashMap<String, JButton> mapJButton){
        this.mapJButton = mapJButton;
    }
    
}
