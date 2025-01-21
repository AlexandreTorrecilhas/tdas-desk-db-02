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

/**
 * Controlador para a consulta de filmes.
 * Esta classe gerencia a interação entre a interface de usuário de consulta de filmes e o acesso aos dados.
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public class ConsultaFilmeControlador {

    private final FiltrosPesquisaValidacao validacao = new FiltrosPesquisaValidacao();
    private final ConsultarFilmeDao filmeDao = new ConsultarFilmeDao();
    private JTable tabelaResultado;
    private ResultSetMetaData metaData;
    private ResultSet resultadoQuery;
    private DefaultTableModel modeloTabela;
    private Object[] linha;

    /**
     * Construtor da classe ConsultaFilmeControlador.
     * @param tabelaResultado A tabela Swing que exibirá os resultados da consulta.
     */

    public ConsultaFilmeControlador(JTable tabelaResultado){
        this.tabelaResultado = tabelaResultado;
        this.modeloTabela = (DefaultTableModel) this.tabelaResultado.getModel();
    }

    /**
     * Realiza a pesquisa de filmes com base nos filtros fornecidos.
     * @param mapValoresFiltro Um mapa contendo os valores dos filtros de pesquisa.
     */

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

    /**
     * Atualiza um filme na base de dados com base na linha selecionada na tabela.
     * @param tabelaResultado A tabela Swing contendo os dados dos filmes.
     */

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

    /**
     * Exclui um filme da base de dados com base na linha selecionada na tabela.
     * @param tabelaResultado A tabela Swing contendo os dados dos filmes.
     * @param mapValoresFiltro Um mapa contendo os valores dos filtros de pesquisa (usado para atualizar a tabela após a exclusão).
     */

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
