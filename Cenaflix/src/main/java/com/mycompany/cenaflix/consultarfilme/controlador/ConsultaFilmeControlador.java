package com.mycompany.cenaflix.consultarfilme.controlador;

//Pacotes do Projeto
import com.mycompany.cenaflix.consultarfilme.dao.ConsultarFilmeDao;
//Pacotes Swing
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//Pacotes lang
import java.lang.Object;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ConsultaFilmeControlador {

    private final ConsultarFilmeDao filmeDao = new ConsultarFilmeDao();
    private JTable tabelaResultado;
    private ResultSetMetaData metaData;
    private ResultSet resultadoQuery;
    private DefaultTableModel modeloTabela;
    private Object[] linha;

    public ConsultaFilmeControlador(JTable tabelaResultado){
        this.tabelaResultado = tabelaResultado;
        this.modeloTabela = (DefaultTableModel) this.tabelaResultado.getModel();
    }

    public void getDezValoresIniciais(){
        try{
            this.resultadoQuery = this.filmeDao.getDezPrimeirosFilmes();
            this.metaData = this.resultadoQuery.getMetaData();
            this.linha = new Object[metaData.getColumnCount()];
            while(resultadoQuery.next()){
                for(int contador = 1; contador <= metaData.getColumnCount(); contador++){
                    this.linha[contador -1] = resultadoQuery.getObject(contador);
                }
                this.modeloTabela.addRow(linha);
            }
        }catch(SQLException erroAoInserirValores){
            System.out.println(erroAoInserirValores.getMessage());
        }
    }
}
