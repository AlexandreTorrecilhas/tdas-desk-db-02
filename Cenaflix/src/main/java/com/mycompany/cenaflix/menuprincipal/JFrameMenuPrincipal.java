package com.mycompany.cenaflix.menuprincipal;

//Pacotes do Projeto
import com.mycompany.cenaflix.posicaotela.Coordenadas;
//Pacotes Swing
import javax.swing.*;
//Pacotes AWT
import java.awt.Dimension;
//Pacotes Util
import java.util.LinkedHashMap;

public class JFrameMenuPrincipal extends JFrame {
    //JPanels
    JPanelMenuPrincipal jPanelMenuPrincipal = new JPanelMenuPrincipal();
    BotaoNavegacaoControlador controlador = new BotaoNavegacaoControlador(jPanelMenuPrincipal.getjPanelContainerCardLayout());
    //Variáveis dessa classe
    Dimension tamanhoJFrame = new Dimension(900,500);
    Integer[] coordenadas = new Coordenadas(this.tamanhoJFrame).getCoordenadas();
    LinkedHashMap<String, JButton> mapJButton = new LinkedHashMap();
    
    public JFrameMenuPrincipal(){
        this.setConfiguracoes();
        this.addComponentes();
        this.setMapJButton();
        this.addActionListener();
        this.teste();
    }
    
    private void setConfiguracoes(){
        this.setSize(tamanhoJFrame);
        this.setLocation(coordenadas[1],coordenadas[0]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponentes(){
        this.add(jPanelMenuPrincipal);
    }
    
    private void setMapJButton(){
        this.mapJButton.put("btnAdicionarFilme", this.jPanelMenuPrincipal.getJPanelMenuNavegacao().getBtnAdicionarFilme());
        this.mapJButton.put("btnConsultarFilme", this.jPanelMenuPrincipal.getJPanelMenuNavegacao().getBtnConsultarFilme());
    }
    
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
