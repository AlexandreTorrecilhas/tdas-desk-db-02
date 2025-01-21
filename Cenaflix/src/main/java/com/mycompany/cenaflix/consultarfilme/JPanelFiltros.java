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

/**
 * Painel para os filtros de consulta de filmes.
 * Este painel contém os campos de texto e rótulos para os filtros de pesquisa de filmes.
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

class JPanelFiltros extends AbsJPanelGrid {

    //Configuracao dos JLabel
    private final LinkedHashMap<String, JLabel> mapJLabel = new LinkedHashMap();
    private final String[] textosJLabel = {"Id Filme: ", "Nome Filme", "Categoria: ", "Data de cadastro de: ", "até: "};
    private final Integer[] posicoesJLabel = {0,2,4,6,8};
    //Configuracao dos campos de filtro
    private LinkedHashMap<String, JTextField> mapCamposFiltro = new LinkedHashMap();
    private final String[] chaveDosFiltros = {"txtId", "txtNomeFilme", "txtCategoria", "txtDataInicio", "txtDataFim"};

    /**
     * Construtor do JPanelFiltros.
     * Inicializa os rótulos, campos de filtro e adiciona os componentes ao painel.
     */

    public JPanelFiltros(){
        this.setMapJLabel();
        this.setMapCamposFiltro();
        this.addComponentes();
    }

    /**
     * Cria e armazena os JLabels no mapa.
     */

    private void setMapJLabel(){
        for(int controlador = 0; controlador < this.textosJLabel.length; controlador++){
            this.mapJLabel.put(textosJLabel[controlador], this.addJLabel(this.textosJLabel[controlador]));
        }
    }

    /**
     * Cria e armazena os JTextFields no mapa.
     */

    private void setMapCamposFiltro(){
        for(int controlador = 0; controlador < chaveDosFiltros.length; controlador++){
            this.mapCamposFiltro.put(chaveDosFiltros[controlador], this.addJTextField());
        }
    }

    /**
     * Adiciona os JLabels e JTextFields ao painel, utilizando o layout GridBagLayout.
     */

    private void addComponentes(){
        for(int linha = 0; linha < 1; linha++){
            for(int coluna = 0; coluna < this.textosJLabel.length; coluna++){
                this.add(this.mapJLabel.get(this.textosJLabel[coluna]), this.getGridBagConstraintsIpa(this.posicoesJLabel[coluna], linha));
                this.add(this.mapCamposFiltro.get(this.chaveDosFiltros[coluna]), this.getGridBagConstraintsIpa((this.posicoesJLabel[coluna] + 1), linha));
            }
        }
    }

    /**
     * Cria um novo JLabel com o texto especificado.
     * @param texto O texto do JLabel.
     * @return O JLabel criado.
     */
    
    private JLabel addJLabel(String texto){
        JLabel jLabel = new JLabel(texto);
        return jLabel;
    }

    /**
     * Cria um novo JTextField com as dimensões predefinidas.
     * @return O JTextField criado.
     */
    
    private JTextField addJTextField(){
        JTextField areaTexto = new JTextField();
        areaTexto.setPreferredSize(new Dimension(80,20));
        areaTexto.setMaximumSize(new Dimension(100,30));
        return areaTexto;
    }

    /**
     * Retorna o mapa de campos de filtro (JTextFields).
     * @return O mapa de campos de filtro.
     */

    public LinkedHashMap<String, JTextField> getMapCamposFiltro() {
        return mapCamposFiltro;
    }
}
