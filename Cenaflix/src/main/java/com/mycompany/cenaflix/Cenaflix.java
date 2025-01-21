package com.mycompany.cenaflix;

/*
*
*@author Carlos Alexandre
*@version 1.0
* Está é a classe principal.
* Função: Acionar o "JFrameMenuPrincipal".
* Descrição: Ativar p JFrameMenuPrincipal que é o primeiro JFrame a ser exibido.
* @see JFrameMenuPrincipal
* Local: Cenaflix\src\main\java\com\mycompany\cenaflix\menuprincipal
*/

import com.mycompany.cenaflix.menuprincipal.JFrameMenuPrincipal;

/**
 *
 * @author carlos.sa
 */
public class Cenaflix {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new JFrameMenuPrincipal().setVisible(true);
    }
}
