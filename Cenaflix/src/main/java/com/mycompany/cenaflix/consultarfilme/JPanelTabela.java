package com.mycompany.cenaflix.consultarfilme;

//Pacotes Swing
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.JOptionPane;
//Pacotes AWT
import java.awt.BorderLayout;

/**
 * Painel contendo a tabela de resultados da consulta de filmes.
 * Este painel exibe os filmes encontrados de acordo com os filtros aplicados.
 * @author (Carlos Alexandre)
 * @version 1.0
 * @since 1.0
 */

class JPanelTabela extends JPanel {
    private final String[] colunasTabela = {"id","Nome do Filme", "Data de lançamento", "Categoria"};
    private final DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela,0);
    private final JTable tabelaResultado = new JTable(this.modeloTabela);
    private final JScrollPane containerTabela = new JScrollPane(this.tabelaResultado);
    private final TableRowSorter<DefaultTableModel> organizador = new TableRowSorter<>(modeloTabela);

    /**
     * Construtor do JPanelTabela.
     * Inicializa a tabela de resultados e organiza o painel.
     */

    public JPanelTabela(){
        this.setLayout(new BorderLayout());
        this.setTabela();
        this.add(this.containerTabela, BorderLayout.CENTER);
    }

    /**
     * Configura a tabela de resultados, incluindo ordenação e listener para alterações.
     */

    private void setTabela(){
        this.tabelaResultado.setRowSorter(organizador);
        this.modeloTabela.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e){
                
                if(e.getType() == TableModelEvent.UPDATE){
                    JOptionPane.showMessageDialog(null, "Para confirmar a mudança, clique em atualizar");
                    
                }
            }
        });
    }

    /**
     * Retorna a tabela de resultados.
     * @return A JTable utilizada para exibir os filmes.
     */

    public JTable getTabelaResultado() {
        return tabelaResultado;
    }
}
