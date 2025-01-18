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

class JPanelTabela extends JPanel {
    private final String[] colunasTabela = {"id","Nome do Filme", "Data de lançamento", "Categoria"};
    private final DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela,0);
    private final JTable tabelaResultado = new JTable(this.modeloTabela);
    private final JScrollPane containerTabela = new JScrollPane(this.tabelaResultado);
    private final TableRowSorter<DefaultTableModel> organizador = new TableRowSorter<>(modeloTabela);
    
    public JPanelTabela(){
        this.setLayout(new BorderLayout());
        this.setTabela();
        this.add(this.containerTabela, BorderLayout.CENTER);
    }
    
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
    
    public JTable getTabelaResultado() {
        return tabelaResultado;
    }
}
