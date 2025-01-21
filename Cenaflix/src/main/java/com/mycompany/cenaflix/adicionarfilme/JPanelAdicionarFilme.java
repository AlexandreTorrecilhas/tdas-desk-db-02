package com.mycompany.cenaflix.adicionarfilme;

//Pacotes do Projeto
import com.mycompany.cenaflix.absjpanel.AbsJPanelGrid;
    //Pacotes Dao
    import com.mycompany.cenaflix.dao.filme.FilmeDaoInsert;
//Pacotes Swing 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
//Pacotes AWT
import java.awt.Dimension;
//Pacotes util
import java.util.LinkedHashMap;

/**
 * Painel para adicionar filmes.
 * Esta classe representa um painel Swing que permite a inserção de novos filmes no sistema.
 * Ela utiliza um layout Grid para organizar os componentes.
 * @author Carlos Alexandre
 * @version 1.0
 * @since 1.0
 */

public class JPanelAdicionarFilme extends AbsJPanelGrid {
    
    //JLabels
    private LinkedHashMap<String, JLabel> mapJLabel = new LinkedHashMap();
    //JTextFields
    private LinkedHashMap<String, JTextField> mapJTextField = new LinkedHashMap();
    //JButtons
    private LinkedHashMap<String, JButton> mapJButtons = new LinkedHashMap();
    //Arrays que servirão como chaves para os loops nos maps
    private final String[] arrLblJLabel = {"lblNome", "lblDataLancamento", "lblGenero"};
    private final String[] arrTxtJTextField = {"txtNomeFilme", "txtDataLancamento", "txtCategoria"};
    private InserirFilmeControlador controlador;

    /**
     * Construtor do JPanelAdicionarFilme.
     * Inicializa os componentes do painel, configura o layout e cria o controlador.
     */

    public JPanelAdicionarFilme(){
        super();
        this.setElementosMapJLabel();
        this.setElementosMapJTextField();
        this.setElementosMapJButton();
        this.adicionarElementosJPanel();
        this.controlador = new InserirFilmeControlador(this.mapJTextField, this.mapJButtons);
    }

    /**
     * Adiciona os elementos (labels e text fields) ao painel, utilizando um layout em grade.
     */

    private void adicionarElementosJPanel(){
        for(int linha = 0; linha <= 2; linha++ ){
            for(int coluna = 0; coluna <= 1; coluna++){
                this.add(this.mapJLabel.get(this.arrLblJLabel[linha]), this.getGridBagConstraintsIpa(coluna, linha));
                this.add(this.mapJTextField.get(this.arrTxtJTextField[linha]), this.getGridBagConstraintsIpa(coluna + 1, linha));
            }
        }
        
        this.add(this.mapJButtons.get("btnCadastrarFilme"), this.getGridBagConstraintsIpa(1, 3));
        this.add(this.mapJButtons.get("btnLimparCampos"), this.getGridBagConstraintsIpa(2,3));
    }

    /**
     * Cria um novo JButton com as dimensões e texto especificados.
     * @param largura A largura do botão.
     * @param altura A altura do botão.
     * @param texto O texto do botão.
     * @return O JButton criado.
     */

    private JButton addJButton(int largura, int altura, String texto){
        JButton novoBotao = new JButton(texto);
        Dimension tamanho = new Dimension(largura, altura);
        novoBotao.setPreferredSize(tamanho);
        novoBotao.setMaximumSize(new Dimension(50,50));
        return novoBotao;
    }

    /**
     * Cria um novo JTextField com as dimensões especificadas.
     * @param largura A largura do campo de texto.
     * @param altura A altura do campo de texto.
     * @return O JTextField criado.
     */

    private JTextField addJTextField(int largura, int altura){
        Dimension tamanho = new Dimension(largura, altura);
        JTextField campoTexto = new JTextField();
        campoTexto.setPreferredSize(tamanho);
        campoTexto.setMaximumSize(tamanho);
        return campoTexto;
    }

    /**
     * Inicializa o mapa de JLabels.
     */

    private void setElementosMapJLabel(){
        this.mapJLabel.put("lblNome", new JLabel("Nome do Filme: "));
        this.mapJLabel.put("lblDataLancamento", new JLabel("Data de Lançamento: "));
        this.mapJLabel.put("lblGenero", new JLabel("Genero: "));
    }

    /**
     * Inicializa o mapa de JTextFields.
     */

    private void setElementosMapJTextField(){
        this.mapJTextField.put("txtNomeFilme", addJTextField(200,20));
        this.mapJTextField.put("txtDataLancamento", addJTextField(50,20));
        this.mapJTextField.put("txtCategoria", addJTextField(200,20));

    }

    /**
     * Inicializa o mapa de JButtons.
     */

    private void setElementosMapJButton(){
        this.mapJButtons.put("btnCadastrarFilme", addJButton(30,30,"Cadastrar"));
        this.mapJButtons.put("btnLimparCampos", addJButton(30,30,"Limpar Campos"));
    }

    /**
     * Retorna o mapa de JTextFields.
     * @return O mapa de JTextFields.
     */
    
    public LinkedHashMap getMapJTextField(){
        return this.mapJTextField;
    }
}
