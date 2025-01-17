package com.mycompany.cenaflix.consultarfilme.dao;

//Pacotes do projeto
import com.mycompany.cenaflix.conexao.Conexao;
import validacoes.FiltrosPesquisaValidacao;
//Pacotes Swing
import javax.swing.JTextField;
//Pacotes Util
import java.util.Map;
import java.util.LinkedHashMap;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import static java.lang.Integer.*;

public class ConsultarFilmeDao {
    //Validacao
    private final FiltrosPesquisaValidacao validacao = new FiltrosPesquisaValidacao();
    //Conexao
    private Connection conexao;
    private PreparedStatement stmt;
    //Comandos SQL
    private final String selectDezPrimeirosFilmes = "SELECT * FROM filmes LIMIT 10";
    private StringBuilder sqlFiltroDinamico = new StringBuilder("SELECT * FROM filmes WHERE 1 = 1 ");
    private final String[] condicoesSql = {"AND id = ? ", "AND nome LIKE ? ", "AND categoria IN (?) ", "AND datalancamento BETWEEN ? AND ?"};
    
    
    public ConsultarFilmeDao(){}

    public ResultSet getDezPrimeirosFilmes(){
        try{
            ResultSet resultadoPesquisa;
            this.iniciarConexao(this.selectDezPrimeirosFilmes);
            resultadoPesquisa = this.stmt.executeQuery();
            return resultadoPesquisa;
        }catch(SQLException erroAoSelecionarValor){
            System.out.println(erroAoSelecionarValor.getMessage());
            return null;
        }

    }
    
    public void pesquisarValoresDinamicos(LinkedHashMap<String, JTextField> mapJTextField){

        int contador = 0;
        for(Map.Entry<String, JTextField> entry: mapJTextField.entrySet()){
            if(!entry.getValue().getText().isBlank()){
                this.sqlFiltroDinamico.append(this.condicoesSql[contador]);
                contador++;
            }
            contador++;
        }

        contador = 0;

        this.iniciarConexao(this.sqlFiltroDinamico.toString());

        //"", "", "", "txtDataInicio", "txtDataFim"
        try{
            if(!mapJTextField.get("txtId").getText().isBlank()){
                this.stmt.setInt(contador, Integer.parseInt(mapJTextField.get("txtId").getText().trim()));
                contador++;
            }
            if(!mapJTextField.get("txtNomeFilme").getText().isBlank()){
                this.stmt.setString(contador, mapJTextField.get("txtNomeFilme").getText().trim());
                contador++;
            }
            if(mapJTextField.get("txtCategoria").getText().isBlank()){
                this.stmt.setString(contador,mapJTextField.get("txtCategoria").getText().trim());
                contador++;
            }

        }catch(SQLException erroAoConstruirConsultaDinamica){
            System.out.println("Classe: ConsutarFilmeDao/Metodo: pesquisarValoresDinamicos " + erroAoConstruirConsultaDinamica.getMessage());
        }
    }

    private void iniciarConexao(String sql){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = this.conexao.prepareStatement(sql);
        }catch(SQLException erroAoConectarBanco){
            System.out.println(erroAoConectarBanco.getMessage());
        }
    }

    public void fecharConexao(){
        try{
            this.conexao.close();
            this.stmt.close();
        }catch(SQLException erroAoFecharConexao){
            System.out.println(erroAoFecharConexao.getMessage());
        }
    }
}
