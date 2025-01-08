package com.mycompany.cenaflix.adicionarfilme;

//Pacotes Swing 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes AWT
import java.awt.Dimension;

public class JPanelAdicionarFilme {
    
    //JLabels
    JLabel lblNome = new JLabel("Nome do Filme: ");
    JLabel lblDataLancamento = new JLabel("Data de Lançamento: ");
    JLabel lblGenero = new JLabel("Gnero: ");
    //JTextFields
    JTextField nomeFilme = addJTextField(100,20);
    JTextField dataLancamento = addJTextField(50,20);
    JTextField genero = addJTextField(100,20);
    //JButtons
    JButton btnCadastrarFilme = addJButton(30,30,"Cadastrar Filme");
    
    private JButton addJButton(int largura, int altura, String texto){
        JButton novoBotao = new JButton();
        Dimension tamanho = new Dimension(largura, altura);
        novoBotao.setSize(tamanho);
        return novoBotao;
    }
    
    private JTextField addJTextField(int largura, int altura){
        Dimension tamanho = new Dimension(largura, altura);
        JTextField campoTexto = new JTextField();
        campoTexto.setSize(tamanho);
        return campoTexto;
    }
    
}
