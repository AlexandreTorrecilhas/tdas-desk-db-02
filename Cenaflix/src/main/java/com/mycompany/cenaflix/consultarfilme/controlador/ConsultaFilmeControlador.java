package com.mycompany.cenaflix.consultarfilme.controlador;

//Pacotes do Projeto
import com.mycompany.cenaflix.consultarfilme.dao.ConsultarFilmeDao;
import validacoes.FiltrosPesquisaValidacao;
//Pacotes Swing
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    
    public void pesquisarValoresFiltrados(LinkedHashMap <String, JTextField> mapValoresFiltro){
        if(this.validacao.verificarValores(mapValoresFiltro)){
            try{
                this.modeloTabela.setRowCount(0);
                this.resultadoQuery = this.filmeDao.pesquisarValoresDinamicos(mapValoresFiltro);
                this.metaData = resultadoQuery.getMetaData();
                this.linha = new Object[metaData.getColumnCount()];
                while(resultadoQuery.next()){
                    for(int contador = 1; contador <= metaData.getColumnCount(); contador++){
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
    
    public void atualizarFilme(JTable tabelaResultado){

        Object resultadoConsulta[];
        int resultadoAtualizacao = 0;
        
        if(tabelaResultado.getSelectedRow()!= -1){
            this.modeloTabela = (DefaultTableModel) tabelaResultado.getModel();
            int linhaTabela = tabelaResultado.getSelectedRow();
            int quantidadeTabela = this.modeloTabela.getColumnCount();
            resultadoConsulta = new Object[quantidadeTabela];

            for(int contador = 0; contador < quantidadeTabela; contador++){
                resultadoConsulta[contador] = tabelaResultado.getValueAt(linhaTabela, contador);
            }

            resultadoAtualizacao = this.filmeDao.atualizarValores(resultadoConsulta);

            JOptionPane.showMessageDialog(null,"Linhas atualizadas: " + resultadoAtualizacao);
        }
        else if(tabelaResultado.getSelectedRow() > 1){
            JOptionPane.showMessageDialog(null,"Por favor, é necessário selecionar uma linha que você deseja atualizar");
        }
    }
    
    public void excluirFilme(JTable tabelaResultado, LinkedHashMap <String, JTextField> mapValoresFiltro){
        int idFilme = 0;
        int resultado = 0;
        
        if(idFilme >= 0 && tabelaResultado.getSelectedRow() != -1){
            idFilme = Integer.parseInt(tabelaResultado.getValueAt(tabelaResultado.getSelectedRow(), 0).toString());
            resultado = this.filmeDao.excluirFilme(idFilme);
            JOptionPane.showMessageDialog(null, "Filmes removidos: " + resultado);
            this.pesquisarValoresFiltrados(mapValoresFiltro);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha");
        }
    }
}
