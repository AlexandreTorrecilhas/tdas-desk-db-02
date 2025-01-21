package com.mycompany.cenaflix.adicionarfilme;

//Pacotes do Projeto
import com.mycompany.cenaflix.dao.filme.FilmeDaoInsert;
import validacoes.CriarFilmeValidacao;
import com.mycompany.cenaflix.limparformulario.LimparFormulario;
    //Modelos
    import com.mycompany.cenaflix.modelos.FilmeModelo;
//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes Util;
import java.util.LinkedHashMap;

/**
* @author Carlos Alexandre
* @version 1.0
* Objetivo: Ser uma intermediadora entre o FilmeDaoInsert e a class JPanelAcionarFilme
* @see com.mycompany.cenaflix.dao.filme.FilmeDaoInsert
* @see com.mycompany.cenaflix.adicionarfilme.InserirFilmeControlador
* @see com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme
* Descrição: Essa classe realiza pega os valores e cria os objetos que são necessários para a classe FilmeDaoInsert
* realizar as operações CRUD
*/

public class InserirFilmeControlador {
    
    private FilmeDaoInsert filmeDaoInsert = new FilmeDaoInsert();
    private LinkedHashMap<String, JTextField> mapJTextField; 
    private LinkedHashMap<String, JButton> mapBotoes;
    private CriarFilmeValidacao validacao;
    private FilmeDaoInsert filmeDao = new FilmeDaoInsert();
    private FilmeModelo filme;
    private LimparFormulario limparFormulario;

    /**
     * Construtor da classe InserirFilmeControlador.
     * @param mapJTextField Mapa contendo os componentes JTextField do JPanelAdicionarFilme
     *                      onde o usuário informa os dados dos filmes. A chave do mapa é o nome do campo.
     * @param mapBotoes Mapa contendo os botões do JPanelAdicionarFilme. Usado principalmente
     *                  para adicionar os actionListeners. A chave do mapa é o nome do botão.
     * @see com.mycompany.cenaflix.adicionarfilme.JPanelAdicionarFilme
     */

    public InserirFilmeControlador(LinkedHashMap<String, JTextField> mapJTextField, LinkedHashMap<String, JButton> mapBotoes){
        this.mapBotoes = mapBotoes;
        this.mapJTextField = mapJTextField;
        this.validacao = new CriarFilmeValidacao(this.mapJTextField);
        this.btnActionListener();
        this.btnLimparFormulario();
        this.setLimparFormulario();
    }

    /**
     * Configura o objeto LimparFormulario.
     * @see com.mycompany.cenaflix.limparformulario.LimparFormulario
     */
    
    private void setLimparFormulario(){
        this.limparFormulario = new LimparFormulario(this.mapBotoes.get("btnLimparCampos"));
    }

    /**
     * Adiciona um ActionListener ao botão de cadastro. Ao clicar no botão, a função
     * para inserir o filme dentro do banco de dados é ativada.
     */

    public void btnActionListener(){
        this.mapBotoes.get("btnCadastrarFilme").addActionListener(e -> {
            if(this.validacao.verificarValores()){
                this.filme = new FilmeModelo(this.mapJTextField.get("txtNomeFilme").getText().trim(), this.mapJTextField.get("txtDataLancamento").getText().trim(), this.mapJTextField.get("txtCategoria").getText().trim());
                this.filmeDao.inserirFilme(filme);
            }
        });
    }

    /**
     * Adiciona um ActionListener ao botão de limpar formulário.
     */

    public void btnLimparFormulario(){
        this.mapBotoes.get("btnLimparCampos").addActionListener(e -> {
            this.limparFormulario.limparFormulario(this.mapJTextField);
        });
    }
}
