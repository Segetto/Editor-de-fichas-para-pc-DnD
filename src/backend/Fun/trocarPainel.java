/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author Admin
 */
public class trocarPainel {

    public void painelChange(JFrame frameNew) {
        frameNew.setVisible(true);
    }
       public void refreshFrame(JFrame frame) {
        frame.revalidate(); // Revalida o layout e componentes do frame
        frame.repaint();    // Redesenha o frame para refletir mudanças visuais
    }
}
