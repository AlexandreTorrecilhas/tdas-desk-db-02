package com.mycompany.cenaflix.conexao;

//PAcotes Swing
import javax.swing.JOptionPane;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável por estabelecer a conexão com o banco de dados.
 * Esta classe utiliza o driver JDBC do MySQL para conectar-se ao banco de dados "cenaflix".
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public class Conexao {
    private final String url = "jdbc:mysql://localhost:3306/cenaflix";
    private final String user = "mestre";
    private final String password = "mudar@123";
    private Connection conexao;

    /**
     * Construtor da classe Conexao.
     * Este construtor é vazio, pois a conexão é estabelecida sob demanda no método {@link #getConexao()}.
     */

    public Conexao(){
    }

    /**
     * Estabelece e retorna uma conexão com o banco de dados.
     * @return Um objeto {@link Connection} representando a conexão com o banco de dados,
     *         ou {@code null} se a conexão não puder ser estabelecida.
     */

    public Connection getConexao(){
        try{
            this.conexao = DriverManager.getConnection(url, user, password);
            return this.conexao;
        }catch(SQLException erroAoConectarBanco){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
            System.out.println(erroAoConectarBanco.getMessage());
            return null;
        }
    }
    
}
