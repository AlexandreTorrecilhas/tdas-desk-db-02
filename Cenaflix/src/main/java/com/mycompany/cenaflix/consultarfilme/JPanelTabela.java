package com.mycompany.cenaflix.consultarfilme;

//Pacotes Swing
import javax.swing.JTable;
//Pacotes AWT
import java.awt.ScrollPane;

public class JPanelTabela {
    JTable tabelaConsulta = new JTable();
    ScrollPane scrollContainer = new ScrollPane(tabelaConsulta);
}
