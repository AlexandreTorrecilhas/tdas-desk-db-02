package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.posicaotela.Coordenadas;
//Pacotes Swing
import javax.swing.*;
//Pacotes AWT
import java.awt.Dimension;
//Pacotes Util
import java.util.LinkedHashMap;

/**
 * Janela principal da aplicação Cenaflix.
 * Esta classe representa a janela principal da aplicação, contendo o menu de navegação e os painéis de conteúdo.
 *
 * @author (Carlos Alexandre)
 * @version 1.0
 * @since 1.0
 */

public class JFrameMenuPrincipal extends JFrame {
    //JPanels
    JPanelMenuPrincipal jPanelMenuPrincipal = new JPanelMenuPrincipal();
    BotaoNavegacaoControlador controlador = new BotaoNavegacaoControlador(jPanelMenuPrincipal.getjPanelContainerCardLayout());
    //Variáveis dessa classe
    Dimension tamanhoJFrame = new Dimension(900,500);
    Integer[] coordenadas = new Coordenadas(this.tamanhoJFrame).getCoordenadas();
    LinkedHashMap<String, JButton> mapJButton = new LinkedHashMap();

    /**
     * Construtor do JFrameMenuPrincipal.
     * Inicializa a janela, configura os componentes, mapeia os botões e adiciona os listeners de ação.
     */

    public JFrameMenuPrincipal(){
        this.setConfiguracoes();
        this.addComponentes();
        this.setMapJButton();
        this.addActionListener();
        this.teste();
    }

    /**
     * Configura as propriedades da janela principal (tamanho, localização, operação de fechamento).
     */

    private void setConfiguracoes(){
        this.setSize(tamanhoJFrame);
        this.setLocation(coordenadas[1],coordenadas[0]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Adiciona os componentes à janela principal.
     */

    private void addComponentes(){
        this.add(jPanelMenuPrincipal);
    }

    /**
     * Mapeia os botões do menu de navegação para o mapa `mapJButton`.
     */

    private void setMapJButton(){
        this.mapJButton.put("btnAdicionarFilme", this.jPanelMenuPrincipal.getJPanelMenuNavegacao().getBtnAdicionarFilme());
        this.mapJButton.put("btnConsultarFilme", this.jPanelMenuPrincipal.getJPanelMenuNavegacao().getBtnConsultarFilme());
    }

    /**
     * Adiciona os listeners de ação aos botões do menu.
     */

    private void addActionListener(){
        mapJButton.get("btnAdicionarFilme").addActionListener(e ->{
            controlador.abrirTelaInserirFilme();
        });

    }

    private void teste(){
        mapJButton.get("btnConsultarFilme").addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "<html>Para alterar um valor: " +
                    "<br>1) Edite o valor da Célular;" +
                    "<br>2)Pressione a tecla ou clique fora na célula;" +
                    "<br>3)Clique em atualizar.</html>");
            this.controlador.abrirTelaPesquisaFilme();
        });
    }
}
