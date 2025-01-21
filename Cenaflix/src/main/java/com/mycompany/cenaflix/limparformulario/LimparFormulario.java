package com.mycompany.cenaflix.limparformulario;

//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes Util
import java.util.LinkedHashMap;

/**
 * Classe utilitária para limpar formulários.
 * Esta classe fornece um método para limpar os campos de texto de um formulário Swing.
 *
 * @author (Carlos Alexandre)
 * @version 1.0
 * @since 1.0
 */

public class LimparFormulario {
    
    private JButton btnLimpar;

    /**
     * Construtor da classe LimparFormulario.
     *
     * @param btnLimpar O botão que aciona a limpeza do formulário. (Este parâmetro não está sendo usado no método limparFormulario, pode ser removido ou usado para adicionar um ActionListener dentro da classe).
     */

    public LimparFormulario(JButton btnLimpar){
        this.btnLimpar = btnLimpar;
    }

    /**
     * Limpa os campos de texto especificados no mapa.
     *
     * @param txtCampos Um mapa contendo os campos de texto a serem limpos, onde a chave é o nome do campo e o valor é o componente JTextField.
     */

    public void limparFormulario(LinkedHashMap<String, JTextField> txtCampos){
        JTextField[] campos = txtCampos.values().toArray(new JTextField[0]);
        for(int contador = 0;contador < txtCampos.values().toArray().length; contador++){
            System.out.println(contador);            
        }
    }    
}
