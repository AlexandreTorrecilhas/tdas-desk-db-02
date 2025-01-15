package com.mycompany.cenaflix.consultarfilme;

//Pacotes Swing
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
//Pacotes AWT
import java.awt.BorderLayout;

class JPanelTabela extends JPanel {
    private final String[] colunasTabela = {"Nome do Filme", "Data de lançamento", "Categoria"};
    private final DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela,0);
    private final JTable tabelaResultado = new JTable(this.modeloTabela);
    private final JScrollPane containerTabela = new JScrollPane(this.tabelaResultado);
    
    public JPanelTabela(){
        this.setLayout(new BorderLayout());
        this.add(this.containerTabela, BorderLayout.CENTER);
    }
    
    public JTable getTabelaResultado() {
        return tabelaResultado;
    }
}
