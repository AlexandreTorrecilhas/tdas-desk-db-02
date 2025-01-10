package com.mycompany.cenaflix.dao.filme;

//Pacotes do Projeto
import com.mycompany.cenaflix.conexao.Conexao;
//Pacotes Swing
import javax.swing.JTextField;
//Pacotes SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
//Pacotes UTIL
import java.util.LinkedHashMap;
//Pacotes Time
import java.time.LocalDate;

public class FilmeDaoInsert {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private final String sql = "INSERT INTO filmes(nome, datalancamento, categoria) "
            + "VALUES(?,?,?);";
    
    public FilmeDaoInsert(){}
    
    public void inserirFilme(LinkedHashMap<String, JTextField> parametros, LocalDate dataLancamento){
        try{
            this.abrirConexao();
            this.stmt.setString(1, parametros.get("txtNomeFilme").getText());
            this.stmt.setDate(2, Date.valueOf(dataLancamento));
            this.stmt.setString(3, parametros.get("categoria").getText());
        }catch(SQLException erroAoInserirValor){
            System.out.println(erroAoInserirValor.getMessage());
        }
    }
    
    private void abrirConexao(){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = conexao.prepareStatement(this.sql);
        }catch(SQLException erroAoInserirFilme){
            System.out.println(erroAoInserirFilme.getMessage());
        }
    }
    
    private void fecharConexao(){
        try{
            this.conexao.close();
            this.stmt.close();
        }catch(SQLException erroAoFecharConexao){
            System.out.println(erroAoFecharConexao.getMessage());
        }
    }
    
}
