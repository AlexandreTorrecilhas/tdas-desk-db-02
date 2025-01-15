package com.mycompany.cenaflix.consultarfilme;

//Pacotes do projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
//Pacotes Swing
import javax.swing.JLabel;
import javax.swing.JTextField;
//Pacotes AWT
import java.awt.Dimension;
//Pacotes UTIL
import java.util.LinkedHashMap;

class JPanelFiltros extends AbsJPanelGrid {

    //Configuracao dos JLabel
    private final LinkedHashMap<String, JLabel> mapJLabel = new LinkedHashMap();
    private final String[] textosJLabel = {"Id Filme: ", "Nome Filme", "Categoria: ", "Data de cadastro de: ", "até: "};
    //Configuracao dos campos de filtro
    private LinkedHashMap<String, JTextField> mapCamposFiltro = new LinkedHashMap();
    private final String[] chaveDosFiltros = {"txtId", "txtNomeFilme", "txtCategoria", "txtDataInicio", "txtDataFim"};
    
    public JPanelFiltros(){
        this.setMapJLabel();
        this.setMapCamposFiltro();
        this.addComponentes();
    }

    private void setMapJLabel(){
        for(int controlador = 0; controlador < this.textosJLabel.length; controlador++){
            this.mapJLabel.put(textosJLabel[controlador], this.addJLabel(this.textosJLabel[controlador]));
        }
    }
    
    private void setMapCamposFiltro(){
        for(int controlador = 0; controlador < chaveDosFiltros.length; controlador++){
            this.mapCamposFiltro.put(chaveDosFiltros[controlador], this.addJTextField());
        }
    }

    private void addComponentes(){
        for(int linha = 0; linha < 2; linha++){
            for(int coluna = 0; coluna < this.textosJLabel.length; coluna++){
                this.add(this.mapJLabel.get(this.textosJLabel[coluna]), this.getGridBagConstraints(coluna, linha));
                this.add(this.mapCamposFiltro.get(this.chaveDosFiltros[coluna]), this.getGridBagConstraints(coluna + 1, linha));
            }
        }
    }
    
    private JLabel addJLabel(String texto){
        JLabel jLabel = new JLabel(texto);
        return jLabel;
    }
    
    private JTextField addJTextField(){
        JTextField areaTexto = new JTextField();
        areaTexto.setPreferredSize(new Dimension(20,10));
        areaTexto.setMaximumSize(new Dimension(30,15));
        return areaTexto;
    }
}
