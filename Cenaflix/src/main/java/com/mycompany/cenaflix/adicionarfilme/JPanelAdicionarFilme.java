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

    public JPanelAdicionarFilme(){
        super();
        this.setElementosMapJLabel();
        this.setElementosMapJTextField();
        this.setElementosMapJButton();
        this.adicionarElementosJPanel();
        this.controlador = new InserirFilmeControlador(this.mapJTextField, this.mapJButtons);
    }

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

    private JButton addJButton(int largura, int altura, String texto){
        JButton novoBotao = new JButton(texto);
        Dimension tamanho = new Dimension(largura, altura);
        novoBotao.setPreferredSize(tamanho);
        novoBotao.setMaximumSize(new Dimension(50,50));
        return novoBotao;
    }
    
    private JTextField addJTextField(int largura, int altura){
        Dimension tamanho = new Dimension(largura, altura);
        JTextField campoTexto = new JTextField();
        campoTexto.setPreferredSize(tamanho);
        campoTexto.setMaximumSize(tamanho);
        return campoTexto;
    }

    private void setElementosMapJLabel(){
        this.mapJLabel.put("lblNome", new JLabel("Nome do Filme: "));
        this.mapJLabel.put("lblDataLancamento", new JLabel("Data de Lançamento: "));
        this.mapJLabel.put("lblGenero", new JLabel("Genero: "));
    }

    private void setElementosMapJTextField(){
        this.mapJTextField.put("txtNomeFilme", addJTextField(200,20));
        this.mapJTextField.put("txtDataLancamento", addJTextField(50,20));
        this.mapJTextField.put("txtCategoria", addJTextField(200,20));

    }

    private void setElementosMapJButton(){
        this.mapJButtons.put("btnCadastrarFilme", addJButton(30,30,"Cadastrar"));
        this.mapJButtons.put("btnLimparCampos", addJButton(30,30,"Limpar Campos"));
    }
    
    public LinkedHashMap getMapJTextField(){
        return this.mapJTextField;
    }
}
