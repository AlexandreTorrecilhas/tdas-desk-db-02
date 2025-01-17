package com.mycompany.cenaflix.consultarfilme.controlador;

//Pacotes do Projeto
import com.mycompany.cenaflix.consultarfilme.dao.ConsultarFilmeDao;
import validacoes.FiltrosPesquisaValidacao;
//Pacotes Swing
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
//Pacotes UTIL
import java.util.LinkedHashMap;
//Pacotes lang

//Pacotes SQL
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ConsultaFilmeControlador {

    private final FiltrosPesquisaValidacao validacao = new FiltrosPesquisaValidacao();
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
            this.filmeDao.fecharConexao();
        }catch(SQLException erroAoInserirValores){
            System.out.println("Classe: ConsultarFilmeControlador Metodo: getDezValoresIniciais" + erroAoInserirValores.getMessage());
        }
    }
    
    public void pesquisarValoresFiltrados(LinkedHashMap <String, JTextField> mapValoresFiltro){
        if(this.validacao.verificarValores(mapValoresFiltro)){
            try{
                this.modeloTabela.setRowCount(0);
                this.resultadoQuery = this.filmeDao.pesquisarValoresDinamicos(mapValoresFiltro);
                this.metaData = resultadoQuery.getMetaData();
                this.linha = new Object[metaData.getColumnCount()];
                while(resultadoQuery.next()){
                    for(int contador = 1; contador < metaData.getColumnCount(); contador++){
                        this.linha[contador - 1] = resultadoQuery.getObject(contador);
                    }
                    this.modeloTabela.addRow(linha);
                }
                this.filmeDao.fecharConexao();
            }catch(SQLException erroAoInserirValores){
                System.out.println("Classe: ConsultaFilmeControlador/Método: pesquisarValoresFiltrados/Erro: " + erroAoInserirValores.getMessage());
            }
        }
    }
}
