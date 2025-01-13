package com.mycompany.cenaflix.adicionarfilme;

//Pacotes do Projeto
import com.mycompany.cenaflix.dao.filme.FilmeDaoInsert;
import validacoes.CriarFilmeValidacao;
    //Modelos
    import com.mycompany.cenaflix.modelos.FilmeModelo;
//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes Util;
import java.util.LinkedHashMap;

public class InserirFilmeControlador {
    
    private FilmeDaoInsert filmeDaoInsert = new FilmeDaoInsert();
    private LinkedHashMap<String, JTextField> mapJTextField; 
    private LinkedHashMap<String, JButton> mapBotoes;
    private CriarFilmeValidacao validacao;
    private FilmeDaoInsert filmeDao = new FilmeDaoInsert();
    private FilmeModelo filme;
    
    public InserirFilmeControlador(LinkedHashMap<String, JTextField> mapJTextField, LinkedHashMap<String, JButton> mapBotoes){
        this.mapBotoes = mapBotoes;
        this.mapJTextField = mapJTextField;
        this.validacao = new CriarFilmeValidacao(this.mapJTextField);
        this.btnActionListener();
    }
    
    public void btnActionListener(){
        this.mapBotoes.get("btnCadastrarFilme").addActionListener(e -> {
            if(this.validacao.verificarValores()){
                this.filme = new FilmeModelo(this.mapJTextField.get("txtNomeFilme").getText(), this.mapJTextField.get("txtDataLancamento").getText(), this.mapJTextField.get("txtCategoria").getText());
                this.filmeDao.inserirFilme(filme);
            }
        });
    }
}
