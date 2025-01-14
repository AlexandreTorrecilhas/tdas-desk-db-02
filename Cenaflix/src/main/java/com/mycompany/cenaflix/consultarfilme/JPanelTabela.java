package com.mycompany.cenaflix.consultarfilme;

//Pacotes Swing
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class JPanelTabela {
    private final String[] colunasTabela = {"Nome do Filme", "Data de lançamento", "Categoria"};
    private final DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela,0);
    private JTable tabelaResultado = new JTable();
    private JScrollPane containerTabela = new JScrollPane(tabelaResultado);
    
    public JPanelTabela(){}

    public JTable getTabelaResultado() {
        return tabelaResultado;
    }
}
