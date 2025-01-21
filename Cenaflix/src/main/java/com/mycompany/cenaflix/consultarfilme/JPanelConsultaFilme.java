package com.mycompany.cenaflix.consultarfilme;

//Paxotes do Projeto
import com.mycompany.cenaflix.consultarfilme.controlador.ConsultaFilmeControlador;
//Pacotes Swing
import javax.swing.JPanel;
import javax.swing.JButton;
//Pacotes Util
import java.util.LinkedHashMap;
//Pacotes AWT
import java.awt.BorderLayout;

/**
 * Painel principal para a consulta de filmes.
 * Este painel organiza os demais painéis utilizados para filtrar, exibir e manipular os filmes.
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public class JPanelConsultaFilme extends JPanel{

    private final JPanelFiltros jPanelFiltros = new JPanelFiltros();
    private final JPanelTabela jPanelTabela = new JPanelTabela();
    private final JPanelMenuBotoes jPanelMenuBotoes = new JPanelMenuBotoes();
    private final ConsultaFilmeControlador controlador = new ConsultaFilmeControlador(this.jPanelTabela.getTabelaResultado());
    private final LinkedHashMap<String, JButton> mapBotoesPesquisar = this.jPanelMenuBotoes.getMapBotoes();

    public JPanelConsultaFilme(){
        this.setLayout(new BorderLayout());

        // Adiciona os painéis ao layout
        this.add(this.jPanelFiltros, BorderLayout.NORTH);
        this.add(this.jPanelTabela, BorderLayout.CENTER);
        this.add(this.jPanelMenuBotoes, BorderLayout.SOUTH);
        this.addActionListener();
    }

    
    private void addActionListener(){
        this.mapBotoesPesquisar.get("btnPesquisar").addActionListener(e ->{
            this.controlador.pesquisarValoresFiltrados(this.jPanelFiltros.getMapCamposFiltro());
        });

        this.mapBotoesPesquisar.get("btnAtualizar").addActionListener(e -> {
           this.controlador.atualizarFilme(this.jPanelTabela.getTabelaResultado());
        });
        
        this.mapBotoesPesquisar.get("btnExcluirFilme").addActionListener(e -> {
            this.controlador.excluirFilme(this.jPanelTabela.getTabelaResultado(), this.jPanelFiltros.getMapCamposFiltro());
        });
    }
    
    public JPanelFiltros getjPanelFiltros() {
        return jPanelFiltros;
    }

    public JPanelTabela getjPanelTabela() {
        return jPanelTabela;
    }

    public JPanelMenuBotoes getjPanelMenuBotoes() {
        return jPanelMenuBotoes;
    }
}
