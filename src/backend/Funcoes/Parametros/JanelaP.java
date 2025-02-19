/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes.Parametros;

import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class JanelaP {
        public static void JanelaP(JPanel janela) {
        janela.requestFocusInWindow();

        janela.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                janela.requestFocusInWindow();
            }
        });
    }
}
