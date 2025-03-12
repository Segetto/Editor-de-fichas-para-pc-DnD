/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import javax.swing.*;
import java.awt.event.*;
import org.json.*;

/**
 *
 * @author Admin
 */
public class ChangeMochilaIcon {

    public static void ChangeMochilaIcon(String personagemCaminho, JSONObject ficha, JPanel AddEquip, JLabel MochilaIcon) {
        AddEquip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon MochilaAberta = new ImageIcon("src/visual/res/MochilaAberta.png");
                MochilaIcon.setIcon(MochilaAberta);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon MochilaFechada = new ImageIcon("src/visual/res/MochilaFechada.png");
                MochilaIcon.setIcon(MochilaFechada);
            }
        });
    }
}
