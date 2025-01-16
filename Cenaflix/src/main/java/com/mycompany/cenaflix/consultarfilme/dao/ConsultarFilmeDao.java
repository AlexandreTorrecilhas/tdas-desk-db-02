package com.mycompany.cenaflix.consultarfilme.dao;

//Pacotes do projeto
import com.mycompany.cenaflix.conexao.Conexao;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultarFilmeDao {
    //Conexao
    private Connection conexao;
    private PreparedStatement stmt;
    //Comandos SQL
    private final String selectDezPrimeirosFilmes = "SELECT * FROM filmes LIMIT 10";

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
