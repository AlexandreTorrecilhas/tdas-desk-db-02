package com.mycompany.cenaflix.limparformulario;

//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes Util
import java.util.LinkedHashMap;

public class LimparFormulario {
    
    private JButton btnLimpar;
    
    public LimparFormulario(JButton btnLimpar){
        this.btnLimpar = btnLimpar;
    }
    
    public void limparFormulario(LinkedHashMap<String, JTextField> txtCampos){
        JTextField[] campos = txtCampos.values().toArray(new JTextField[0]);
        for(int contador = 0;contador < txtCampos.values().toArray().length; contador++){
            System.out.println(contador);            
        }
    }    
}
