package com.mycompany.cenaflix.dao.filme;

//Pacotes do Projeto
import com.mycompany.cenaflix.conexao.Conexao;
import com.mycompany.cenaflix.modelos.FilmeModelo;
//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Pacotes SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
//Pacotes UTIL
//Pacotes Time
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class FilmeDaoInsert {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private int linhasAlteradas;
    private final String inserirFilmeSql = "INSERT INTO filmes(nome, datalancamento, categoria) "
            + "VALUES(?,?,?);";
    
    public FilmeDaoInsert(){}
    
    public void inserirFilme(FilmeModelo filme){
        try{
            this.abrirConexao();
            this.stmt.setString(1, filme.nome());
            this.stmt.setDate(2, Date.valueOf(LocalDate.parse(filme.dataLancamento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            this.stmt.setString(3, filme.categoria());
            this.linhasAlteradas = this.stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Valor inserido. Quantidade de linhas inseridas: " + this.linhasAlteradas);
            this.fecharConexao();
        }catch(SQLException | DateTimeParseException erroAoInserirValor){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o valor, por favor, verifique a conexão com o banco de dados");
            System.out.println(erroAoInserirValor.getMessage());
            this.fecharConexao();
        }
    }
    
    private void abrirConexao(){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = conexao.prepareStatement(this.inserirFilmeSql);
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
