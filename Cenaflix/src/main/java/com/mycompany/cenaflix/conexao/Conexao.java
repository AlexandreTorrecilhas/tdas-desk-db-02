package com.mycompany.cenaflix.conexao;

//PAcotes Swing
import javax.swing.JOptionPane;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private final String url = "jdbc:mysql://localhost:3306/cenaflix";
    private final String user = "mestre";
    private final String password = "mudar@123";
    private Connection conexao;
    
    public Conexao(){
    }
    
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
