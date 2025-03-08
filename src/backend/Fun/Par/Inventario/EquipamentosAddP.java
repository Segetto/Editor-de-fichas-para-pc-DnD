/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import java.awt.event.MouseListener;
import backend.Fun.trocarPainel;
import javax.swing.*;
import org.json.*;
import visual.Equipamento;

/**
 *
 * @author Admin
 */
public class EquipamentosAddP {

    public static void EquipamentosAddP(String personagemCaminho, JSONObject ficha, JPanel AddEquip, JPanel FichaEquip, JSONArray itens, JLabel BonusCALabel) {
        Equipamento novoFrame = new Equipamento(personagemCaminho, ficha, FichaEquip, itens, BonusCALabel, AddEquip);
        novoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (MouseListener ml : AddEquip.getMouseListeners()) {
            AddEquip.removeMouseListener(ml);
        }
        System.gc();
        AddEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                mudar.painelChange(novoFrame);
            }
        });
    }
}
