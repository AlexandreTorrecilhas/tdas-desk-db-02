package com.mycompany.cenaflix.consultarfilme;

//Pacotes do projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swingimport
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
//Pacotes AWT
import java.awt.Dimension;
//Pacotes UTIL
import java.util.LinkedHashMap;

class JPanelFiltros extends AbsJPanelGrid {
    
    private JRadioButtonMenuItem grupoRadioBotao = new JRadioButtonMenuItem();
    //Configuracao dos campos de filtro
    private LinkedHashMap<String, JTextField> mapCamposFiltro = new LinkedHashMap();
    private String[] chaveDosFiltros = {"txtId", "txtNomeFilme", "txtCategoria", "txtDataInicio", "txtDataFim"};
    
    public JPanelFiltros(){}
    
    private void setMapCamposFiltro(){
        for(int controlador = 0; controlador < chaveDosFiltros.length; controlador++){
        
        }
    }
    
    private JLabel addJLabel(String texto){
        JLabel jLabel = new JLabel(texto);
        return jLabel;
    }
    
    private JTextField addJTextField(){
        JTextField areaTexto = new JTextField();
        return areaTexto;
    }
    
    private JRadioButton addJRadioButton(String texto){
        JRadioButton radioBotao = new JRadioButton(texto);
        return radioBotao;
    }
    
    private JButton addJButton(String texto){
        JButton novoBotao = new JButton(texto);
        novoBotao.setPreferredSize(new Dimension(30,20));
        novoBotao.setMaximumSize(new Dimension(50,20));
        return novoBotao;
    }
    
}
