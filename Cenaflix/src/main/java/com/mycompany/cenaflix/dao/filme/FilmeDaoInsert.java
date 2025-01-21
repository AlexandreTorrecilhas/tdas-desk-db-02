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

/**
 * DAO para inserção de filmes no banco de dados.
 * Esta classe provê métodos para inserir novos filmes.
 *
 * @author (Carlos Alexandre)
 * @version 1.0
 * @since 1.0
 */

public class FilmeDaoInsert {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private int linhasAlteradas;
    private final String inserirFilmeSql = "INSERT INTO filmes(nome, datalancamento, categoria) "
            + "VALUES(?,?,?);";

    /**
     * Construtor padrão.
     */

    public FilmeDaoInsert(){}

    /**
     * Insere um novo filme no banco de dados.
     *
     * @param filme O modelo do filme a ser inserido.
     * @throws SQLException Lançada caso ocorra uma exceção de SQL.
     * @throws DateTimeParseException Lançada caso haja erro ao converter a data de lançamento do formato String para LocalDate.
     */

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

    /**
     * Abre a conexão com o banco de dados.
     *
     * @throws SQLException Lançada caso ocorra uma exceção de SQL.
     */
    
    private void abrirConexao(){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = conexao.prepareStatement(this.inserirFilmeSql);
        }catch(SQLException erroAoInserirFilme){
            System.out.println(erroAoInserirFilme.getMessage());
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @throws SQLException Lançada caso ocorra uma exceção de SQL.
     */

    private void fecharConexao(){
        try{
            this.conexao.close();
            this.stmt.close();
        }catch(SQLException erroAoFecharConexao){
            System.out.println(erroAoFecharConexao.getMessage());
        }
    }
    
}
