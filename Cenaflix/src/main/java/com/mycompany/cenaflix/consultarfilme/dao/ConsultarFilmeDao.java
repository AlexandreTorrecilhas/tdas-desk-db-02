package com.mycompany.cenaflix.consultarfilme.dao;

//Pacotes do projeto
import com.mycompany.cenaflix.conexao.Conexao;
import validacoes.FiltrosPesquisaValidacao;
//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//Pacotes Util
import java.util.Map;
import java.util.LinkedHashMap;
//Pacots Time
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
//Pacotes SQL
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 * DAO (Data Access Object) para a consulta de filmes.
 * Esta classe é responsável por acessar o banco de dados para realizar consultas e operações relacionadas a filmes.
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public class ConsultarFilmeDao {
    //Validacao
    private final FiltrosPesquisaValidacao validacao = new FiltrosPesquisaValidacao();
    //Conexao
    private Connection conexao;
    private PreparedStatement stmt;
    //Comandos SQL
    private final String selectDezPrimeirosFilmes = "SELECT * FROM filmes LIMIT 10";
    private StringBuilder sqlFiltroDinamico = new StringBuilder("SELECT * FROM filmes WHERE 1 = 1 ");
    private final String[] condicoesSql = {"AND id = ? ", "AND nome = ? ", "AND categoria IN (?) ", "AND datalancamento BETWEEN ? ", "AND ?"};
    private final String sqlAtualizarValores = "UPDATE filmes SET nome = ?, datalancamento = ?, categoria = ? WHERE id = ?";
    private final String sqlRemoverValores = "DELETE FROM filmes WHERE id = ?";
    private DefaultTableModel modeloTabela;
    //Objetos SQL
    Object[] resultadoConsulta;
    
    /**
     *
     */
    public ConsultarFilmeDao(){}

    /**
     * Inicia uma conexão com o banco de dados para o statement especificado.
     * @param sql A consulta SQL a ser executada.
     * @throws SQLException Lançada caso ocorra uma exceção de SQL.
     */

    private void iniciarConexao(String sql){
        try{
            this.conexao = new Conexao().getConexao();
            this.stmt = this.conexao.prepareStatement(sql);
        }catch(SQLException erroAoConectarBanco){
            System.out.println(erroAoConectarBanco.getMessage());
        }
    }

    /**
     * Fecha a conexão com o banco de dados e o statement.
     */

    public void fecharConexao(){
        try{
            this.conexao.close();
            this.stmt.close();
        }catch(SQLException erroAoFecharConexao){
            System.out.println(erroAoFecharConexao.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
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
    
    /**
     *
     * @param mapJTextField
     * @return
     */
    public ResultSet pesquisarValoresDinamicos(LinkedHashMap<String, JTextField> mapJTextField){

        int contador = 0;
        ResultSet resultadoQuery = null;
        
        for(Map.Entry<String, JTextField> entry: mapJTextField.entrySet()){
            if(!entry.getValue().getText().isBlank()){
                this.sqlFiltroDinamico.append(this.condicoesSql[contador]);
                contador++;
            }
            else{
                contador++;
            }
        }

        //O contador aqui deve ser pois ele configura
        //a posicao das fincoes set to objeto stmt
        contador = 1;

        this.iniciarConexao(this.sqlFiltroDinamico.toString());

        try{
            if(!mapJTextField.get("txtId").getText().isBlank()){
                this.stmt.setInt(contador, Integer.parseInt(mapJTextField.get("txtId").getText().trim()));
                contador++;
            }
            if(!mapJTextField.get("txtNomeFilme").getText().isBlank()){
                this.stmt.setString(contador, mapJTextField.get("txtNomeFilme").getText().trim());
                contador++;
            }
            if(!mapJTextField.get("txtCategoria").getText().isBlank()){
                this.stmt.setString(contador,mapJTextField.get("txtCategoria").getText().trim());
                contador++;
            }
            if(!mapJTextField.get("txtDataInicio").getText().isBlank()){
                this.stmt.setDate(contador, Date.valueOf(LocalDate.parse(mapJTextField.get("txtDataInicio").getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                contador++;
            }
            if(!mapJTextField.get("txtDataFim").getText().isBlank()){
                this.stmt.setDate(contador, Date.valueOf(LocalDate.parse(mapJTextField.get("txtDataFim").getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            }
            
            System.out.println(this.stmt.toString());

            resultadoQuery = this.stmt.executeQuery();
            return resultadoQuery;

        }catch(SQLException | DateTimeParseException erroAoConstruirConsultaDinamica){
            System.out.println("Classe: ConsutarFilmeDao/Metodo: pesquisarValoresDinamicos " + erroAoConstruirConsultaDinamica.getMessage());
            return null;
        }finally{
            this.setSqlFiltroDinamico();
        }
    }
    
    /**
     *
     * @param resultadoConsulta
     * @return
     */
    public int atualizarValores(Object resultadoConsulta[]){
        int valoresAtualizados = 0;

        try{
            //UPDATE filmes SET nome = ?, datalancamento = ?, categoria = ? WHERE id = ?
            this.iniciarConexao(this.sqlAtualizarValores);
            System.out.println(resultadoConsulta[0].toString());
            this.stmt.setString(1, resultadoConsulta[1].toString());
            System.out.println(resultadoConsulta[1].toString());
            this.stmt.setDate(2, Date.valueOf(resultadoConsulta[2].toString()));
            this.stmt.setString(3, resultadoConsulta[3].toString());
            this.stmt.setInt(4, Integer.parseInt(resultadoConsulta[0].toString()));
            System.out.println(this.sqlAtualizarValores);
            valoresAtualizados = this.stmt.executeUpdate();

            return valoresAtualizados;
        }catch(SQLException | DateTimeParseException erroAoAtualizarValores){
            System.out.println("Classe: ConsultarFilmeDao/Método: atualizarValores/Erro: " + erroAoAtualizarValores.getMessage());
            return 0;
        }
    }
    
    /**
     *
     * @param idFilme
     * @return
     */
    public int excluirFilme(int idFilme){
        
        int valoresAtualizados = 0;
        
        try{
            this.iniciarConexao(this.sqlRemoverValores);
            this.stmt.setInt(1, idFilme);
            valoresAtualizados = this.stmt.executeUpdate();
            return valoresAtualizados;
        }catch(SQLException erroAoExcluirValor){
            System.out.println("Classe: ConsultaFilmeDao/Método:excluirFilme/Erro: " + erroAoExcluirValor.getMessage());
            return 0;
        }
        
    }
    
    /**
     *
     */
    public void setSqlFiltroDinamico(){
        this.sqlFiltroDinamico = new StringBuilder("SELECT * FROM filmes WHERE 1 = 1 ");
    }
}
